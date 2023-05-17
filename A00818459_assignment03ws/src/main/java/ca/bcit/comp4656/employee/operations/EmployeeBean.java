package ca.bcit.comp4656.employee.operations;

import javax.ejb.Local;

import ca.bcit.comp4656.employee.types.AddEmployeeRequest;
import ca.bcit.comp4656.employee.types.AddEmployeeResponse;
import ca.bcit.comp4656.employee.types.DeleteEmployeeRequest;
import ca.bcit.comp4656.employee.types.DeleteEmployeeResponse;
import ca.bcit.comp4656.employee.types.EmployeeListResponse;
import ca.bcit.comp4656.employee.types.FindEmployeeRequest;
import ca.bcit.comp4656.employee.types.FindEmployeeResponse;
import ca.bcit.comp4656.employee.types.NumberOfEmployeesResponse;
import ca.bcit.comp4656.employee.types.Void;

@Local
public interface EmployeeBean {
	NumberOfEmployeesResponse numberOfEmployeesOperation(Void numberOfEmployeesReq);
	EmployeeListResponse employeeListOperation(Void employeeListReq);
	AddEmployeeResponse addEmployeeOperation(AddEmployeeRequest addEmployeeReq);
	DeleteEmployeeResponse deleteEmployeeOperation(DeleteEmployeeRequest deleteEmployeeReq);
	FindEmployeeResponse findEmployeeOperation(FindEmployeeRequest findEmployeeReq);
}
