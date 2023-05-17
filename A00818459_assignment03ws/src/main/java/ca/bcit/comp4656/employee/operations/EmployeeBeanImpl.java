package ca.bcit.comp4656.employee.operations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;

import ca.bcit.comp4656.employee.data.ConstraintComparator;
import ca.bcit.comp4656.employee.data.EmployeeEntity;
import ca.bcit.comp4656.employee.data.EmployeeFacadeImpl;
import ca.bcit.comp4656.employee.types.AddEmployeeRequest;
import ca.bcit.comp4656.employee.types.AddEmployeeResponse;
import ca.bcit.comp4656.employee.types.DeleteEmployeeRequest;
import ca.bcit.comp4656.employee.types.DeleteEmployeeResponse;
import ca.bcit.comp4656.employee.types.Employee;
import ca.bcit.comp4656.employee.types.EmployeeListResponse;
import ca.bcit.comp4656.employee.types.FindEmployeeRequest;
import ca.bcit.comp4656.employee.types.FindEmployeeResponse;
import ca.bcit.comp4656.employee.types.NumberOfEmployeesResponse;
import ca.bcit.comp4656.employee.types.ResponseCode;
import ca.bcit.comp4656.employee.types.Void;

@Stateless(mappedName="RemoteEmployeeEJB")
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeBeanImpl implements EmployeeBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource
	private UserTransaction userTransaction;
	
	@Override
	public NumberOfEmployeesResponse numberOfEmployeesOperation(Void numberOfEmployeesReq) {
		NumberOfEmployeesResponse response = new NumberOfEmployeesResponse();
		int count = EmployeeFacadeImpl.getInstance(entityManager, userTransaction).getNumberOfEmployees();
		response.setNumberOfEmployees(count);
		return response;
	}

	@Override
	public EmployeeListResponse employeeListOperation(Void employeeListReq) {
		EmployeeListResponse response = new EmployeeListResponse();
		List<EmployeeEntity> employeeEntities = EmployeeFacadeImpl.getInstance(entityManager, userTransaction).getEmployeeList();
		for (EmployeeEntity ee : employeeEntities) {
			Employee emp = convertEmployeeEntityToEmployee(ee);
			response.getListOfEmployees().add(emp);
		}
		return response;
	}

	@Override
	public AddEmployeeResponse addEmployeeOperation(AddEmployeeRequest addEmployeeReq) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		EmployeeEntity emp = new EmployeeEntity();
		ResponseCode code = new ResponseCode();
		boolean success = false;
		try {
			emp.setId(addEmployeeReq.getId());
			emp.setFirstName(addEmployeeReq.getFirstName());
			emp.setLastName(addEmployeeReq.getLastName());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String dateString = addEmployeeReq.getDob();
			if (dateString != null && !dateString.isBlank()) {
				LocalDate dob = LocalDate.parse(dateString, formatter);
				emp.setDob(dob);
			}
			success = EmployeeFacadeImpl.getInstance(entityManager, userTransaction).addEmployee(emp);
		} catch (RollbackException r) {
			code = getValidationErrors(r);
		} catch (DateTimeParseException d) {
			code.setCode("421");
			code.setDescription("Date format must be yyyy/MM/dd");
		} catch (Exception e) {
			code.setCode("431");
			code.setDescription(String.format("Failed to add Employee ID: %s", addEmployeeReq.getId()));
		}
		if (success) {
			code.setCode("201");
			code.setDescription("Add success: " + addEmployeeReq.getId());
		}
		response.setAddResponseCode(code);
		return response;
	}

	@Override
	public DeleteEmployeeResponse deleteEmployeeOperation(DeleteEmployeeRequest deleteEmployeeReq) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		ResponseCode code = new ResponseCode();
		boolean success = false;
		try {
			success = EmployeeFacadeImpl.getInstance(entityManager, userTransaction).deleteEmployeeById(deleteEmployeeReq.getId());
		} catch (Exception e) {
			code.setCode("412");
			code.setDescription("Unknown error occurred in delete operation");
			response.setDeleteResponseCode(code);
			return response;
		}		
		if (success) {
			code.setCode("202");
			code.setDescription(String.format("Deleted employee with ID: %s", deleteEmployeeReq.getId()));
		} else {
			code.setCode("402");
			code.setDescription(String.format("Failed to delete employee with ID: %s", deleteEmployeeReq.getId()));
		}
		response.setDeleteResponseCode(code);
		return response;
	}

	@Override
	public FindEmployeeResponse findEmployeeOperation(FindEmployeeRequest findEmployeeReq) {
		FindEmployeeResponse response = new FindEmployeeResponse();
		ResponseCode code = new ResponseCode();
		EmployeeEntity emp = EmployeeFacadeImpl.getInstance(entityManager, userTransaction).findEmployeeById(findEmployeeReq.getId());
		Employee e = convertEmployeeEntityToEmployee(emp);
		if (e != null) {
			code.setCode("203");
			code.setDescription(String.format("Found Employee with ID: %s", findEmployeeReq.getId()));
		} else {
			code.setCode("403");
			code.setDescription(String.format("No match found for ID: %s", findEmployeeReq.getId()));
		}
		response.setFindResult(e);
		response.setFindResponseCode(code);
		return response;
	}
	
	private Employee convertEmployeeEntityToEmployee(EmployeeEntity emp) {
		Employee e = null;
		if (emp != null) {
			e = new Employee();
			String dob = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			if (emp.getDob() != null) {
				dob = emp.getDob().format(formatter);
			}
			e.setId(emp.getId());
			e.setFirstName(emp.getFirstName());
			e.setLastName(emp.getLastName());
			e.setDob(dob);
		}
		return e;
	}
	
	private ResponseCode getValidationErrors(RollbackException r) {
		String code = null;
		StringBuilder sb = new StringBuilder();
		
		if (r.getCause() instanceof javax.validation.ConstraintViolationException) {
			code = "401";
			javax.validation.ConstraintViolationException j = (javax.validation.ConstraintViolationException) r.getCause();
			Set<ConstraintViolation<?>> violations = j.getConstraintViolations();
			List<ConstraintViolation<?>> errorList = new ArrayList<ConstraintViolation<?>>();
			errorList.addAll(violations);
			ConstraintComparator comparator = new ConstraintComparator();
			Collections.sort(errorList, comparator);
			for (ConstraintViolation<?> error : errorList) {
				sb.append(error.getMessage()).append("; ");
			}
		} else if (r.getCause().getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
			code = "411";
			sb.append("Employee already exists in the list");
		} else {
			code = "431";
			sb.append("Unknown error occurred in add operation");
		}
		
		ResponseCode response = new ResponseCode();
		response.setCode(code);
		response.setDescription(sb.toString());
		return response;
	}
	
	public void closeEntityManager() {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
