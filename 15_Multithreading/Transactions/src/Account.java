public class Account {
    private static final String[] LETTERS_LIST = {"А", "В", "Е", "К", "М",
            "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final String[] FIRST_NAMES_LIST = {"Иван", "Анастасия", "Екатерина", "Кирилл", "Михаил",
            "Надежда", "Олег", "Роман", "Станислав", "Таисия", "Уля", "Ходор"};
    private static final String[] LAST_NAMES_LIST = {"Поттер", "Бородач", "Цыпа", "Кайзер", "Горошек",
            "Лукошко", "Заяц", "Катер", "Кура", "Белочка", "Медведь", "Картофель", "Горшочек", "Колобок"};
    private long money;
    private String accNumber;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean take(long amountToTake) {
        if (isNegativeAmount(amountToTake)) {
            System.out.println("Вы не можете снять со счёта отрицательное значение");
            return false;
        }
        if (amountToTake > getMoney()) {
//            System.out.println("На вашем счете " + getMoney() + " руб." +
//                    " Вы не можете снять " + amountToTake);
            return false;
        } else {
            setMoney(getMoney() - amountToTake);
//            System.out.println("Вы сняли со счета " + amountToTake + " руб." +
//                    " На вашем счете осталось " + getMoney());
            return true;
        }
    }

    public void put(long amountToPut) {
        if (!isNegativeAmount(amountToPut)) {
            setMoney(getMoney() + amountToPut);
//            System.out.println("Вы пополнили счёт на " + amountToPut + " руб." +
//                    " На вашем счете " + getMoney() + " руб.");
        } else {
            System.out.println("Вы не можете пополнить счёт на отрицательное значение");
        }
    }

    public boolean isNegativeAmount(long amount) {
        return amount < 0;
    }

//    public String generateAccountNumber() {
//        String accountNumber = "";
//        return accountNumber;
//    }

    public static String generateNumber() {
//        int min = 1;
//        int max = 9;
        StringBuilder numbers = new StringBuilder();
//        int random = (int) Math.round(((Math.random() * (max - min)) + min));
        for (int i = 0; i < 4; i++) {
            numbers.append(randomDigit(0, 9));
        }
        return numbers.toString();
    }

    public static int randomDigit(int min, int max) {
//        int min = 0;
//        int max = 9;
        return (int) Math.round(((Math.random() * (max - min)) + min));
    }

    public static int generateIndex(int maxArraySize) {
        int min = 0;
        int max = maxArraySize - 1;
        int random = (int) Math.round(((Math.random() * (max - min)) + min));
        return random;
    }

    public static String generateAccountNumber() {
        int lettersArraySize = LETTERS_LIST.length;
        String accountNumber = LETTERS_LIST[generateIndex(lettersArraySize)] +
                LETTERS_LIST[generateIndex(lettersArraySize)] + LETTERS_LIST[generateIndex(lettersArraySize)] +
                "-" + generateNumber() + LETTERS_LIST[generateIndex(lettersArraySize)] +
                LETTERS_LIST[generateIndex(lettersArraySize)];
        return accountNumber;
    }

    public static long generateMoneyAmount() {
        long minMoneyAmount = 20_000L;
        long maxMoneyAmount = 500_000L;
        return Math.round(((Math.random() * (maxMoneyAmount - minMoneyAmount)) + minMoneyAmount));
    }

    public static String generateAccountName() {
        int firstNameArraySize = FIRST_NAMES_LIST.length;
        int lastNameArraySize = LAST_NAMES_LIST.length;
        String firstName = FIRST_NAMES_LIST[generateIndex(firstNameArraySize)];
        String lastName = LAST_NAMES_LIST[generateIndex(lastNameArraySize)];
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                '}';
    }
}
