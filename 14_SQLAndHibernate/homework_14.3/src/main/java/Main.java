import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Session session = ConnectionToDataBase.getSession();
        Transaction transaction = ConnectionToDataBase.getTransaction();

        Course course = session.get(Course.class, 6);
        System.out.println("На курсе \"" + course.getName() + "\" обучается " +
                course.getStudentsCount() + " студентов, а преподаёт " + course.getTeacher().getName());

        List<Students> students = course.getStudentsList();
        System.out.println("На курс подписаны студенты: ");
        students.forEach(s -> System.out.println(s.getName()));

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Students student = session.get(Students.class, 7);
        System.out.println(student.getName() + " - " +student.getAge() + " лет, " +
                "зарегистрирован: " + formatter.format(student.getRegistrationDate()) +
                ", подкиски: " + student.getCourses());

        Integer courseId = student.getCourses().get(0).getId();
        Integer studentId = student.getId();

        Subscription subscription = session.get(Subscription.class, new Key(studentId, courseId));
        System.out.println(subscription);

        Teacher teacher = session.get(Teacher.class, 4);
        System.out.println(teacher);

        ConnectionToDataBase.setTransactionCommit();
        ConnectionToDataBase.closeSessionFactory();
    }
}