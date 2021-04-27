package lesson_30.thread;

import lesson_30.helper.UseThread;

import java.util.concurrent.Callable;


public class ThirdThread implements Callable<Integer> {
    private static Integer threadCounter = 0;

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            Thread.currentThread().setName("Thread from Third Class: " + threadCounter++);
            UseThread.incrementMethod();
        }
        return threadCounter;
    }
}
