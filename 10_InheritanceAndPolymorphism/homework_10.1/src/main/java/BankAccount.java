public class BankAccount {

    private double bill;

    public void setAmount(double bill) {
        this.bill = bill;
    }

    public double getAmount() {
        return bill;
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

    public boolean take(double amountToTake) {
        if (isNegativeAmount(amountToTake)) {
            System.out.println("Вы не можете снять со счёта отрицательное значение");
            return false;
        }
        if (amountToTake > getAmount()) {
            System.out.println("На вашем счете " + getAmount() + " руб." +
                    " Вы не можете снять " + amountToTake);
            return false;
        } else {
            setAmount(getAmount() - amountToTake);
            System.out.println("Вы сняли со счета " + amountToTake + " руб." +
                    " На вашем счете осталось " + getAmount());
            return true;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        if (take(amount)){
            receiver.put(amount);
            return true;
        }
        System.out.println("Перевод не осуществлен");
        return false;
    }

    public boolean isNegativeAmount(double amount) {
        return amount < 0;
    }


}
