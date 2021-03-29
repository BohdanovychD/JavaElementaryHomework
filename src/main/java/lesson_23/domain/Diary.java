package lesson_23.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "diaries")
@Data
@NoArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private int number;

    @OneToOne(mappedBy = "diary", fetch = FetchType.EAGER)
    private Student student;


}
