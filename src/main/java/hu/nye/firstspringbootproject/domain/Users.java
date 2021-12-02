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

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public Set<ExamRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<ExamRegistration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", teacher=" + teacher +
                ", registrations=" + registrations +
                '}';
    }
}
