public class LegalPerson extends Client {

    private static final double FEE = 1.01;

    @Override
    public void details() {
        System.out.println("Информация по счёту юридического лица:" + System.lineSeparator() +
                "Баланс счёта: " + getAmount() + " руб." + System.lineSeparator() +
                "Пополнение счёта без комисии. Снятие со счёта с комиссией 1%.");
    }

    public void take(double amountToTake) {
        super.take((double) Math.round(amountToTake * FEE * 100) / 100);
    }

    // старая версия
//    public void take(double amountToTake){
//        if (isNegativeAmount(amountToTake)){
//            System.out.println("Вы не можете снять со счёта отрицательное значение");
//            return;
//        }
//        if (getAmount() - (amountToTake * FEE) < 0){
//            System.out.println("На вашем счете " + getAmount() + " руб." +
//                    " Вы не можете снять " + amountToTake);
//            return;
//        }
//        setAmount(getAmount() - amountToTake * FEE);
//        System.out.println("Вы сняли со счета " + amountToTake * FEE + " руб." +
//                " У вас осталось " + getAmount());
//    }

}
