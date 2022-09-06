import java.text.DecimalFormat;
import java.util.*;

public class Main {

public static final String PATH = "./src/test/resources/movementList.csv";

    public static void main(String[] args) {

//        List<AccountOperation> accountOperations = AccountOperation.getAccountOperations(PATH);
//        for (AccountOperation accountOperation : accountOperations) {
//            System.out.println(accountOperation);
//        }

        Movements movementsList = new Movements(PATH);
        DecimalFormat df = new DecimalFormat("###,###.##");

        System.out.println("Сумма расходов: " +
                df.format(movementsList.getExpenseSum()) + " руб.");
        System.out.println("Сумма доходов: " +
                df.format(movementsList.getIncomeSum()) + " руб.");

        Map<String, Double> listOfCompanyExpense = movementsList.getExpenseSumByCompany();
        System.out.println("Сумма трат по каждой компании:");
        listOfCompanyExpense.entrySet().stream()
                .sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                .forEach(item -> System.out.println(item.getKey() + " - " + df.format(item.getValue()) + " руб."));
    }
}
