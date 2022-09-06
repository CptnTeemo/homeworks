import java.sql.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            DecimalFormat df = new DecimalFormat("###.##");

            String query = "SELECT course_name, " +
                    "COUNT(subscription_date)/ (MONTH(MAX(subscription_date)) - " +
                    "MONTH(MIN(subscription_date)) + 1) AS average_month_purchase " +
                    "FROM PurchaseList " +
                    "WHERE YEAR(subscription_date) = 2018 " +
                    "GROUP BY course_name";

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Среднее количество покупок курсов в месяц за 2018 год равно:");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String averageMonthPurchase = resultSet.getString("average_month_purchase");
                System.out.println(courseName + " - " + df.format(Double.parseDouble(averageMonthPurchase)));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
