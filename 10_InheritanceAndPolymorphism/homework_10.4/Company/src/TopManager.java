public class TopManager implements Employee {

//    private final int SALARY = 100000;
    private final int SALARY = profit(80000, 120000);
    private final int MIN_INCOME_FOR_BONUS = 10_000_000;

    private Company company;

    private final double TOP_MANAGER_PERCENT = 1.5;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > MIN_INCOME_FOR_BONUS){
            return (int) (SALARY + SALARY * TOP_MANAGER_PERCENT);
        }
        return SALARY;
    }


}
