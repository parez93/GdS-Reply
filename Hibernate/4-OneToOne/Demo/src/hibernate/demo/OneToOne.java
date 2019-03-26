package hibernate.demo;

import hibernate.entity.Student;
import hibernate.entity.StudentDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Caso unidirezionale
            Student student = new Student("Federico", "Parezzan", null);
            StudentDetail studentDetail = new StudentDetail("mail@gmail.com", "Gmail");
            student.setStudentDetail(studentDetail);

            session.beginTransaction();
            System.out.println("INSERT new Student...");
            session.save(student);
            session.getTransaction().commit();

            // caso bidirezionale
            session = factory.getCurrentSession();
            session.beginTransaction();
            StudentDetail studentDetail12 = session.get(StudentDetail.class, "mail@gmail.com");
            studentDetail12.getStudent().setStudentDetail(null);
            session.delete(studentDetail12);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
