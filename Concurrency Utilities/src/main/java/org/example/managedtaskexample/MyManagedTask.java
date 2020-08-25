package org.example.managedtaskexample;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import java.util.Map;
import java.util.concurrent.Future;

public class MyManagedTask implements Runnable, ManagedTask, ManagedTaskListener {

    //Runnable methods
    @Override
    public void run() {
    }

    //ManagedTask methods
    @Override
    public ManagedTaskListener getManagedTaskListener() {
        ManagedTaskListener managedTaskListener;
        return null;
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        return null;
    }

    // ManagedTaskListener methods
    @Override
    public void taskSubmitted(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {

    }

    @Override
    public void taskAborted(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {

    }

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {

    }

    @Override
    public void taskStarting(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {

    }
}
