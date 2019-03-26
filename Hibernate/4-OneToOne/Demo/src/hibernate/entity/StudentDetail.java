package hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_detail")
public class StudentDetail implements Serializable {

    @Id
    @Column(name = "email")
    private String email_id;

    @Column(name = "provider")
    private String provider;


    @OneToOne(mappedBy = "studentDetail",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Student student;

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentDetail() {

    }

    public StudentDetail(String email, String provider) {
        this.email_id = email;
        this.provider = provider;
    }

    public String getEmail() {
        return email_id;
    }

    public void setEmail(String email) {
        this.email_id = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "email='" + email_id + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
