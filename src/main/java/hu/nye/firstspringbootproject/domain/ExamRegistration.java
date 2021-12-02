package hu.nye.firstspringbootproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class ExamRegistration {

    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    Users users;
    @ManyToOne
    @JoinColumn(name = "exams_id")
    Exams exams;
    LocalDateTime registeredAt;
    int grade;



}
