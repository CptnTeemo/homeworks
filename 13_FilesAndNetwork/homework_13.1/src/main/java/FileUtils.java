import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("Некорректный путь");
        }
        long filesSize = 0L;

                try (Stream<Path> walk = Files.walk(Path.of(path))) {
            filesSize = walk
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            System.out.printf("Невозможно получить размер файла %s%n%s", p, e);
                            return 0L;
                        }
                    })
                    .sum();
        } catch (IOException e) {
            System.out.printf("Ошибка при подсчёте размера директории %s", e);
        }

        return filesSize;

    }
}
