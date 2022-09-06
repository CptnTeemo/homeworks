import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        staff.sort((o1, o2) -> {
//            if (o1.getSalary().compareTo(o2.getSalary()) == 0) {
//                return o1.getName().compareTo(o2.getName());
//            }
//            return o1.getSalary().compareTo(o2.getSalary());

            int bySalary = Integer.compare(o1.getSalary(), o2.getSalary());
            return (bySalary != 0) ? bySalary : o1.getName().compareTo(o2.getName());
        });
        staff.forEach(System.out::println);
    }
}