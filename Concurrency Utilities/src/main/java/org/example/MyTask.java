package org.example;

//public class MyTask implements Runnable, ManagedTask, ManagedTaskListener {
public class MyTask implements Runnable {
    private final long counter;

    public MyTask(long counter) {
        this.counter = counter;
    }

    //Runnable methods
    @Override
    public void run() {
        long sum = 0;
        for(long i = 1 ; i < counter; i++) {
            sum = sum + i ;
        }
        System.out.println("Suma este:" + sum);
    }

//    //ManagedTask methods
//    @Override
//    public ManagedTaskListener getManagedTaskListener() {
//       System.out.println(ManagedTask.IDENTITY_NAME);
//        return null;
//    }
//
//    @Override
//    public Map<String, String> getExecutionProperties() {
//        return null;
//    }
//
//    // ManagedTaskListener methods
//    @Override
//    public void taskSubmitted(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
//        System.out.println("The task was submitted.");
//    }
//
//    @Override
//    public void taskAborted(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
//        System.out.println("The task was aborted.");
//    }
//
//    @Override
//    public void taskDone(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
//        System.out.println("The task is done.");
//    }
//
//    @Override
//    public void taskStarting(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
//        System.out.println("The task is starting.");
//    }
}
