package org.example.rest.apps;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTaskListener;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CallableListenerTask implements Callable<Long>, ManagedTaskListener {
    private int id;

    public CallableListenerTask(int id) {
        this.id = id;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;

        for(int i = 0; i < id; i ++) {
            sum = sum + i;
        }

        return sum;
    }

    @Override
    public void taskSubmitted(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        System.out.println("The task was submited " + future);
    }

    @Override
    public void taskAborted(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        System.out.println("Task is aborted " + future);
    }

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        System.out.println("Task is done " + future);
    }

    @Override
    public void taskStarting(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        System.out.println("Task is starting " + future);
    }
}
