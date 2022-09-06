package ru.skillbox;

public class Display {

    private final int diagonal;
    private final DisplayType type;
    private final int weight;

    public Display(int diagonal, DisplayType type, int weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public DisplayType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "\nДиагональ, дюймы: " + getDiagonal() + "\n" +
                "Тип матрицы: " + getType() + "\n" +
                "Вес, гр: " + getWeight();
    }

}
