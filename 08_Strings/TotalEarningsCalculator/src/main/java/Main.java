public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    System.out.println(getTotalEarningsCalculator(text));
    
  }

  public static int getTotalEarningsCalculator(String text){
    String sumText = "";
    int sumEarning = 0;
    for (int i = 0; i < text.length(); i++){
      char symbol = text.charAt(i);
      if (Character.isDigit(symbol)){
        int end = text.indexOf(' ', i);
        sumText = text.substring(i, end);
        sumEarning = sumEarning + Integer.parseInt(sumText);
        i = end;
      } else {
        sumText = "";
      }
    }
    return sumEarning;
  }


}