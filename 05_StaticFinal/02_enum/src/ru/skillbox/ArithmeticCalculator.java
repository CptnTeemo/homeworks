package ru.skillbox;

public class ArithmeticCalculator {

    private static int a;
    private static int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculate(Operation value) {
        if (value == Operation.ADD){
            System.out.print("Результат операции сложения числел " + a + " и " + b + ": ");
            return a + b;
        } else if (value == Operation.SUBTRACT){
            System.out.print("Результат операции вычитания числел " + a + " и " + b + ": ");
            return a - b;
        } else if (value == Operation.MULTIPLY){
            System.out.print("Результат операции умножения числел " + a + " и " + b + ": ");
            return a * b;
        } else {
            System.out.println("Ошибка");
            return 0;
        }
    }
}
