package lesson_31.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeMethods {
    Lock lock = new ReentrantLock();

    public void eat() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " I'm eating");
    }

    public void drink() {
        System.out.println(Thread.currentThread().getName() + " I'm drinking");
    }

    public void nothing() {
        System.out.println(Thread.currentThread().getName() + " I'm not doing anything");
        lock.unlock();
    }
}
