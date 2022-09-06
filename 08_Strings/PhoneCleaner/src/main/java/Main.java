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
      System.out.println(phoneCleaner(input));
    }
  }

  public static String phoneCleaner(String text) {

    String numbers = text.replaceAll("[^0-9]+", "");
    String regexCompare = "[0-9]{10,11}";
    String formattedNumbers = "";

    if (numbers.matches(regexCompare)) {
      String[] words = numbers.split("");
      if (words.length == 10){
        return "7" + numbers;
      }
      if (!words[0].equals("7") && !words[0].equals("8")) {
        return "Неверный формат номера";
      } else {
        if (words[0].equals("8")) {
          words[0] = "7";
          for (int i = 0; i < words.length; i++) {
            formattedNumbers = formattedNumbers.concat(words[i]);
          }
        } else {
          return numbers;
        }
      }
    } else{
        return "Неверный формат номера";
      }

    return formattedNumbers;
    }
  }
