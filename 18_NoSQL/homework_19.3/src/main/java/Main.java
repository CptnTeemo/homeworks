import java.io.IOException;

public class Main {

    public static final String PATH = "./src/main/resources/mongo.csv";

    public static void main(String[] args) throws IOException {
        String author = "Ник Перумов";

        MongoUtils mongoUtils = new MongoUtils();
        mongoUtils.clearDataBase();
        mongoUtils.fillBooksDb();
        mongoUtils.oldestBook();
        mongoUtils.favoriteAuthor(author);

        mongoUtils.readFileAndWriteDb(PATH);
        mongoUtils.studentsCount();
        mongoUtils.studentOlderThanFourty();
        mongoUtils.youngestStudent();
        mongoUtils.coursesListOldestStudent();

    }
}
