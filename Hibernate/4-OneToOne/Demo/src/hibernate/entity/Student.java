package hibernate.entity;

import javax.persistence.*;


@Entity
@Table(name = "student")
public class Student {

//    public Student(String name, String surname, String email) {
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
//    }


    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
    }

    public Student() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

/*    @Column(name = "email")
    private String email;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private StudentDetail studentDetail;

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public StudentDetail getStudentDetail() {
        return studentDetail;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +

                '}';
    }
}
