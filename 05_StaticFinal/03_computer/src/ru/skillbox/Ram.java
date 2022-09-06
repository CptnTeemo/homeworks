package ru.skillbox;

public class Ram {

    private final RamType type;
    private final int amountRam;
    private final int weight;

    public Ram(RamType type, int amountRam, int weight) {
        this.type = type;
        this.amountRam = amountRam;
        this.weight = weight;
    }

    public RamType getType() {
        return type;
    }

    public int getAmountRam() {
        return amountRam;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "\nТип оперативной памяти, Гб: " + getType() + "\n" +
                "Объём: " + getAmountRam() + "\n" +
                "Вес, гр: " + getWeight();
    }

}
