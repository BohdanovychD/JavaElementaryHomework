package lesson_30;

import lesson_30.deadlock.Student;
import lesson_30.deadlock.Teacher;
import lesson_30.thread.FirstThread;
import lesson_30.thread.SecondThread;
import lesson_30.thread.ThirdThread;

import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirstThread firstThread = new FirstThread();
        firstThread.start();
//        firstThread.join();

        SecondThread secondThreadRun = new SecondThread();
        Thread secondThread = new Thread(secondThreadRun);
        secondThread.start();
//        secondThread.join();

        ThirdThread thirdThreadCal = new ThirdThread();
        FutureTask<Integer> futureTask = new FutureTask(thirdThreadCal);
        Thread thirdThread = new Thread(futureTask);
        thirdThread.start();
//        thirdThread.join();

        //5.1 2995 - 2999
        //5.2 2999 - 2999
        //5.3 2999 - 2999

        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.setStudent(student);
        student.setTeacher(teacher);

        Thread deadlock1 = new Thread(() -> System.out.println(teacher.getNameFromStudent()));
        Thread deadlock2 = new Thread(() -> System.out.println(student.getPhraseFromTeacher()));

        deadlock1.start();
        deadlock2.start();

    }
}
