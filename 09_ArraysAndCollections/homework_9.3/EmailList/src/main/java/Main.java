import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню: " + System.lineSeparator() +
                "ADD - Добавить новую почту в список" + System.lineSeparator() +
                "LIST - Вывести список почт");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String[] words = input.split("\\s");
            String command = words[0];
//            String regexEmail = "(\\d*)?([A-z]+)?([-_*])?([A-z]+)?(\\d*)?(@)([A-z]+)(.)([A-z]+)";
//            String regexEmail = "(\\d*)?([A-z]+)(\\d*)?(@)([A-z]+)(.)";
//            String regexEmail = ("(LIST)|(ADD)(\\s\\w+@\\w+\\.\\D+)");
//            String regexEmail = ("(\\w+@\\w+\\.\\D+)");

            //TODO: write code here

            switch (command) {
                case "ADD":
                    if (words.length > 1) {
                        if (emailList.isValidEmail(words[1])) {
                            emailList.add(words[1]);
                        } else {
                            System.out.println(WRONG_EMAIL_ANSWER);
                        }
                    } else {
                        System.out.println("Заданы неверные параметры команды");
                    }
                    break;
                case "LIST":
                    if (emailList.getSortedEmails().isEmpty()) {
                        System.out.println("Список почт пуст. Добавьте почту");
                    } else {
                        System.out.println(emailList.toString());
                    }
                    break;
                default:
                    System.out.println("Неверная команда.");
            }

//            if (!words[0].equals("ADD") && !words[0].equals("LIST")){
//                System.out.println("Неверная команда.");
//            } else {
//                if (input.contains("ADD") && words.length != 1){
//                    if (!input.contains("@") || !input.toLowerCase(Locale.ROOT).contains(".ru")){
//                        System.out.println(WRONG_EMAIL_ANSWER);
//                    } else {
//                        emailList.add(words[1]);
//                    }
//                } else if (input.contains("LIST")){
//                    if (emailList.getSortedEmails().isEmpty()){
//                        System.out.println("Список почт пуст. Добавьте почту");
//                    } else {
//                        System.out.println(emailList.toString());
//                    }
//                }
//            }
        }
    }
}
