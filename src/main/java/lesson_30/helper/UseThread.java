package lesson_30.helper;


public class UseThread {
    private static Integer SOME_INCREMENT = 0;

    public static void incrementMethod() {
        System.out.println(Thread.currentThread().getName() + " Current increment: " + SOME_INCREMENT++);
    }
}
