package lesson_31;


import lesson_31.lock.ThreeMethods;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger atomicInteger = new AtomicInteger(15000);
    private static ThreeMethods threeMethods = new ThreeMethods();

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("FIRST TASK");
        Object key = new Object();

        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("First thread");
            synchronized (key) {
                incrementMethod();
            }
        });

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("Second thread");
            synchronized (key) {
                incrementMethod();
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println("SECOND TASK");

        Thread lockThread1 = new Thread(new Runnable() {
            private ThreeMethods someMethods = threeMethods;

            @Override
            public void run() {
                someMethods.eat();
                someMethods.drink();
                someMethods.nothing();
            }
        });

        Thread lockThread2 = new Thread(new Runnable() {
            private ThreeMethods someMethods = threeMethods;

            @Override
            public void run() {
                someMethods.eat();
                someMethods.drink();
                someMethods.nothing();
            }
        });

        Thread lockThread3 = new Thread(new Runnable() {
            private ThreeMethods someMethods = threeMethods;

            @Override
            public void run() {
                someMethods.eat();
                someMethods.drink();
                someMethods.nothing();
            }
        });
        lockThread1.start();
        lockThread2.start();
        lockThread3.start();
    }

    private static void incrementMethod() {
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                atomicInteger.decrementAndGet();
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Decrement atomicInteger: " + Thread.currentThread().getName() + " " + atomicInteger.get());
    }
}
