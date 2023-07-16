package org.example;

public class GreetimgImpl implements Greeting {
    @Override
    public String greet(String name) {
        return "Hello"+name;
    }
}
