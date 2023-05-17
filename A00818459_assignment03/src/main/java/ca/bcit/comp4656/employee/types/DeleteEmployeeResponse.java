
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
 *         &amp;lt;element name="deleteResponseCode" type="{http://www.bcit.ca/comp4656/employee/types}responseCode"/&amp;gt;
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
    "deleteResponseCode"
})
@XmlRootElement(name = "deleteEmployeeResponse")
public class DeleteEmployeeResponse {

    @XmlElement(required = true)
    protected ResponseCode deleteResponseCode;

    /**
     * Gets the value of the deleteResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCode }
     *     
     */
    public ResponseCode getDeleteResponseCode() {
        return deleteResponseCode;
    }

    /**
     * Sets the value of the deleteResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCode }
     *     
     */
    public void setDeleteResponseCode(ResponseCode value) {
        this.deleteResponseCode = value;
    }

}
