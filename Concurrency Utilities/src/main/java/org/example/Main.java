package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask(10000000L + i);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            worker.start();
            threadList.add(worker);
        }

        int running = 0;
        do {
            running = 0;
            for (Thread thread : threadList) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads. ");
        }while (running > 0);

    }
}
