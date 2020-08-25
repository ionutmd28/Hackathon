package org.example.rest.apps;


public class SimpleTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task started " + Thread.currentThread().getName());
    }
}
