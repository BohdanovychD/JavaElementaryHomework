package lesson_30.thread;

import lesson_30.helper.UseThread;

public class FirstThread extends Thread {
    private static Integer threadCounter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread.currentThread().setName("Thread from First Class: " + threadCounter++);
            UseThread.incrementMethod();
        }
    }
}
