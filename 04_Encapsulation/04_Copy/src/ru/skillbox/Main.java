package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Dimensions dimension = new Dimensions(4,5,6);
        int cargoDimension = dimension.getCalculationDimension();

        Cargo cargo = new Cargo(dimension, 20, "г. Москва, ул. Московская, д.5, кв. 10",
                true, "DF547885-S", false);

        System.out.println(cargo.toString());
        System.out.println();

        Cargo updateCargoAddress = cargo.setAddress("г. Москва, ул. Ленина, д.124, кв. 35");
        Cargo updateCargoWeight = cargo.setWeight(50);
        Dimensions updateDimension = dimension.setDimensions(2,3,4);
        Cargo updateCargoDimension = cargo.setDimension(updateDimension);
        System.out.println(updateCargoAddress.toString());
        System.out.println();
        System.out.println(updateCargoWeight.toString());
        System.out.println();
        System.out.println(updateCargoDimension);
        System.out.println("Объём груза: " + cargo.getDimension().getCalculationDimension());
    }
}
