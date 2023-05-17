package ca.bcit.comp4656.employee.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class EmployeeFacadeImpl implements EmployeeFacade {

	private EntityManager entityManager = null;
	private UserTransaction userTransaction = null;
	private static EmployeeFacadeImpl employeeFacadeImpl = null;
	
	public static synchronized EmployeeFacadeImpl getInstance(EntityManager entityManager, UserTransaction userTransaction) {
		if (employeeFacadeImpl != null) {
			return employeeFacadeImpl;
		} else {
			return new EmployeeFacadeImpl(entityManager, userTransaction);
		}
	}
	
	private EmployeeFacadeImpl(EntityManager entityManager, UserTransaction userTransaction) {
		this.entityManager = entityManager;
		this.userTransaction = userTransaction;
	}

	public int getNumberOfEmployees() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<EmployeeEntity> rt = cq.from(EmployeeEntity.class);
		
		cq.select(cb.count(rt));
		Query q = entityManager.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
	
	@Override
	public List<EmployeeEntity> getEmployeeList() {
		return entityManager.createNamedQuery("Employee.getEmployeeList", EmployeeEntity.class).getResultList();
	}
	
	@Override
	public EmployeeEntity findEmployeeById(String id) {
		try {
			TypedQuery<EmployeeEntity> query = entityManager.createNamedQuery("Employee.findEmployeeById", EmployeeEntity.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public boolean addEmployee(EmployeeEntity employee) throws
			NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		userTransaction.begin();
		entityManager.persist(employee);
		userTransaction.commit();
		return true;
	}
	
	@Override
	public boolean deleteEmployeeById(String id) throws
			NotSupportedException, SystemException, SecurityException, IllegalStateException, 
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		userTransaction.begin();
		Query query = entityManager.createNamedQuery("Employee.deleteEmployeeById");
		query.setParameter("id", id);
		int deletedRows = query.executeUpdate();
		boolean success = deletedRows == 1 ? true : false;
		userTransaction.commit();
		return success;
	}

}
