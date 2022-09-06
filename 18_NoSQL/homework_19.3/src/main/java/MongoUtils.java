import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MongoUtils {

    private static MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    private MongoDatabase database = mongoClient.getDatabase("books");
    private MongoCollection<Document> books = database.getCollection("Books");
    private MongoCollection<Document> students = database.getCollection("Students");

    public void fillBooksDb() {

        Document firstBook = new Document()
                .append("Название книги", "Гибель Богов")
                .append("Автор", "Ник Перумов")
                .append("Год", 2005);

        Document secondBook = new Document()
                .append("Название книги", "Алмазный меч, Деревянный меч")
                .append("Автор", "Ник Перумов")
                .append("Год", 2007);

        Document thirdBook = new Document()
                .append("Название книги", "Дюна")
                .append("Автор", "Фрэнк Герберт")
                .append("Год", 1965);

        Document foursBook = new Document()
                .append("Название книги", "Властелин Колец")
                .append("Автор", "Джон Рональд Руэл Толкин")
                .append("Год", 1954);

        Document fifthBook = new Document()
                .append("Название книги", "Экскалибур")
                .append("Автор", "Бернард Корнуэлл")
                .append("Год", 1997);

        books.insertOne(firstBook);
        books.insertOne(secondBook);
        books.insertOne(thirdBook);
        books.insertOne(foursBook);
        books.insertOne(fifthBook);
        books.find().forEach((Consumer<Document>) document ->
                System.out.println("Книга:\n" + document));
    }

    public void oldestBook() {
        System.out.println("Самая старая книга:");
        books.find().sort(new BasicDBObject("Год", 1))
                .limit(1)
                .forEach((Block<? super Document>) System.out::println);
    }

    public void favoriteAuthor(String author) {
        System.out.println("Книги любимого автора:");
        Document query = new Document("Автор", author);
        List<Document> results = new ArrayList<>();
        books.find(query).into(results).forEach(System.out::println);
    }

    public void clearDataBase() {
        books.drop();
        students.drop();
    }

    public void readFileAndWriteDb(String path) throws IOException {
        List<Document> studentsList = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.forEach(e -> {
            String formatLine = e.replaceAll("(\")(\\w+)(,)(\\w+)(,)?(\\w+)?(\")", "$2.$4.$6");
            String[] csvArray = formatLine.split(",");
            Document temp = new Document()
                    .append("Студент", csvArray[0])
                    .append("Возраст", Integer.parseInt(csvArray[1]))
                    .append("Список курсов", csvArray[2].replaceAll("\\.", ","));
            studentsList.add(temp);
        });
        students.insertMany(studentsList);
//        students.find().forEach((Consumer<Document>) document ->
//                System.out.println("Студент:\n" + document));
    }

    public void studentsCount() {
        System.out.println("Количество студентов: " + students.countDocuments());
    }

    public void studentOlderThanFourty() {
        Document query = new Document("Возраст", new Document("$gte", 40));
        List<Document> results = new ArrayList<>();
        System.out.println("Студентов старше 40: " + students.find(query).into(results).size());
    }

    public void youngestStudent() {
        students.find().sort(new Document("Возраст", 1))
                .limit(1)
                .forEach((Block<? super Document>) e ->
                        System.out.println("Самый молодой студент: " + e.get("Студент")));
    }

    public void coursesListOldestStudent() {
        students.find().sort(new Document("Возраст", -1))
                .limit(1)
                .forEach((Block<? super Document>) e ->
                        System.out.println("Список курсов самого старого студента: " + e.get("Список курсов")));
    }

}
