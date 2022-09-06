import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(50);
        System.out.println(bank.getAccounts().size());
        bank.getAccounts().forEach((key, value) -> System.out.println(key + " - " + value));
        long totalBankSumBefore = bank.getSumAllAccounts();
        System.out.println("Всего на всех счетах: " + totalBankSumBefore + " руб.");
        System.out.println("---------------------------");
        List<String[]> list = bank.getAccountNamesForTest();

//        list.forEach(e -> {
//            new Thread(() -> {
//                try {
//                    bank.transfer(e[0], e[1], Account.generateMoneyAmount() / 2);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
//            }).start();
//
//        });

//        list.forEach(e -> {
//            try {
//                bank.transfer(e[0], e[1], Account.generateMoneyAmount() / 2);
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//        });

        list.forEach(e -> {
            Thread thread = new Thread(() -> {
                try {
                    bank.transfer(e[0], e[1], Account.generateMoneyAmount() / 5);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        System.out.println("---------------------------");
        Map<String, Account> bankList = new TreeMap<>(bank.getAccounts());
        bankList.forEach((key, value) -> System.out.println(key + " - " + value));
        long totalBankSumAfter = bank.getSumAllAccounts();
        System.out.println("Всего на всех счетах: " + totalBankSumAfter + " руб.");
        System.out.println(totalBankSumBefore == totalBankSumAfter ?
                "Общая сумма не изменилась" : "Часть средств потерялась");

    }
}
