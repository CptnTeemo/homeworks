package ru.skillbox;

public class Keyboard {

    private final KeyboardType type;
    private final KeyboardIllumination illumination;
    private final int weight;

    public Keyboard(KeyboardType type, KeyboardIllumination illumination, int weight) {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public KeyboardIllumination getIllumination() {
        return illumination;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "\nТип клавиатуры: " + getType() + "\n" +
                "Наличие подсветки: " + (getIllumination() == KeyboardIllumination.YES ? "Да" : "Нет") + "\n" +
                "Вес, гр: " + getWeight();
    }

}
