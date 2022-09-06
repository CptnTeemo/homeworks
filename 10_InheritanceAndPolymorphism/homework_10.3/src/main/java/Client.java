public abstract class Client {

    private double bill;

    public double getAmount() {
        return bill;
    }

    public void setAmount(double bill) {
        this.bill = bill;
    }

    public void put(double amountToPut) {
        if (!isNegativeAmount(amountToPut)) {
            setAmount(getAmount() + amountToPut);
            System.out.println("Вы пополнили счёт на " + amountToPut + " руб." +
                    " На вашем счете " + getAmount() + " руб.");
        } else {
            System.out.println("Вы не можете пополнить счёт на отрицательное значение");
        }
    }

    public void take(double amountToTake) {
        if (isNegativeAmount(amountToTake)) {
            System.out.println("Вы не можете снять со счёта отрицательное значение");
            return;
        }
        if (amountToTake > getAmount()) {
            System.out.println("На вашем счете " + getAmount() + " руб." +
                    " Вы не можете снять " + amountToTake);
        } else {
            setAmount(getAmount() - amountToTake);
            System.out.println("Вы сняли со счета " + amountToTake + " руб." +
                    " На вашем счете осталось " + getAmount());
        }
    }

    public boolean isNegativeAmount(double amount) {
        return amount < 0;
    }

    public abstract void details();

}
