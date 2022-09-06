public class Operator implements Employee{

//    private final int SALARY = 50000;
    private final int SALARY = profit(30000, 50000);
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return SALARY;
    }

}
