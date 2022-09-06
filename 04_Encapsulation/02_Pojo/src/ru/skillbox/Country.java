package ru.skillbox;

public class Country {

    private String nameCountry;
    private int population;
    private double area;
    private String nameCapital;
    private boolean hasAccessToSea;

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public boolean isHasAccessToSea() {
        return hasAccessToSea;
    }

    public void setHasAccessToSea(boolean hasAccessToSea) {
        this.hasAccessToSea = hasAccessToSea;
    }

    public void print(){
        System.out.println("Название страны: " + getNameCountry());
        System.out.println("Название столицы: " + getNameCapital());
        System.out.println("Население: " + getPopulation());
        System.out.println("Площадь кв. км.: " + getArea());
        System.out.println("Есть выходы в море: " + (isHasAccessToSea() ? "да" : "нет"));
    }

}

