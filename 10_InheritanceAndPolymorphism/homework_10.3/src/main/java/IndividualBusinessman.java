public class IndividualBusinessman extends Client {

    private static final double PREFERENTIAL_FEE = 0.995;
    private static final double STANDARD_FEE = 0.99;

    @Override
    public void details() {
        System.out.println("Информация по счёту индивидуального предпринимателя:" + System.lineSeparator() +
                "Баланс счёта: " + getAmount() + " руб." + System.lineSeparator() +
                "Снятие со счёта без комисии." + System.lineSeparator() +
                "Пополнение счёта на сумму до 1000 руб. с комиссией 1%. " + System.lineSeparator() +
                "Пополнение счёта на сумму более 1000 руб. с комиссией 0,5%.");
    }

    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut * STANDARD_FEE);
//            System.out.println("Вы пополнили счёт на " + amountToPut * STANDARD_FEE + " руб." +
//                    " с учетом комиссии. На вашем счете " + getAmount() + " руб.");
        } else {
            super.put(amountToPut * PREFERENTIAL_FEE);
//            System.out.println("Вы пополнили счёт на " + amountToPut * PREFERENTIAL_FEE + " руб." +
//                    " с учетом комиссии. На вашем счете " + getAmount() + " руб.");
        }
    }

    // старая версия
//    public void put(double amountToPut) {
//        if (!isNegativeAmount(amountToPut)) {
//            if (amountToPut < 1000){
//                setAmount(getAmount() + amountToPut * STANDARD_FEE);
//                System.out.println("Вы пополнили счёт на " + amountToPut * STANDARD_FEE + " руб." +
//                        " с учетом комиссии. На вашем счете " + getAmount() + " руб.");
//            } else {
//                setAmount(getAmount() + amountToPut * PREFERENTIAL_FEE);
//                System.out.println("Вы пополнили счёт на " + amountToPut * PREFERENTIAL_FEE + " руб." +
//                        " с учетом комиссии. На вашем счете " + getAmount() + " руб.");
//            }
//        } else {
//            System.out.println("Вы не можете пополнить счёт на отрицательное значение");
//        }
//    }

}
