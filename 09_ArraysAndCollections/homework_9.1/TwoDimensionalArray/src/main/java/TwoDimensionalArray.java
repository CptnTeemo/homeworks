public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] twoDimensionalArray = new char[size][size];
        for (int i = 0; i < twoDimensionalArray.length; i++){
            twoDimensionalArray[i][i] = symbol;
            twoDimensionalArray[i][twoDimensionalArray.length - 1 -i] = symbol;
            for (int j = 0; j < twoDimensionalArray.length; j++){
                if(twoDimensionalArray[i][j] != symbol){
                    twoDimensionalArray[i][j] = ' ';
                }
            }
        }

        return twoDimensionalArray;
    }
}
