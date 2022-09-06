import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private int income = profit(2_000_000, 15_000_000);
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees){
        for (Employee employee : employees){
            hire(employee);
        }
    }

    public void fire(Employee employee){
        employees.remove(employee);
    }

    public int getIncome(){
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count){
        Collections.sort(employees);
        Collections.reverse(employees);
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count){
        Collections.sort(employees);
        return employees.subList(0, count);
    }

    public int profit(int min, int max){
        return (int) Math.round(((Math.random() * (max-min)) + min));
    }

}
