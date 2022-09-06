public class CardAccount extends BankAccount  {

    private final double FEE = 1.01;


    public boolean take(double amountToTake){
        return super.take(amountToTake * FEE);
    }

    //    public boolean take(double amountToTake){
//        if (isNegativeAmount(amountToTake)){
//            System.out.println("Вы не можете снять со счёта отрицательное значение");
//            return false;
//        }
//        if (getAmount() - (amountToTake * FEE) < 0){
//            System.out.println("На вашем счете " + getAmount() + " руб." +
//                    " Вы не можете снять " + amountToTake);
//            return false;
//        }
//        setAmount(getAmount() - amountToTake * FEE);
//        System.out.println("Вы сняли со счета " + amountToTake * FEE + " руб." +
//                " У вас осталось " + getAmount());
//        return true;

}
