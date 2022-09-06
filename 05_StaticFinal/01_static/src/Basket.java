public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int limit;

    private static int allTotalPrice = 0;
    private static int allTotalCount = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getAllTotalPrice() {
        return allTotalPrice;
    }

    public static int getAllTotalCount() {
        return allTotalCount;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void increaseAllTotalPrice(int price) {
        Basket.allTotalPrice = Basket.allTotalPrice + price;
    }

    public static void increaseAllTotalCount(int count) {
        Basket.allTotalCount = Basket.allTotalCount + count;
    }

    public static double getAverageProductPrice(int allTotalPrice, int allTotalCount){
        return allTotalPrice / allTotalCount;
    }

    public static double getAverageBasketPrice(int allTotalPrice, int count){
        return allTotalPrice / count;
    }

    public void add(String name, int price, int count, double weight){
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - цена " + price + ", вес " + weight;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        increaseAllTotalCount(count);
        increaseAllTotalPrice(count * price);
    }

    public void add(String name, int price, int count){
        add(name, price, count, 0);
    }

    public void add(String name, int price){
        add(name, price, 1, 0);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }

}
