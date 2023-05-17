
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
 *         &amp;lt;element name="addResponseCode" type="{http://www.bcit.ca/comp4656/employee/types}responseCode"/&amp;gt;
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
    "addResponseCode"
})
@XmlRootElement(name = "addEmployeeResponse")
public class AddEmployeeResponse {

    @XmlElement(required = true)
    protected ResponseCode addResponseCode;

    /**
     * Gets the value of the addResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCode }
     *     
     */
    public ResponseCode getAddResponseCode() {
        return addResponseCode;
    }

    /**
     * Sets the value of the addResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCode }
     *     
     */
    public void setAddResponseCode(ResponseCode value) {
        this.addResponseCode = value;
    }

}
