public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");
        System.out.println("Общая сумма: " + basket.getTotalPrice());
        basket.add("Salt", 25, 8, 100);
        basket.add("Sugar", 30, 1);
        System.out.println();
        basket.print("Корзина:");
        System.out.println("Общий вес: " + basket.getTotalWeight());
        System.out.println("Цена корзины: " + basket.getTotalPrice());

        System.out.println();

        Basket newBasket = new Basket();
        newBasket.add("Tea", 50);
        newBasket.add("Garlic", 5, 10, 100);
        newBasket.add("Water", 30, 1);
        newBasket.print("Новая корзина");
        System.out.println("Общий вес: " + newBasket.getTotalWeight());
        System.out.println("Цена корзины: " + newBasket.getTotalPrice());

        System.out.println();

        System.out.println("Общиая цена всех товаров: " + Basket.getAllTotalPrice());
        System.out.println("Общее количество всех товаров: " + Basket.getAllTotalCount());
        System.out.println("Средняя цена товара всех корзин: " +
                Basket.getAverageProductPrice(Basket.getAllTotalPrice(), Basket.getAllTotalCount()));
        System.out.println("Всего корзин c товарами: " + Basket.getCount());
        System.out.println("Средняя цена корзины: " +
                Basket.getAverageBasketPrice(Basket.getAllTotalPrice(), Basket.getCount()));

    }

}
