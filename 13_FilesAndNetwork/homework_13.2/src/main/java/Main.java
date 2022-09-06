import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к исходной папке:");
        String source = scanner.nextLine();
        System.out.println("Введите путь к папке, в которую следует скопировать исходную:");
        String destination = scanner.nextLine();
        FileUtils.copyFolder(source, destination);
        System.out.println("Копирование завершено.");
    }
}
