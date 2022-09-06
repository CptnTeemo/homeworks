package ru.skillbox;

public class Drive {

    private final DriveType type;
    private final int amountMemory;
    private final int weight;

    public Drive(DriveType type, int amountMemory, int weight) {
        this.type = type;
        this.amountMemory = amountMemory;
        this.weight = weight;
    }

    public DriveType getType() {
        return type;
    }

    public int getAmountMemory() {
        return amountMemory;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "\nТип жесткого диска: " + getType() + "\n" +
                "Объём памяти, Гб: " + getAmountMemory() + "\n" +
                "Вес, гр: " + getWeight();
    }

}
