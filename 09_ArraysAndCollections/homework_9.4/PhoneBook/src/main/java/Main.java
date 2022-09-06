import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню: " + System.lineSeparator() +
                "LIST - Вывести все контакты");

        while (true) {
            System.out.println(System.lineSeparator() +
                    "Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String name = "";
            String phone = "";

            if (input.equals("LIST"))
            {
                System.out.println(phoneBook.phoneBookToString());
            }
            else if (phoneBook.isValidName(input))
            {
                name = input;
                if (!phoneBook.isNameContained(name)){
                    System.out.println("Такого имени в телефонной книге нет." + System.lineSeparator() +
                            "Введите номер телефона для абонента \"" + name + "\"");
                    phone = scanner.nextLine();
                    phoneBook.addContact(phone, name);
                } else {
                    System.out.println("Контакт \"" + name + "\" уже есть в книге");
                    System.out.println(phoneBook.contactToString(name));
                }
            } else if (phoneBook.isValidPhone(input)){
                phone = input;
                if (!phoneBook.isPhoneContained(phone)){
                    System.out.println("Такого номера нет в телефонной книге." +
                            System.lineSeparator() +
                            "Введите имя абонента для номера \"" + phone + "\"");
                    name = scanner.nextLine();
                    phoneBook.addContact(phone, name);
                } else {
                    System.out.println("Контакт c телефоном \"" + phone + "\" уже есть в книге");
                    System.out.println(phoneBook.getNameByPhone(phone));
                }
            } else {
                System.out.println("Введены некоррекнтные данные");
            }
        }
    }
}
