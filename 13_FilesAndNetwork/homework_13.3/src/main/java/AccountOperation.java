import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccountOperation {

    private String operationDetails;
    private double income;
    private double expense;

    public AccountOperation(String operationDetails,
                            double income, double expense) {
        this.operationDetails = operationDetails;
        this.income = income;
        this.expense = expense;
    }

    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String getOperationDetails() {
        return operationDetails;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public static List<AccountOperation> getAccountOperations(String path) {
        List<AccountOperation> accountOperations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.remove(0);
//            for (String line : lines) {
//                String formatSum = line.replaceAll("(\")(\\d+)(,)(\\d+)(\")", "$2.$4");
//                String replaceRegex = "(\\d+\\++\\d+\\s+)(\\d+)?(.*\\s)" +
//                        "(\\s+\\d+.\\d+.\\d+\\s+\\d+.\\d+.\\d+)(.)*(,\\d+,.*)";
//                String formatCompanyName =
//                        formatSum.replaceAll(replaceRegex, "$3$6");
//                String[] fragments = formatCompanyName.split(",");
//                if (fragments.length != 8) {
//                    System.out.println("Wrong line: " + formatCompanyName);
//                    continue;
//                }
//                accountOperations.add(new AccountOperation(
//                        fragments[5].replaceAll("(\\\\|/)","").trim(),
//                        Double.parseDouble(fragments[6]),
//                        Double.parseDouble(fragments[7])
//                ));
//            }

            for (String line : lines) {
                String formatSum = line.replaceAll("(\")(\\d+)(,)(\\d+)(\")", "$2.$4");
                String[] fragments = formatSum.split(",");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + formatSum);
                    continue;
                }
                String replaceRegex = "(\\d+\\D+\\d+)(.*)(\\\\|\\/)(.*)(\\s)(\\s+\\d\\d\\.\\d\\d\\..*)";
                accountOperations.add(new AccountOperation(
                        fragments[5].replaceAll(replaceRegex,"$4").trim(),
                        Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accountOperations;
    }

    public String toString() {
        return operationDetails + " | " +
                income + " | " + expense;
    }
}
