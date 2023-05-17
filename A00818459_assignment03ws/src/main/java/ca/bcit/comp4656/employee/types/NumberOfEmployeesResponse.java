
package ca.bcit.comp4656.employee.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="numberOfEmployees" type="{http://www.bcit.ca/comp4656/employee/types}posInt"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numberOfEmployees"
})
@XmlRootElement(name = "numberOfEmployeesResponse")
public class NumberOfEmployeesResponse {

    protected int numberOfEmployees;

    /**
     * Gets the value of the numberOfEmployees property.
     * 
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets the value of the numberOfEmployees property.
     * 
     */
    public void setNumberOfEmployees(int value) {
        this.numberOfEmployees = value;
    }

}
