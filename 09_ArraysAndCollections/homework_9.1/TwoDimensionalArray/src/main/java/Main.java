public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        for (char[] row : TwoDimensionalArray.getTwoDimensionalArray(51)){
            System.out.println(row);
        }
    }
}
