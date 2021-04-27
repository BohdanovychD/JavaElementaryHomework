package lesson_30.thread;

import lesson_30.helper.UseThread;

public class SecondThread implements Runnable {
    private static Integer threadCounter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread.currentThread().setName("Thread from Second Class: " + threadCounter++);
            UseThread.incrementMethod();
        }
    }
}
