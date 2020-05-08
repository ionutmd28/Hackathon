package soapdocument;

import soapdocument.generated.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorldClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/SOAP-document/hello?wsdl");
        QName qName = new QName("http://soapdocument/","HelloWorldImplService");
        Service service = Service.create(url, qName);
        HelloWorld helloWorldDoc = service.getPort(HelloWorld.class);
        System.out.println(helloWorldDoc.getHelloWorldAsString(", Ionut"));
    }
}
