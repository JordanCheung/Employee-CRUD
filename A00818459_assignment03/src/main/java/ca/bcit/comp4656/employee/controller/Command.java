package ca.bcit.comp4656.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.bcit.comp4656.employee.operations.EmployeeOperationsService;
import ca.bcit.comp4656.employee.operations.EmployeeServicePort;
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

public class Command {

	private EmployeeOperationsService service = new EmployeeOperationsService();
	private EmployeeServicePort port;
	private static Logger logger = LogManager.getLogger(Command.class.getName());

	public Command() {
		port = service.getEmployeeOperationsPort();
	}

	public void execute(HttpServletRequest request) {

		String submit = request.getParameter("submit");
		logger.info("Command is: " + submit);

		// Add Employee
		if (("Add Employee").equals(submit)) {
			addEmployee(request);
		}

		// Delete Employee
		else if (("Delete").equals(submit)) {
			deleteEmployee(request);
		}

		// Search employee
		else if (("Search").equals(submit)) {
			searchEmployee(request);
		}
		
	}

	public void getEmployees(HttpServletRequest request) {
		NumberOfEmployeesResponse countResponse = port.numberOfEmployeesOperation(null);
		EmployeeListResponse getResponse = port.employeeListOperation(null);
		request.setAttribute("role", request.isUserInRole("admin"));
		request.setAttribute("numberOfEmployees", countResponse.getNumberOfEmployees());
		request.setAttribute("employees", getResponse.getListOfEmployees());
	}

	private void addEmployee(HttpServletRequest request) {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");

		AddEmployeeRequest addRequest = new AddEmployeeRequest();
		addRequest.setId(id);
		addRequest.setFirstName(firstName);
		addRequest.setLastName(lastName);
		addRequest.setDob(dob);
		AddEmployeeResponse addResponse = port.addEmployeeOperation(addRequest);
		ResponseCode code = addResponse.getAddResponseCode();

		request.setAttribute("AddResponseCode", code);
	}

	private void deleteEmployee(HttpServletRequest request) {
		String id = request.getParameter("id");

		DeleteEmployeeRequest deleteRequest = new DeleteEmployeeRequest();
		deleteRequest.setId(id);
		DeleteEmployeeResponse deleteResponse = port.deleteEmployeeOperation(deleteRequest);
		ResponseCode code = deleteResponse.getDeleteResponseCode();

		request.setAttribute("DeleteResponseCode", code);
	}

	private void searchEmployee(HttpServletRequest request) {
		String id = request.getParameter("id");
		FindEmployeeRequest findRequest = new FindEmployeeRequest();
		findRequest.setId(id);
		FindEmployeeResponse findResponse = port.findEmployeeOperation(findRequest);
		Employee emp = findResponse.getFindResult();
		ResponseCode code = findResponse.getFindResponseCode();
		if (emp != null) {
			logger.info(String.format("Search Result: Employee [id=%s, firstName=%s, lastName=%s, dob=%s]", emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getDob()));
			String desc = String.format("%s - %s %s", code.getDescription(), emp.getFirstName(), emp.getLastName());
			code.setDescription(desc);
		}
		request.setAttribute("SearchResponseCode", code);
	}
}
