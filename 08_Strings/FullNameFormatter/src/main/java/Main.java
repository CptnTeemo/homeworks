import java.util.Scanner;
import java.util.StringJoiner;

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
      System.out.println(checkFullName(input));

    }
  }

  public static String checkFullName(String text) {
    String lastName = "";
    String firstName = "";
    String patronymic = "";
    int spaceCount = 0;
    int index = 0;
    for (int i = 0; i < text.length(); i++) {
      char symbol = text.charAt(i);
      if (Character.isDigit(symbol)) {
        return "Введенная строка не является ФИО";
      } else {
        if (symbol == ' ') {
          spaceCount++;
          index = i + 1; // запоминаем позицию буквы после пробела
          continue;
        } else {
          if ((symbol < 'А' || symbol > 'я') && // забыл проверку на кириллицу
                  symbol != 'ё' && symbol != '-'){
            return "Введенная строка не является ФИО";
          }
        }
        if (spaceCount == 0){
//          lastName += symbol; // закомментированные строки также проходят тесты
          lastName = text.substring(0, i + 1); // причем можно оставить любую
        } else if (spaceCount == 1){
//          firstName += symbol;
          firstName = text.substring(index, i + 1);
        } else {
//          patronymic += symbol;
          patronymic = text.substring(index, i + 1);
        }
      }
    }

    if (spaceCount > 2){
      return "Введенная строка не является ФИО";
    }
    if(firstName.isEmpty() || patronymic.isEmpty()){
      return "Введенная строка не является ФИО";
    }

    String template = "Фамилия: %s" + System.lineSeparator() +
            "Имя: %s" + System.lineSeparator() +
            "Отчество: %s";
    String result = String.format(template, lastName, firstName, patronymic);

    return result;

    // а тут неудачная попытка реализации условия в цикле
    //        if (symbol != ' ') {
//          int end = text.indexOf(" ", i);
//          lastName += symbol;
//          if (end < 0) {
//            patronymic += symbol;
//          } else {
//            spaceCount++;
//            if (spaceCount == 0){
//              lastName += symbol;
//            } else if (spaceCount == 1){
//              firstName += symbol;
//            }
//
//          }
//        }

  }
}