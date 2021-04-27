package lesson_30.deadlock;

import lombok.Data;

@Data
public class Teacher {
    private Student student;

    public synchronized String getTeacherPhrase() {
        return "You are late";
    }

    public synchronized String getNameFromStudent() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return student.getStudentName();
    }
}
