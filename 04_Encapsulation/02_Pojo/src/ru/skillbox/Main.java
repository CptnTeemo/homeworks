package ru.skillbox;

public class Main {

    public static void main(String[] args) {

    Country australia = new Country("Australia");
    australia.setPopulation(25650000);
    australia.setArea(7692024);
    australia.setNameCapital("Canberra");
    australia.setHasAccessToSea(true);
    australia.print();

    System.out.println();

    Country switzerland = new Country("Switzerland");
    switzerland.setPopulation(8500000);
    switzerland.setArea(41284);
    switzerland.setNameCapital("Bern");
    switzerland.setHasAccessToSea(false);
    switzerland.print();

    System.out.println();

    Fridge lgFridge = new Fridge("LG", "White");
    lgFridge.setCompartmentsCount(1);
    lgFridge.setIsOn(true);
    lgFridge.print();

    System.out.println();

    Fridge boschFridge = new Fridge("Bosch", "Gray");
    boschFridge.setCompartmentsCount(2);
    boschFridge.setIsOn(false);
    boschFridge.print();

    }
}
