import java.util.*;
import java.util.stream.Collectors;

public class Movements {

    List<AccountOperation> movements;

    public Movements(String pathMovementsCsv) {
        movements = AccountOperation.getAccountOperations(pathMovementsCsv);
    }

    public double getExpenseSum() {
        return movements.stream()
                .mapToDouble(AccountOperation::getExpense).sum();
    }

    public double getIncomeSum() {
        return movements.stream()
                .mapToDouble(AccountOperation::getIncome).sum();
    }

    public Map<String, Double> getExpenseSumByCompany() {
        Map<String, Double> list = movements.stream()
                .collect(Collectors.groupingBy(AccountOperation::getOperationDetails,
                        Collectors.summingDouble(AccountOperation::getExpense)));
        return new HashMap<>(list);
    }
}
