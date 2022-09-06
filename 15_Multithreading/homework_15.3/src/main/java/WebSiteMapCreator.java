import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;

public class WebSiteMapCreator extends RecursiveTask<Set<String>> {

    private String path;
    private static final String PATH = "./data/";

    public WebSiteMapCreator(String path) {
        this.path = path;
    }

    @Override
    protected Set<String> compute() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = Jsoup.connect(path).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (document != null) {
            Elements linkList = document.select("a");
//        Elements liList = linkList.select("a");
            List<WebSiteMapCreator> tasks = new ArrayList<>();
            List<String> siteMap = new ArrayList<>();
            List<String> hrefList = linksCollector(linkList, path);
            if (hrefList.size() > 1) {
                hrefList.forEach(e -> {
                    WebSiteMapCreator webSiteMapCreator = new WebSiteMapCreator(e);
                    webSiteMapCreator.fork();
                    tasks.add(webSiteMapCreator);
                });
                siteMap.add(path);
                siteMap.addAll(hrefList);
            }

            addResultsFromTasks(siteMap, tasks);
            return new TreeSet<>(siteMap);
        }
        return new TreeSet<>();
    }

    private void addResultsFromTasks(List<String> list, List<WebSiteMapCreator> tasks) {
        for (WebSiteMapCreator item : tasks) {
            list.addAll(item.join());
        }
    }

    public List<String> linksCollector(Elements elements, String path) {
        List<String> hrefList = new ArrayList<>();
        elements.forEach(e -> {
            String subPath = e.attr("abs:href");
            if (subPath.contains(path) && !subPath.equals(path) &&
                    !subPath.contains("#") && !subPath.contains(".pdf")) {
                hrefList.add(subPath);
            }
        });
        return hrefList;
    }

    public static void createWebSireMapFile(Set<String> siteMap, String sitePath) throws IOException {

        File file = new File(PATH + "map_" +
                sitePath.replaceAll("(.*\\/)(.*)(\\/)", "$2") + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        try {
            siteMap.forEach(e -> {
                e = tabsMultiply(e) + e;
                try {
                    fileWriter.write(e + System.lineSeparator());
                    fileWriter.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } finally {
            fileWriter.close();
        }
    }

    public static String tabsMultiply(String path) {
        int slashCount = path.length() - path.replaceAll("\\/", "").length() - 3;
        StringBuilder sb = new StringBuilder();
        sb.append("\t".repeat(Math.max(0, slashCount)));
        return sb.toString();
    }

}

