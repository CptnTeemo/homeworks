import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        System.out.println(student.getName() + " - " + student.getAge() + " лет, " +
                "зарегистрирован: " + formatter.format(student.getRegistrationDate()) +
                ", курсы: " + student.getCourses() + ", подписки: " +
                student.getSubscriptions());

        Integer courseId = student.getCourses().get(0).getId();
        Integer studentId = student.getId();

        Subscription subscription = session.get(Subscription.class, new SubscriptionKey(studentId, courseId));
        System.out.println(subscription);

        Teacher teacher = session.get(Teacher.class, 4);
        System.out.println(teacher);

        List<Object[]> list = session.createNativeQuery("SELECT purchaselist.course_name AS course_name, " +
                "purchaselist.student_name AS student_name,\n" +
                "courses.id AS course_id, students.id AS student_id\n" +
                "FROM purchaselist\n" +
                "JOIN courses ON courses.name = purchaselist.course_name\n" +
                "JOIN students ON students.name = purchaselist.student_name")
                .list();

        insertDataInTable(list, session);

        ConnectionToDataBase.setTransactionCommit();
        ConnectionToDataBase.closeSessionFactory();

// черновой вариант CriteriaBuilder
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
//        Root<PurchaseList> root = query.from(PurchaseList.class);
//        query.select(root);
//        List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();
//        purchaseLists.forEach(System.out::println);
//        System.out.println(purchaseLists.size());

    }

    public static void insertDataInTable(List<Object[]> list, Session session) {
        list.forEach(e -> {
            Integer studentsId = (Integer) e[3];
            Integer coursesId = (Integer) e[2];
            LinkedPurchaseListKey id = new LinkedPurchaseListKey();
            id.setStudentId(studentsId);
            id.setCourseId(coursesId);
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList();
            linkedPurchase.setKeyId(id);
            session.save(linkedPurchase);
        });
    }
}