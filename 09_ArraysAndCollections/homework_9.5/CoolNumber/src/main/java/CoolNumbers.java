import java.util.*;

public class CoolNumbers {
//    private static final String[] ALLOWED_LETTERS = {"А", "В", "Е", "К", "М",
//            "Н", "О", "Р", "С", "Т", "У", "Х"};
private static final char[] ALLOWED_CHARS = {'А', 'В', 'Е', 'К', 'М',
        'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static ArrayList<String> listOfNumbers = new ArrayList<>();
    //    private static HashSet<String> hashSetOfNumbers = new HashSet<>(listOfNumbers);
//    private static TreeSet<String> treeSetOfNumbers = new TreeSet<>(listOfNumbers);
    private static ArrayList<String> coolNumbersList = new ArrayList<>();
    private static ArrayList<String> coolNumbersListWithoutRegion = new ArrayList<>();

    // TODO: ниже вариант случайной генерации номеров, 4 метода,
    //  он использует String[], можно задать размерность итогового списка номеров
//    public static String generateNumber() {
//        int min = 1;
//        int max = 9;
//        String numbers = "";
//        int random = (int) Math.round(((Math.random() * (max - min)) + min));
//        for (int i = 0; i < 3; i++) {
//            numbers += random;
//        }
//        return numbers;
//    }
//
//    public static int generateIndex() {
//        int min = 0;
//        int max = ALLOWED_LETTERS.length - 1;
//        int random = (int) Math.round(((Math.random() * (max - min)) + min));
//        return random;
//    }
//
//    public static String generateRegion() {
//        int min = 1;
//        int max = 199;
//        String regionNumber = "";
//        int random = (int) Math.round(((Math.random() * (max - min)) + min));
//        if (random < 10) {
//            regionNumber = "0" + random;
//        } else {
//            regionNumber = Integer.toString(random);
//        }
//        return regionNumber;
//    }
//
//    public static String generateCarNumber() {
//        String carNumber = ALLOWED_LETTERS[generateIndex()] + generateNumber() +
//                ALLOWED_LETTERS[generateIndex()] + ALLOWED_LETTERS[generateIndex()] +
//                generateRegion();
//        return carNumber;
//    }
//
//    public static List<String> generateCoolNumbers() {
////        return Collections.emptyList();
//        for (int nextNumber = 0; nextNumber < 3400000; nextNumber++) {
//            Collections.addAll(listOfNumbers, generateCarNumber());
//        }
//        return listOfNumbers;
//    }



//    public static List<String> generateCoolNumbers() {
//        return Collections.emptyList();
//    }

    //TODO: тут вариант геренации номеров с самой первой буквы,
    // с самого первого региона по возрастанию без повторений. Он использует char[]

    public static List<String> generateCoolNumbers() {

        String numberplate = "";
        String numberplateWithoutRegion = "";

        char x;
        char z;
        char y;

        for(Character firstLetter : ALLOWED_CHARS){
            x = firstLetter;
            for (int n = 0; n < 10; n++){
                for (Character secondLetter : ALLOWED_CHARS){
                    z = secondLetter;
                    for(Character thirdLetter : ALLOWED_CHARS){
                        y = thirdLetter;
                        numberplateWithoutRegion = String.format("%c%d%d%d%c%c", x, n, n, n, z, y);
                        coolNumbersListWithoutRegion.add(numberplateWithoutRegion);
                    }
                }
            }
        }

        for (String numberWithoutRegion : coolNumbersListWithoutRegion) {
            for (int j = 0; j <= 199; j++){
                if(j < 10){
                    numberplate = String.format("%s0%d", numberWithoutRegion, j);
                    coolNumbersList.add(numberplate);
                }
                else {
                    numberplate = String.format("%s%d", numberWithoutRegion, j);
                    coolNumbersList.add(numberplate);
                }
            }
        }

        return coolNumbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String index : list) {
            if (index.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        return Collections.binarySearch(sortedList, number) >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
