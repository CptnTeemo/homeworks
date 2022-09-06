import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        System.out.println("Меню:\nLIST - распечатать список дел" +
                "\nADD - добавить новое дело или изменить существующее по номеру" +
                "\nADD номер_дела - добавить новое дело в список по номеру" +
                "\nEDIT номер_дела - редактировать дело по номеру" +
                "\nDELETE номер_дела - удалить дело из списка по номеру");
        Scanner scanner = new Scanner(System.in);

        String regex = "[0-9]+";
//        String regex = "([A-Z]+)\\s?(\\d*)?";

        while (true) {
            String input = scanner.nextLine();

            String[] words = input.split("\\s");
            String command = words[0];

            String toDo = "";
            if (input.equals("0")) {
                break;
            }

            for (int i = 0; i < words.length; i++) {
                toDo += words[i] + " ";
            }
            toDo = toDo.replaceFirst(command, "");
            if (words.length > 1 && words[1].matches(regex)){
                toDo = toDo.replaceFirst(regex, "");
            }
            
            switch (command) {
                case "LIST":
                    System.out.println(todoList.toString());
                    break;
                case "ADD":
                    if (words.length == 1) {
                        System.out.println("Неверно заданы параметры команды");
                    } else if (words[1].matches(regex)) {
                        todoList.add(Integer.parseInt(words[1]), toDo.trim());
                    } else {
                        todoList.add(toDo);
                    }
                    break;
                case "EDIT":
                    if (words.length == 1) {
                        System.out.println("Неверно заданы параметры команды");
                    } else if (words[1].matches(regex)) {
                        todoList.edit(toDo.trim(), Integer.parseInt(words[1]));
                    }
                    break;
                case "DELETE":
                    if (words.length == 1) {
                        System.out.println("Неверно заданы параметры команды");
                    } else if (words[1].matches(regex)) {
                        todoList.delete(Integer.parseInt(words[1]));
                    } else
                        break;
                default:
                    break;
            }

//            if (command.equals("LIST")) {
//                System.out.println(todoList.toString());
//            }
//            if (command.equals("ADD") && !words[1].matches(regex)) {
//                todoList.add(toDo);
//            }
//            if (command.equals("ADD") && words[1].matches(regex)) {
//                todoList.add(Integer.parseInt(words[1]), toDo.trim());
//            }
//            if (command.equals("EDIT") && words[1].matches(regex)) {
//                todoList.edit(toDo.trim(), Integer.parseInt(words[1]));
//            }
//            if (command.equals("DELETE") && words[1].matches(regex)) {
//                todoList.delete(Integer.parseInt(words[1]));
//            }
        }
    }
}
