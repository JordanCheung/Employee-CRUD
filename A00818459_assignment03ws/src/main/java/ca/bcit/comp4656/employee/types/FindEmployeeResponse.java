
package ca.bcit.comp4656.employee.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &amp;lt;element name="findResult" type="{http://www.bcit.ca/comp4656/employee/types}employee"/&amp;gt;
 *         &amp;lt;element name="findResponseCode" type="{http://www.bcit.ca/comp4656/employee/types}responseCode"/&amp;gt;
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
    "findResult",
    "findResponseCode"
})
@XmlRootElement(name = "findEmployeeResponse")
public class FindEmployeeResponse {

    @XmlElement(required = true)
    protected Employee findResult;
    @XmlElement(required = true)
    protected ResponseCode findResponseCode;

    /**
     * Gets the value of the findResult property.
     * 
     * @return
     *     possible object is
     *     {@link Employee }
     *     
     */
    public Employee getFindResult() {
        return findResult;
    }

    /**
     * Sets the value of the findResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employee }
     *     
     */
    public void setFindResult(Employee value) {
        this.findResult = value;
    }

    /**
     * Gets the value of the findResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCode }
     *     
     */
    public ResponseCode getFindResponseCode() {
        return findResponseCode;
    }

    /**
     * Sets the value of the findResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCode }
     *     
     */
    public void setFindResponseCode(ResponseCode value) {
        this.findResponseCode = value;
    }

}
