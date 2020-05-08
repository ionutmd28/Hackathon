package soapdocument;

import javax.jws.WebService;

@WebService(endpointInterface = "soapdocument.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello world, this is a document Jax-Ws example" + name;
    }
}
