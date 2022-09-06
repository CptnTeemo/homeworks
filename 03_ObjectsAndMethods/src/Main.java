public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");
        System.out.println("Общая сумма: " + basket.getTotalPrice()); // и выводятся только через печать
        basket.add("Salt", 25, 5, 100);
        System.out.println();
        basket.print("Корзина:");
        System.out.println("Общий вес: " + basket.getTotalWeight());

        System.out.println();

        Arithmetic arithmetic = new Arithmetic(5, 10);
        System.out.println("Минимальное число: " + arithmetic.min());
        System.out.println("Минимальное число: " + arithmetic.max());
        System.out.println("Сумма чисел: " + arithmetic.sum());
        System.out.println("Умножение чисел: " + arithmetic.multiplication());

        System.out.println();

        Printer printer = new Printer();
        printer.append("Некоторый текст");
        printer.append("Немного текста", "Два слова");
        printer.append("Ещё текст", "Два слова, 2-е издание", 1);
        printer.print("Список печати:");
        System.out.println("Всего страниц в очереди на печать за всё время: " +
                printer.getAllTimePagesCount() + " шт.");

        System.out.println();
        printer.print("Список печати:");
        System.out.println();

        printer.append("Некоторый текст");
        printer.append("Немного текста", "Два слова");
        printer.append("Ещё текст", "Два слова, 2-е издание", 7);
        printer.print("Список печати:");
        System.out.println("Всего страниц в очереди на печать за всё время: " +
                printer.getAllTimePagesCount() + " шт.");

        System.out.println();
        printer.clear();

        printer.append("Некоторый текст");
        printer.append("Немного текста", "Два слова");
        printer.append("Ещё текст", "Два слова, 2-е издание", 10);
        printer.print("Список печати:");

        System.out.println("Всего страниц в очереди на печать за всё время: " +
                printer.getAllTimePagesCount() + " шт.");

    }
}
