import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CreateStationList {

    public String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public Map<String, String> getLinesList(Elements list) {
        Map<String, String> linesList = new LinkedHashMap<>();
        list.forEach(e -> linesList.put(e.attr("data-line"), e.text()));
        return new LinkedHashMap<>(linesList);
    }

    public Map<String, List<String>> getNewStationsList(Elements listOfElements) {
        Map<String, List<String>> stationMap = new LinkedHashMap<>();
        String regexStationName = "(\\d+.\\s)(.*)";
        listOfElements.forEach(e -> {
            Elements stationLine = e.select("div.js-metro-stations.t-metrostation-list-table");
            List<String> stationList = new ArrayList<>();
            Elements listOfStationsName = stationLine.select("a");
            listOfStationsName.forEach(elem -> stationList.add(elem.text()
                    .replaceAll(regexStationName, "$2")));
            stationMap.put(stationLine.attr("data-line"), stationList);
        });
        return stationMap;
    }

    public Map<String, List<String>> getAnotherConnectionsList(Elements listOfElements) {
        Map<String, List<String>> connectionsMap = new LinkedHashMap<>();
        String regexLinesName = "(.*)(ln-)(.*)(\"\\s.*\\=\")(.*«)(.*)(»)(.*)(<\\/span>)";
        String regexStationName = "(\\d+\\.\\s)(.*)";

        listOfElements.forEach(element -> {
            Elements stationLine = element.select("div.js-metro-stations.t-metrostation-list-table");
            Elements connectionsTempList = element.select("a");
            connectionsTempList.forEach(e -> {
                List<String> tempLinesNumbers = new ArrayList<>();
                String renameKeyLineAndStation = stationLine.attr("data-line") +
                        " - " + e.text().replaceAll(regexStationName, "$2");
                String tempStation = e.getElementsByClass("t-icon-metroln").toString();

                if (!tempStation.isEmpty()) {
                    String[] tempWords = tempStation.split("\n");
                    Arrays.stream(tempWords).forEach(i -> {
                        String renameLineAndStation = i.replaceAll(regexLinesName, "$3") +
                                " - " + i.replaceAll(regexLinesName, "$6");
                        tempLinesNumbers.add(renameLineAndStation);
                    });
                    connectionsMap.put(renameKeyLineAndStation, tempLinesNumbers);
                }
            });

        });
        return connectionsMap;
    }

    //TODO: черновик
    //    public List<String[]> getAnotherConnectionsList(Elements listOfElements) {
//        List<String[]> connectionsList = new ArrayList<>();
//        String regexLinesName = "(.*)(ln-)(.*)(\"\\s.*\\=\")(.*«)(.*)(»)(.*)(<\\/span>)";
//        String regexStationName = "(\\d+\\.\\s)(.*)";
//        listOfElements.forEach(element -> {
//            Elements stationLine = element.select("div.js-metro-stations.t-metrostation-list-table");
//            Elements connectionsTempList = element.select("a");
//            connectionsTempList.forEach(e -> {
//                String tempStation = e.getElementsByClass("t-icon-metroln").toString();
//                String renameKeyLineAndStation = stationLine.attr("data-line") +
//                        " - " + e.text().replaceAll(regexStationName, "$2");
//                if (!tempStation.isEmpty()) {
//                    String[] tempWords = tempStation.split("\n");
//                    Arrays.stream(tempWords).forEach(i -> {
//                        String[] connectionElement = new String[2];
//                        String renameLineAndStation = i.replaceAll(regexLinesName, "$3") +
//                                " - " + i.replaceAll(regexLinesName, "$6");
//                        connectionElement[0] = renameKeyLineAndStation;
//                        connectionElement[1] = renameLineAndStation;
//                        connectionsList.add(connectionElement);
//                    });
//                }
//            });
//
//        });
//
//        return connectionsList;
//    }

    //    public Map<String, List<String>> getNewConnectionsList(Elements listOfElements) {
//        Map<String, List<String>> connectionsMap = new LinkedHashMap<>();
//        String tempLinesName = "(.*)(ln-)(.*)(\"\\s.*)(<\\/span>)";
////        String tempStationName = "(\\d+\\.\\s)(.*)";
//        listOfElements.forEach(element -> {
//            Elements connectionsTempList = element.select("a");
//            connectionsTempList.forEach(e -> {
//                List<String> tempLinesNumbers = new ArrayList<>();
//                String tempStation = e.getElementsByClass("t-icon-metroln").toString();
//                if (!tempStation.isEmpty()) {
//                    String[] tempWords = tempStation.split("\n");
//                    Arrays.stream(tempWords).forEach(i ->
//                            tempLinesNumbers.add(i.replaceAll(tempLinesName, "$3")));
////                    connectionsMap.put(e.text().replaceAll(tempStationName, "$2"), tempLinesNumbers);
//                    connectionsMap.put(e.text(), tempLinesNumbers);
//                }
//            });
//
//        });
//        return connectionsMap;
//    }

}
