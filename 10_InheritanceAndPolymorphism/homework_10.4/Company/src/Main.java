import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(company));
        }
        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager(company));
        }
        for (int i = 0; i < 10; i++) {
            workers.add(new TopManager(company));
        }
        company.hireAll(workers);
        System.out.println("Доход компании " + company.getIncome());
        print(company);

        List<Employee> fireList = company.getEmployees();
        for (int i = 0; i < fireList.size() / 2; i++) {
            company.fire(fireList.get(i));
        }
        System.out.println("Уволили 50% сотрудников");
        print(company);

    }

    private static void print(Company company) {
        System.out.println("Топ зарплат");
        List<Employee> topSalaryList = company.getTopSalaryStaff(15);
        for (Employee employee : topSalaryList) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("Самые низкие зарплаты");
        List<Employee> lowSalaryList = company.getLowestSalaryStaff(30);
        for (Employee employee : lowSalaryList) {
            System.out.println(employee.getMonthSalary());
        }
    }

}
