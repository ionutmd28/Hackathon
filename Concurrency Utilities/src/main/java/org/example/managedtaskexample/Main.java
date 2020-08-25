package org.example.managedtaskexample;

import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;

public class Main {

    public static void main(String[] args) {
        Runnable managedTask = new MyManagedTask();
        Thread thread = new Thread(managedTask);

    }


}
