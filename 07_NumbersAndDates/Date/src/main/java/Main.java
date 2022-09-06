import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        String listOfBirthday = "";
        int dateDifference = today.getYear() - birthday.getYear();

        for (int i = 0; i <= dateDifference; i++){
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(i + " - dd.MM.yyyy - E").localizedBy(new Locale("us"));
            if (birthday.plusYears(i).isBefore(today)){
                listOfBirthday += formatter.format(birthday.plusYears(i)) + System.lineSeparator();
            } else if (birthday.plusYears(i).equals(today)){
                listOfBirthday += formatter.format(birthday.plusYears(i)) + System.lineSeparator();
            }
        }
        return listOfBirthday;
    }
}
