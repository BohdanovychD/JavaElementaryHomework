package lesson_30.deadlock;

import lombok.Data;

@Data
public class Student {
    private Teacher teacher;

    public synchronized String getStudentName() {
        return "My name is Vika";
    }

    public synchronized String getPhraseFromTeacher() {
        return teacher.getTeacherPhrase();
    }
}
