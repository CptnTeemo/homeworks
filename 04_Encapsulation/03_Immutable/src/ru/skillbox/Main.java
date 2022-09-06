package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("Война и мир", "Л.Н. Толстой", 1200, 5447845);
        System.out.println(book.toString());
        System.out.println();
        Product product = new Product("Квас", "NR5452E");
        product.setPrice(50);
        System.out.println(product.toString());

    }
}
