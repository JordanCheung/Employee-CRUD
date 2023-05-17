
package ca.bcit.comp4656.employee.operations;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ca.bcit.comp4656.employee.types.AddEmployeeRequest;
import ca.bcit.comp4656.employee.types.AddEmployeeResponse;
import ca.bcit.comp4656.employee.types.DeleteEmployeeRequest;
import ca.bcit.comp4656.employee.types.DeleteEmployeeResponse;
import ca.bcit.comp4656.employee.types.EmployeeListResponse;
import ca.bcit.comp4656.employee.types.FindEmployeeRequest;
import ca.bcit.comp4656.employee.types.FindEmployeeResponse;
import ca.bcit.comp4656.employee.types.NumberOfEmployeesResponse;
import ca.bcit.comp4656.employee.types.ObjectFactory;
import ca.bcit.comp4656.employee.types.Void;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeServicePort", targetNamespace = "http://www.bcit.ca/comp4656/employee/services")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeServicePort {


    /**
     * 
     * @param findEmployeeReq
     * @return
     *     returns ca.bcit.comp4656.employee.types.FindEmployeeResponse
     */
    @WebMethod
    @WebResult(name = "findEmployeeResponse", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "findEmployeeRes")
    public FindEmployeeResponse findEmployeeOperation(
        @WebParam(name = "findEmployeeRequest", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "findEmployeeReq")
        FindEmployeeRequest findEmployeeReq);

    /**
     * 
     * @param addEmployeeReq
     * @return
     *     returns ca.bcit.comp4656.employee.types.AddEmployeeResponse
     */
    @WebMethod
    @WebResult(name = "addEmployeeResponse", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "addEmployeeRes")
    public AddEmployeeResponse addEmployeeOperation(
        @WebParam(name = "addEmployeeRequest", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "addEmployeeReq")
        AddEmployeeRequest addEmployeeReq);

    /**
     * 
     * @param numberOfEmployeesReq
     * @return
     *     returns ca.bcit.comp4656.employee.types.NumberOfEmployeesResponse
     */
    @WebMethod
    @WebResult(name = "numberOfEmployeesResponse", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "numberOfEmployeesRes")
    public NumberOfEmployeesResponse numberOfEmployeesOperation(
        @WebParam(name = "numberOfEmployeesRequest", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "numberOfEmployeesReq")
        Void numberOfEmployeesReq);

    /**
     * 
     * @param employeeListReq
     * @return
     *     returns ca.bcit.comp4656.employee.types.EmployeeListResponse
     */
    @WebMethod
    @WebResult(name = "employeeListResponse", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "employeeListRes")
    public EmployeeListResponse employeeListOperation(
        @WebParam(name = "employeeListRequest", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "employeeListReq")
        Void employeeListReq);

    /**
     * 
     * @param deleteEmployeeReq
     * @return
     *     returns ca.bcit.comp4656.employee.types.DeleteEmployeeResponse
     */
    @WebMethod
    @WebResult(name = "deleteEmployeeResponse", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "deleteEmployeeRes")
    public DeleteEmployeeResponse deleteEmployeeOperation(
        @WebParam(name = "deleteEmployeeRequest", targetNamespace = "http://www.bcit.ca/comp4656/employee/types", partName = "deleteEmployeeReq")
        DeleteEmployeeRequest deleteEmployeeReq);

}