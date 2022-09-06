public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.put(100);
        bankAccount.take(50);
        bankAccount.take(70);
        bankAccount.take(-60);
        bankAccount.take(30);

        System.out.println("credit");
        CardAccount cardAccount = new CardAccount();
        cardAccount.put(2.0);
        cardAccount.take(1.0);
        cardAccount.take(-1.0);
        cardAccount.take(10.0);

        System.out.println("deposit");
        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(3);
        depositAccount.put(-3);
        depositAccount.take(1.0);

        System.out.println();
        System.out.println("Счет кредитки равен " + cardAccount.getAmount() +
                " , а счет банка равен " + bankAccount.getAmount());
        System.out.println("Отправим немного денег на кредитку");
//        if (bankAccount.send(cardAccount, 10)){
//            System.out.println("Счет кредитки равен " + cardAccount.getAmount() +
//                    " , а счет банка равен " + bankAccount.getAmount());
//        }
        bankAccount.send(cardAccount, 100);
        bankAccount.send(cardAccount, 15);

    }
}
