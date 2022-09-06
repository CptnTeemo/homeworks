import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

//        Optional<Employee> optional = staff.stream()
//                .filter(e -> e.getWorkStart().getYear() + 1900 == year)
//                .max(Comparator.comparing(Employee::getSalary));
//        Employee employee = optional.get();
//        return employee;

        return staff.stream()
                .filter(e -> toLocalDate(e.getWorkStart()).getYear() == year)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    private static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}