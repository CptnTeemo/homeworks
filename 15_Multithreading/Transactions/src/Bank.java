import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(int count) {
        accounts = generateBankAccounts(count);
    }

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public boolean fraudCheck(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        if (isFraud(fromAccountNum, toAccountNum, amount) &&
                Account.randomDigit(0, 100) <= 5) {
            ifIsFraud(fromAccountNum);
            ifIsFraud(toAccountNum);
            System.out.println(fromAccountNum + " попытался перевести " +
                    amount + " руб. на аккаунт " + toAccountNum + ", но операция оказалась мошеннической");
            return true;
        }
        return false;
    }

    public void ifIsFraud(String fraudAccountName) {
        Account fraudAccount = accounts.get(fraudAccountName);
        accounts.remove(fraudAccountName);
        accounts.put("fraud - " + fraudAccountName, fraudAccount);
    }

    public static Map<String, Account> generateBankAccounts(int accountsCount) {
        Map<String, Account> newAccountsList = new HashMap<>();
        for (int i = 0; i < accountsCount; i++) {
            Account account = new Account(Account.generateMoneyAmount(), Account.generateAccountNumber());
            String name = Account.generateAccountName();
            if (!newAccountsList.containsKey(name)) {
                newAccountsList.put(name, account);
            }
        }
        return new HashMap<>(newAccountsList);
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
//    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (sameAccount(fromAccountNum, toAccountNum)) {
            return;
        }
        if (accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)) {
            Account accountFrom = accounts.get(fromAccountNum);
            Account accountTo = accounts.get(toAccountNum);
            if (amount > accountFrom.getMoney()) {
                System.out.println("Со счета " + fromAccountNum + " не может быть " +
                        "переведена сумма " + amount + " руб. Недостаточно средств.");
                return;
            }
            if (amount > 50_000L &&
                    fraudCheck(fromAccountNum, toAccountNum, amount)) {
                return;
//                if (isFraud(fromAccountNum, toAccountNum, amount) &&
//                        Account.randomDigit(0, 100) <= 5) {
//                    ifIsFraud(fromAccountNum);
//                    ifIsFraud(toAccountNum);
//                    System.out.println(fromAccountNum + " попытался перевести " +
//                            amount + " руб. на аккаунт "+ toAccountNum + ", но операция оказалась мошеннической");
//                    return;
//                }
            }
            if (accountFrom.take(amount)) {
                accountTo.put(amount);
                System.out.println("Со счета " + fromAccountNum + " на счет " +
                        toAccountNum + " была переведена сумма " + amount + " руб.");
            } else {
                System.out.println("Со счета " + fromAccountNum + " не может быть " +
                        "переведена сумма " + amount + " руб. Недостаточно средств.");
            }
            accounts.replace(fromAccountNum, accountFrom);
            accounts.replace(toAccountNum, accountTo);
        } else {
            if (!accounts.containsKey(fromAccountNum)) {
                System.out.println("Счет " + fromAccountNum +
                        " заподозрен в мошеннической операции");
            }
            if (!accounts.containsKey(toAccountNum)) {
                System.out.println("Счет " + toAccountNum +
                        " заподозрен в мошеннической операции");
            }

        }

    }

    public boolean sameAccount(String fromAccountNum, String toAccountNum) {
        return fromAccountNum.equals(toAccountNum);
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong sum = new AtomicLong(0L);
        accounts.forEach((key, value) -> {
            sum.addAndGet(value.getMoney());
        });
        return sum.longValue();
    }

    public List<String[]> getAccountNamesForTest() {
        List<String> accountNames = new ArrayList<>(accounts.keySet());
        List<String[]> accountListForTransactions = new ArrayList<>();
        for (int i = 0; i < accountNames.size() * 2; i++) {
            String[] twoAccount = new String[2];
            twoAccount[0] = accountNames.get(Account.randomDigit(0, accountNames.size() - 1));
            twoAccount[1] = accountNames.get(Account.randomDigit(0, accountNames.size() - 1));
            accountListForTransactions.add(twoAccount);
        }
//        List<int[]> indexForTransactions = new ArrayList<>();
//        for (int i = 0; i < accountList.size(); i++) {
//            int[] twoIndex = new int[2];
//            twoIndex[0] = Account.randomDigit(0, accountList.size() - 1);
//            twoIndex[1] = Account.randomDigit(0, accountList.size() - 1);
//            indexForTransactions.add(twoIndex);
//        }
//        accountListForTransactions.forEach(e -> System.out.println(Arrays.toString(e)));
        return accountListForTransactions;
    }

}
