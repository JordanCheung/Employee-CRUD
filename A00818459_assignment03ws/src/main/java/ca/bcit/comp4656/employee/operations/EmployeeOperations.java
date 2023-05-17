package ca.bcit.comp4656.employee.operations;

import javax.ejb.EJB;
import javax.jws.WebService;

import ca.bcit.comp4656.employee.services.EmployeeServicePort;
import ca.bcit.comp4656.employee.types.AddEmployeeRequest;
import ca.bcit.comp4656.employee.types.AddEmployeeResponse;
import ca.bcit.comp4656.employee.types.DeleteEmployeeRequest;
import ca.bcit.comp4656.employee.types.DeleteEmployeeResponse;
import ca.bcit.comp4656.employee.types.EmployeeListResponse;
import ca.bcit.comp4656.employee.types.FindEmployeeRequest;
import ca.bcit.comp4656.employee.types.FindEmployeeResponse;
import ca.bcit.comp4656.employee.types.NumberOfEmployeesResponse;
import ca.bcit.comp4656.employee.types.Void;

@WebService(endpointInterface="ca.bcit.comp4656.employee.services.EmployeeServicePort")
public class EmployeeOperations implements EmployeeServicePort {

	@EJB //(mappedName="java:global/A00818459ws/EmployeeBeanImpl!ca.bcit.comp4656.employee.operations.EmployeeBean")
	private EmployeeBean employeeBean;
	
	@Override
	public NumberOfEmployeesResponse numberOfEmployeesOperation(Void numberOfEmployeesReq) {
		return employeeBean.numberOfEmployeesOperation(numberOfEmployeesReq);
	}

	@Override
	public EmployeeListResponse employeeListOperation(Void employeeListReq) {
		return employeeBean.employeeListOperation(employeeListReq);
	}

	@Override
	public AddEmployeeResponse addEmployeeOperation(AddEmployeeRequest addEmployeeReq) {
		return employeeBean.addEmployeeOperation(addEmployeeReq);
	}

	@Override
	public DeleteEmployeeResponse deleteEmployeeOperation(DeleteEmployeeRequest deleteEmployeeReq) {
		return employeeBean.deleteEmployeeOperation(deleteEmployeeReq);
	}

	@Override
	public FindEmployeeResponse findEmployeeOperation(FindEmployeeRequest findEmployeeReq) {
		return employeeBean.findEmployeeOperation(findEmployeeReq);
	}

}
