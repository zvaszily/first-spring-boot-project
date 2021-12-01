package hu.nye.firstspringbootproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Users {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Boolean teacher;
    @OneToMany(mappedBy = "users")
    private List<Exams> exams;
}
