package hu.nye.firstspringbootproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table( name = "exams" )
public class Exam {
    @Id
    @GeneratedValue
    private Long id;
    private String subject;
    private String title;
    private Date date;
    private String location;
    @ManyToMany(mappedBy = "exam")
    private Set<User> users = new HashSet<User>();

    private Exam(){} //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Exams{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", users=" + users +
                '}';
    }
}
