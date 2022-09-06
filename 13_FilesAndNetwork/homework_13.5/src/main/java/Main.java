import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String DATA_MAP_JSON = "./data/map.json";
    private static final String DATA_FILE_SOURCE = "./data/metro.html";

    public static void main(String[] args) throws IOException {
        CreateStationList createStationList = new CreateStationList();

//        Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").get();
        String htmlFile = createStationList.parseFile(DATA_FILE_SOURCE);
        Document document = Jsoup.parse(htmlFile);

        Elements linkLinesList = document.select("span.js-metro-line");
        Map<String, String> linesList = createStationList.getLinesList(linkLinesList);

        Elements linkConnectionsList = document.select("div.js-metro-stations.t-metrostation-list-table");
        Map<String, List<String>> anotherStationList = createStationList.getNewStationsList(linkConnectionsList);
        Map<String, List<String>> connectionsMap = createStationList.getAnotherConnectionsList(linkConnectionsList);

        JSONArray jsonLineList = JsonUtils.createJsonLineList(linesList);
        JSONObject jsonStationList = JsonUtils.createJsonStationList(anotherStationList);
        JSONArray jsonConnectionsList = JsonUtils.createJsonConnectionList(connectionsMap);

        JSONObject jsonFile = new JSONObject();
        jsonFile.put("lines", jsonLineList);
        jsonFile.put("stations", jsonStationList);
        jsonFile.put("connections", jsonConnectionsList);

        JsonUtils.createJsonMap(jsonFile, DATA_MAP_JSON);
        JsonUtils.getStationsFromJson(DATA_MAP_JSON);
        JsonUtils.getConnectionsFromJson(DATA_MAP_JSON);

    }

}
