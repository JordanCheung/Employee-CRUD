
package ca.bcit.comp4656.employee.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ca.bcit.comp4656.employee.types package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NumberOfEmployeesRequest_QNAME = new QName("http://www.bcit.ca/comp4656/employee/types", "numberOfEmployeesRequest");
    private final static QName _EmployeeListRequest_QNAME = new QName("http://www.bcit.ca/comp4656/employee/types", "employeeListRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ca.bcit.comp4656.employee.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Void }
     * 
     */
    public Void createVoid() {
        return new Void();
    }

    /**
     * Create an instance of {@link NumberOfEmployeesResponse }
     * 
     */
    public NumberOfEmployeesResponse createNumberOfEmployeesResponse() {
        return new NumberOfEmployeesResponse();
    }

    /**
     * Create an instance of {@link EmployeeListResponse }
     * 
     */
    public EmployeeListResponse createEmployeeListResponse() {
        return new EmployeeListResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link AddEmployeeRequest }
     * 
     */
    public AddEmployeeRequest createAddEmployeeRequest() {
        return new AddEmployeeRequest();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link ResponseCode }
     * 
     */
    public ResponseCode createResponseCode() {
        return new ResponseCode();
    }

    /**
     * Create an instance of {@link DeleteEmployeeRequest }
     * 
     */
    public DeleteEmployeeRequest createDeleteEmployeeRequest() {
        return new DeleteEmployeeRequest();
    }

    /**
     * Create an instance of {@link DeleteEmployeeResponse }
     * 
     */
    public DeleteEmployeeResponse createDeleteEmployeeResponse() {
        return new DeleteEmployeeResponse();
    }

    /**
     * Create an instance of {@link FindEmployeeRequest }
     * 
     */
    public FindEmployeeRequest createFindEmployeeRequest() {
        return new FindEmployeeRequest();
    }

    /**
     * Create an instance of {@link FindEmployeeResponse }
     * 
     */
    public FindEmployeeResponse createFindEmployeeResponse() {
        return new FindEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bcit.ca/comp4656/employee/types", name = "numberOfEmployeesRequest")
    public JAXBElement<Void> createNumberOfEmployeesRequest(Void value) {
        return new JAXBElement<Void>(_NumberOfEmployeesRequest_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bcit.ca/comp4656/employee/types", name = "employeeListRequest")
    public JAXBElement<Void> createEmployeeListRequest(Void value) {
        return new JAXBElement<Void>(_EmployeeListRequest_QNAME, Void.class, null, value);
    }

}
