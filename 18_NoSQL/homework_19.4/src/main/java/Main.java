import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MongoUtils mongoUtils = new MongoUtils();
//        mongoUtils.clearDb();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню:\n" +
                "Введите одну из команд\n" +
                "ДОБАВИТЬ_МАГАЗИН название_магазина - добавление магазина в список магазинов;\n" +
                "ДОБАВИТЬ_ТОВАР название_товара цена - добавление товара по указанной цене (руб.) в список товаров;\n" +
                "ВЫСТАВИТЬ_ТОВАР название_товара название_магазина - добавление товара в магазин;\n" +
                "СТАТИСТИКА_ТОВАРОВ - показать данные по магазинам (общее количество наименований, " +
                "средняя цена товаров, самый дорогой и самый дешевый товар, количество товаров дешевле 100 рублей");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String[] words = input.split(" ");
            String command = words[0];
            switch (command) {
                case "ДОБАВИТЬ_МАГАЗИН":
                    mongoUtils.addShopToDb(words[1]);
                    break;
                case "ДОБАВИТЬ_ТОВАР":
                    mongoUtils.addProductToDb(words[1], Integer.parseInt(words[2]));
                    break;
                case "ВЫСТАВИТЬ_ТОВАР":
                    mongoUtils.addProductToShop(words[1], words[2]);
                    break;
                case "СТАТИСТИКА_ТОВАРОВ":
                    mongoUtils.statistics();
                    break;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}
