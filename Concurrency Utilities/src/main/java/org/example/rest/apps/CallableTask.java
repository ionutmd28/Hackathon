package org.example.rest.apps;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Long> {
    private int id;

    public CallableTask(int id) {
        this.id = id;
    }

    @Override
    public Long call() {
        long sum = 0;

        for(int i = 0; i < id; i++) {
            sum = sum + i;
        }
        System.out.println("The task is:" + Thread.currentThread().getName());

        return sum;
    }
}
