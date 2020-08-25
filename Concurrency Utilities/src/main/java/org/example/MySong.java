package org.example;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import java.util.Map;
import java.util.concurrent.Future;

public class MySong implements Runnable, ManagedTask, ManagedTaskListener{
    private final String[] song;
    private Integer GLOBAL_VALUE = 1;
    public MySong(String[] song) {
        this.song = song;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            if (Thread.currentThread().getName().equals("Thread-2")) {
                readValue();
                updateValue();
            } else {
                readValue();
            }
        }
    }

    public void updateValue() {
        System.out.println(Thread.currentThread().getName() + " accessed the method updateValue with value" + GLOBAL_VALUE);
        GLOBAL_VALUE += 1;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readValue() {
        System.out.println(Thread.currentThread().getName() + " accessed the method readValue with value" + GLOBAL_VALUE);
    }

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return null;
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        return null;
    }

    @Override
    public void taskSubmitted(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        System.out.println("The task:" + Thread.currentThread().getName() + " was successfully submit.");
    }

    @Override
    public void taskAborted(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        System.out.println("The task:" + Thread.currentThread().getName() + " was aborted.");
    }

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        System.out.println("The task:" + Thread.currentThread().getName() + " is done.");
    }

    @Override
    public void taskStarting(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        System.out.println("The task:" + Thread.currentThread().getName() + "has started.");
    }
}
