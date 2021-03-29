package lesson_23.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specializations")
@Data
@NoArgsConstructor
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;
    private int amountOfPlaces;

    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER)
    private Set<Student> students;

}
