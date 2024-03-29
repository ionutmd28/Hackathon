package soapdocument;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface HelloWorldDoc {
    @WebMethod
    String getHelloWorldAsString(String name);
}
