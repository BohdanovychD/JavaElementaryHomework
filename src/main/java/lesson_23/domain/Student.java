package lesson_23.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToMany
    @JoinTable(
            name = "teachers_name",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

}
