import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://lenta.ru").get();
        Elements linkList = document.select("img.g-picture");
        //Все картинки на странице имеют класс g-picture, а если просто получить ссылкы элементов img,
        //то вылезают 2 лишние ссылки, не содержащие изображения

        linkList.forEach(e -> downloadImage(e.attr("abs:src")));
        System.out.println("Скачивание файлов завершено");

    }

    public static void downloadImage(String path) {
        try {
            URL url = new URL(path);
            BufferedImage img = ImageIO.read(url);
            String regexName = "(.*/)(.*.)(jpeg|jpg)";
            String fileName = url.getPath().replaceAll(regexName, "$2$3");
            File file = new File("./data/images/" + fileName);
            if (file.exists()) {
                System.out.println("Файл \"" + fileName + "\" уже был сохранен");
            } else {
                ImageIO.write(img, "jpg", file);
                System.out.println("Файл \"" + fileName + "\" успешно сохранен");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
