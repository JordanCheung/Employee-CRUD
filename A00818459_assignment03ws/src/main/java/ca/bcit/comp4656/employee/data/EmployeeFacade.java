package ca.bcit.comp4656.employee.data;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

public interface EmployeeFacade {

	int getNumberOfEmployees();
	List<EmployeeEntity> getEmployeeList();
	EmployeeEntity findEmployeeById(String id);
	boolean addEmployee(EmployeeEntity employee) throws
	NotSupportedException, SystemException, SecurityException, IllegalStateException,
	RollbackException, HeuristicMixedException, HeuristicRollbackException;
	boolean deleteEmployeeById(String id) throws
	NotSupportedException, SystemException, SecurityException, IllegalStateException, 
	RollbackException, HeuristicMixedException, HeuristicRollbackException;
}
