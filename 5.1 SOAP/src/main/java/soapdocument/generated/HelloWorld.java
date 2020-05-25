
package soapdocument.generated;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://soapdocument/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHelloWorldAsString", targetNamespace = "http://soapdocument/", className = "soapdocument.GetHelloWorldAsString")
    @ResponseWrapper(localName = "getHelloWorldAsStringResponse", targetNamespace = "http://soapdocument/", className = "soapdocument.GetHelloWorldAsStringResponse")
    @Action(input = "http://soapdocument/HelloWorld/getHelloWorldAsStringRequest", output = "http://soapdocument/HelloWorld/getHelloWorldAsStringResponse")
    public String getHelloWorldAsString(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}