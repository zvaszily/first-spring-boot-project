package hu.nye.firstspringbootproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Users {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String password;
    private Boolean teacher;
    @OneToMany(mappedBy = "users")
    Set<ExamRegistration> registrations;
}
