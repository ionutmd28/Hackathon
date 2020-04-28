package org.example;

public class NameNotFoundException extends RuntimeException {
    /**
     * excep.
     * @param name param.
     */
    public NameNotFoundException(final String name) {
        super(name + " nu a fost gasit!");
    }
}
