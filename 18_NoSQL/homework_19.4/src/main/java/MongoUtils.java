import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.util.*;
import java.util.function.Consumer;

public class MongoUtils {

    private static MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

    private static final MongoDatabase database = mongoClient.getDatabase("shops");
    private static final MongoCollection<Document> shopCollection = database.getCollection("Shop_list");
    private static final MongoCollection<Document> productCollection = database.getCollection("Products");

    private static final String SHOP_NAME_FIELD = "Название_магазина";
    private static final String SHOP_PRODUCT_LIST_FIELD = "Список_товаров";
    private static final String PRODUCT_NAME_FIELD = "Название_товара";
    private static final String PRODUCT_PRICE_FIELD = "Цена";

    public void clearDb() {
        shopCollection.drop();
        productCollection.drop();
    }

    public void addShopToDb(String shopName) {
        Document newShop = new Document()
                .append(SHOP_NAME_FIELD, shopName)
                .append(SHOP_PRODUCT_LIST_FIELD, new ArrayList<Document>());
        shopCollection.insertOne(newShop);
        System.out.println("Магазин добавлен");
    }

    public void addProductToDb(String product, int price) {
        Document newProduct = new Document()
                .append(PRODUCT_NAME_FIELD, product)
                .append(PRODUCT_PRICE_FIELD, price);
        productCollection.insertOne(newProduct);
        System.out.println("Товар добавлен");
    }

    public void addProductToShop(String product, String shopName) {
        Document query = new Document(SHOP_NAME_FIELD, shopName);
        List<Document> productToAdd = new ArrayList<>();
        productCollection.find(new Document(PRODUCT_NAME_FIELD, product)).into(productToAdd);
        Document update = new Document(
                "$push",
                new Document(SHOP_PRODUCT_LIST_FIELD, productToAdd.get(0)));
        shopCollection.updateOne(query, update);
        System.out.println("Товар добавлен в магазин");
    }

    public void statistics() {
        getStatistics();
    }

    public void getStatistics() {
        shopCollection.aggregate(
                Arrays.asList(
                        Aggregates.unwind("$Список_товаров"),
                        Aggregates.group("$Название_магазина",
                                Accumulators.min("min_price", "$Список_товаров.Цена"),
                                Accumulators.max("max_price", "$Список_товаров.Цена"),
                                Accumulators.avg("avg_price", "$Список_товаров.Цена"),
                                Accumulators.sum("product_count", 1)
                        )
                )
        ).forEach((Block<? super Document>) doc -> System.out.println(doc.toJson()));

        shopCollection.aggregate(
                Arrays.asList(
                        Aggregates.unwind("$Список_товаров"),
                        Aggregates.match(Filters.lt("Список_товаров.Цена", 100)),
                        Aggregates.group(
                                "$Название_магазина",
                                Accumulators.sum("product_count_less_than_100_rub", 1)
                        )
                )
        ).forEach((Block<? super Document>) doc -> System.out.println(doc.toJson()));

    }

    public void getAvgPriceOfProductCollection() {
        BasicDBObject avgPriceQuery = new BasicDBObject("$avg", "$" + PRODUCT_PRICE_FIELD);
        AggregateIterable<Document> avgPrice = productCollection.aggregate(
                Arrays.asList(
                        Aggregates.group("_id",
                                new BsonField("Средняя_цена", avgPriceQuery))
                )
        );
        Document result = avgPrice.first();
        double price = result.getDouble("Средняя_цена");
        System.out.println("Средняя цена товаров: " + price);
    }

    public void printAllShopsAndProducts() {
        System.out.println("Данные по магазинам:");
        shopCollection.find().forEach((Consumer<Document>) document -> {
            System.out.println(SHOP_NAME_FIELD + ": " + document.get(SHOP_NAME_FIELD)
                    + "; " + SHOP_PRODUCT_LIST_FIELD + ":\n " + document.get(SHOP_PRODUCT_LIST_FIELD));
        });
        System.out.println("Данные по товарам:");
        productCollection.find().forEach((Consumer<Document>) document ->
                System.out.println(PRODUCT_NAME_FIELD + ": " + document.get(PRODUCT_NAME_FIELD) +
                        "; " + PRODUCT_PRICE_FIELD + ": " + document.get(PRODUCT_PRICE_FIELD)));

        System.out.println("Общее количество товаров: " + productCollection.countDocuments());
    }

    public void getStatisticsDraft() {

        shopCollection.aggregate(
                Arrays.asList(new Document("$project",
                        new Document("Название_магазина", 1L)
                                .append("Средняя_цена",
                                        new Document("$avg",
                                                new Document("$map",
                                                        new Document("input", "$Список_товаров")
                                                                .append("as", "val")
                                                                .append("in",
                                                                        new Document("$avg", Arrays.asList("$$val.Цена"))))))
                                .append("Минимальная_цена",
                                        new Document("$min",
                                                new Document("$map",
                                                        new Document("input", "$Список_товаров")
                                                                .append("as", "val")
                                                                .append("in",
                                                                        new Document("$min", Arrays.asList("$$val.Цена"))))))
                                .append("Максимальная_цена",
                                        new Document("$max",
                                                new Document("$map",
                                                        new Document("input", "$Список_товаров")
                                                                .append("as", "val")
                                                                .append("in",
                                                                        new Document("$max", Arrays.asList("$$val.Цена"))))))
                                .append("Количество_наименований",
                                        new Document("$size", Arrays.asList("$Список_товаров")))))
        ).forEach((Block<? super Document>) doc ->
                System.out.println("В магазине \"" + doc.get("Название_магазина") +
                        "\" средняя цена товаров: " + doc.get("Средняя_цена") +
                        "\n общее количество наименований: " + doc.get("Количество_наименований") +
                        "\n Самый дорогой товар: " + doc.get("Максимальная_цена") +
                        "\n Самый дешевый товар: " + doc.get("Минимальная_цена"))
        );
    }

}
