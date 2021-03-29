package lesson_23;

import lesson_23.domain.Diary;
import lesson_23.domain.Specialization;
import lesson_23.domain.Student;
import lesson_23.domain.Teacher;
import lesson_23.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        Student student = new Student();
        Diary diary = new Diary();
        Specialization specialization = new Specialization();

        teacher.setAge(25);
        teacher.setName("Kevin");
        teacher.setSubject("Biology");


        student.setAge(18);
        student.setDiary(diary);
        student.setName("Alinka");
        student.setSpecialization(specialization);

        specialization.setAmountOfPlaces(12);
        specialization.setName("Biology and Nature");

        diary.setNumber(180195);
        diary.setStudent(student);


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(diary);
        session.save(student);
        session.save(teacher);
        session.save(specialization);
        transaction.commit();
        session.close();
    }
}
