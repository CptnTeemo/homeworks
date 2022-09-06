import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static JSONArray createJsonLineList(Map map) {
        JSONArray jsonArray = new JSONArray();
        map.forEach((key, value) -> {
            JSONObject object = new JSONObject();
            object.put("number", key);
            object.put("name", value);
            jsonArray.add(object);
        });
        return jsonArray;
    }

    public static JSONObject createJsonStationList(Map<String, List<String>> map) {
        JSONObject object = new JSONObject();

        map.forEach((key, value) -> {
            JSONArray jsonArray = new JSONArray();
            value.forEach(e -> jsonArray.add(e));
            object.put(key, jsonArray);
        });
        return object;
    }

    public static JSONArray createJsonConnectionList(Map<String, List<String>> map) {
        JSONArray jsonConnectionsArray = new JSONArray();
        map.forEach((key, value) -> {
            JSONArray array = new JSONArray();
            JSONObject keyObject = new JSONObject();
            String[] keyArray = key.split(" - ");
            keyObject.put("line", keyArray[0]);
            keyObject.put("station", keyArray[1]);
            array.add(keyObject);
            value.forEach(e -> {
                JSONObject valueObject = new JSONObject();
                String[] valueArray = e.split(" - ");
                valueObject.put("line", valueArray[0]);
                valueObject.put("station", valueArray[1]);
                array.add(valueObject);
            });
            jsonConnectionsArray.add(array);
        });
        return jsonConnectionsArray;
    }

    public static void createJsonMap(JSONObject object, String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                FileWriter writer = new FileWriter(file);
                writer.write(object.toJSONString());
                writer.flush();
                writer.close();
            } else {
                System.out.println("Файл уже создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJsonFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public static void getStationsFromJson(String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile(path));
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            stationsObject.forEach((key, value) -> {
                JSONArray array = (JSONArray) value;
                System.out.println("На линии " + key + " находится " + array.size() + " станции");
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void getConnectionsFromJson(String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile(path));
            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            System.out.println("Всего в метро " + connectionsArray.size() + " переходов");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
