import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      System.out.println(getFullNameFormat(input));
    }
  }

  public static String getFullNameFormat(String input){

    String result = "";
    String regexIsCyrillic = "[А-я-]+[\\s][А-я]+[\\s][А-я]+";

    if (!input.matches(regexIsCyrillic)) {
      return "Введенная строка не является ФИО";
    } else {
      String[] words = input.split("\\s");
        String template = "Фамилия: %s" + System.lineSeparator() +
                "Имя: %s" + System.lineSeparator() +
                "Отчество: %s";
        result = String.format(template, words[0], words[1], words[2]);
      }
    return result;
  }

}