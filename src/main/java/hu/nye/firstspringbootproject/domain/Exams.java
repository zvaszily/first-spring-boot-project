package hu.nye.firstspringbootproject.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;


@Entity
@Builder
@Data
public class Exams {
    @GeneratedValue
    @Id
    private Long id;
    private String subject;
    private String title;
    private Date date;
    private String location;
    @ManyToOne
    private Users users;

}
