import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.now();

    public boolean take(double amountToTake) {
        if (lastIncome.plusDays(30).isAfter(LocalDate.now())){
            System.out.println("Вы можете снять деньги с депозитного счета" +
                    " только через 30 дней с момента последнего снятия");
            return false;
        } else {
            super.take(amountToTake);
            lastIncome = LocalDate.now();
            return true;
        }
    }

//    public boolean take(double amountToTake) {
//        if (isNegativeAmount(amountToTake)){
//            System.out.println("Вы не можете снять со счёта отрицательное значение");
//            return false;
//        }
//        if (amountToTake > getAmount()){
//            System.out.println("На вашем счете " + getAmount() + " руб." +
//                    " Вы не можете снять " + amountToTake);
//            return false;
//        }
//        lastIncome = LocalDate.of(2021,8,23); // проверял даты
//        Period diff = Period.between(lastIncome, LocalDate.now());
//        if (diff.getYears() <= 0 && diff.getMonths() < 1){
//        if (lastIncome.plusDays(30).isAfter(LocalDate.now())){
//            System.out.println("Вы можете снять деньги с депозитного счета" +
//                    " только через 30 дней с момента последнего снятия");
//            return false;
//        } else {
//            setAmount(getAmount() - amountToTake);
//            System.out.println("Вы сняли со счета " + amountToTake + " руб." +
//                    " На вашем счете осталось " + getAmount());
//            lastIncome = LocalDate.now();
//            return true;
        }


