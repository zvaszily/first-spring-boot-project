package hu.nye.firstspringbootproject.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Builder
@Data
public class Exams {
    @Id
    private Long id;
    private String subject;
    private String title;
    private Date date;
    private String location;
    @OneToMany(mappedBy = "exams")
    Set<ExamRegistration> registrations;

}
