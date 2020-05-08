package soapdocument;

import javax.jws.WebService;

@WebService(endpointInterface = "soapdocument.HelloWorldDoc")
public class HelloWorldDocImpl implements HelloWorldDoc {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello world, this is a document Jax-Ws example" + name;
    }
}
