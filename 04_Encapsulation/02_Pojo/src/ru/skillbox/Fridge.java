package ru.skillbox;

public class Fridge {

    private String mark;
    private String color;
    private int compartmentsCount;
    private boolean isOn;

    public Fridge(String mark, String color) {
        this.mark = mark;
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCompartmentsCount() {
        return compartmentsCount;
    }

    public void setCompartmentsCount(int compartmentsCount) {
        this.compartmentsCount = compartmentsCount;
    }

    public boolean getisOn() {
        return isOn;
    }

    public void setIsOn(boolean inOn) {
        this.isOn = inOn;
    }

    public void print(){
        System.out.println("Марка холодильника: " + getMark());
        System.out.println("Цвет холодильника: " + getColor());
        System.out.println("Количество отсеков: " + getCompartmentsCount());
        System.out.println("Состояние: " + (getisOn() ? "включен" : "выключен"));
    }

}
