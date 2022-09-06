public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    default int compareTo(Employee o){
        return Integer.compare(getMonthSalary(), o.getMonthSalary());
    }

    default int profit(int min, int max){
        return (int) Math.round(((Math.random() * (max-min)) + min));
    }

}
