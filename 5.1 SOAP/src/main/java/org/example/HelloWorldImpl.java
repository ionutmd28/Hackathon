package org.example;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello world Jax-Ws" + name;
    }
}
