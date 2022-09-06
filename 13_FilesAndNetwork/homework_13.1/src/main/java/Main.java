import java.util.Scanner;

public class Main {

    public static final double K_BYTE = 1024;
    public static final double M_BYTE = Math.pow(K_BYTE, 2);
    public static final double G_BYTE = Math.pow(K_BYTE, 3);

    public static void main(String[] args) {

        long size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        String path = scanner.nextLine();
        try {
            size = FileUtils.calculateFolderSize(path);
            printSize(size, path);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void printSize(long size, String path) {
        if (size <= M_BYTE) {
            System.out.println("Размер папки " + path + " " +
                    (double) Math.round((size / K_BYTE) * 100L) / 100L + "Kb");
        } else if (size <= G_BYTE) {
            System.out.println("Размер папки " + path + " " +
                    (double) Math.round((size / M_BYTE) * 100L) / 100L + "Mb");
        } else {
            System.out.println("Размер папки " + path + " " +
                    (double) Math.round((size / G_BYTE) * 100L) / 100L + "Gb");
        }
    }
}
