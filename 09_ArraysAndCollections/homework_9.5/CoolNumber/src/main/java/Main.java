import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        long start = System.nanoTime();
        List<String> listOfNumbers = CoolNumbers.generateCoolNumbers();
        HashSet<String> hashSetOfNumbers = new HashSet<>(listOfNumbers);
        TreeSet<String> treeSetOfNumbers = new TreeSet<>(listOfNumbers);

        System.out.println("Список заполнился за: " + (System.nanoTime() - start) + "нс");
        System.out.println("Размер списка: " + listOfNumbers.size());

        listSearch(listOfNumbers, "П111ЕХ55");
        binarySearch(listOfNumbers, "П111ЕХ55");
        searchHashSet(hashSetOfNumbers, "П111ЕХ55");
        searchTreeSet(treeSetOfNumbers, "П111ЕХ55");


    }

    public static void listSearch(List<String> list, String number) {
        long start = System.nanoTime();
        if (CoolNumbers.bruteForceSearchInList(list, number)) {
            System.out.println("Поиск перебором: номер найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        }
    }

    public static void binarySearch(List<String> list, String number) {
        long start = System.nanoTime();
//        Collections.sort(list);
        if (CoolNumbers.binarySearchInList(list, number)) {
            System.out.println("Бинарный поиск: номер найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        }
    }

    public static void searchHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        if(CoolNumbers.searchInHashSet(hashSet, number)){
            System.out.println("Поиск в HashSet: номер найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        }
    }

    public static void searchTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        if(CoolNumbers.searchInTreeSet(treeSet, number)){
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " +
                    (System.nanoTime() - start) + "нс");
        }
    }

}
