package ca.bcit.comp4656.employee.data;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.NotNull;

@XmlRootElement
@Entity(name="Employees")
@NamedQueries( {
	@NamedQuery(name="Employee.getEmployeeList", query="SELECT e FROM Employees e"),
	@NamedQuery(name="Employee.findEmployeeById", query="SELECT e FROM Employees e WHERE e.id= :id"),
	@NamedQuery(name="Employee.deleteEmployeeById", query="DELETE FROM Employees e WHERE e.id= :id")
} )
@Table
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = 8101060353264916431L;

	@Id
	@Column(unique=true)
	@Pattern(regexp="^[A][0][0-9]{7}$", message="Invalid ID format")
	private String id;
	
	@Column
	@NotNull
	@NotEmpty(message = "First name must not be empty")
	private String firstName;
	
	@Column
	@NotNull
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;
	
	@Column
	@Past
	private LocalDate dob;
	
	public EmployeeEntity() {}
	
	/**
	 * @param id ID of the employee
	 * @param firstName First name of the employee
	 * @param lastName Last name of the employee
	 * @param dob Date of birth of the employee
	 */
	public EmployeeEntity(String id, String firstName, String lastName, LocalDate dob) {
		super();
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return String.format("EmployeeEntity [id=%s, firstName=%s, lastName=%s, dob=%s]", id, firstName, lastName, dob);
	}
	
}
