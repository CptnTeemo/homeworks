import java.time.LocalDate;
import java.time.Period;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main {

  public static void main(String[] args) {

    LocalDate javaReleaseDate = LocalDate.of(1996, 1, 21);
    System.out.println(getPeriodFromBirthday(javaReleaseDate));


  }

  private static String getPeriodFromBirthday(LocalDate birthday) {

    String timeDifference = "";

    LocalDate now = LocalDate.now();
    Period diff = Period.between(birthday, now);
    timeDifference += diff.getYears() + " years, " +
            diff.getMonths() + " months, " + diff.getDays() + "days";

    return timeDifference;
  }

}
