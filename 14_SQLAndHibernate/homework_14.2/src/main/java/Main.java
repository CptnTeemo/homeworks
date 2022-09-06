import org.hibernate.Session;

import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        Session session = ConnectionToDataBase.getSession();
        
        Course course = session.get(Course.class, 6);
        System.out.println("На курсе \"" + course.getName() + "\" обучается " +
                course.getStudentsCount() + " студентов");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Students student = session.get(Students.class, 7);
        System.out.println(student.getName() + " - " +student.getAge() + " лет, " +
                "зарегистрирован: " + formatter.format(student.getRegistrationDate()));

        ConnectionToDataBase.closeSessionFactory();
    }
}
