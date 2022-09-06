public class Manager implements Employee {

//    private int salary = 70000;
    private int salary = profit(60000, 85000);
    private final double MANAGER_PERCENT = 0.05;
    private final int MIN_PROFIT = 115_000;
    private final int MAX_PROFIT = 140_000;
    private Company company;

    public Manager(Company company) {
        int profitForCompany = profit(MIN_PROFIT, MAX_PROFIT);
        salary += profitForCompany * MANAGER_PERCENT;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

//    public int earnedMoneyForCompany(){
//        int min = 115_000;
//        int max = 140_000;
//        return (int) Math.round(((Math.random() * (max-min)) + min));
//    }
}
