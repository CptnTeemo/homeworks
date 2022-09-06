public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан тот, кто бывает тут";
        String[] words = line.split("[,?\\s]+");

        for (String word : ReverseArray.reverse(words)){
            System.out.println(word);
        }
    }
}
