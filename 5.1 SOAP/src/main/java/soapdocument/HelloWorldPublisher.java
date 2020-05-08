package soapdocument;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/SOAP-document/hello", new HelloWorldImpl());
    }
}
