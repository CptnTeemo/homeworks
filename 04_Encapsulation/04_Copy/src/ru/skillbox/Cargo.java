package ru.skillbox;

public class Cargo {

    public final Dimensions dimension;
//    public final int dimension;
    public final double weight;
    public final String address;
    public final boolean canFlip;
    public final String registerNumber;
    public final boolean isFragile;

    public Cargo(Dimensions dimension, double weight, String address,
                 boolean canFlip, String registerNumber, boolean isFragile) {
        this.dimension = dimension;
        this.weight = weight;
        this.address = address;
        this.canFlip = canFlip;
        this.registerNumber = registerNumber;
        this.isFragile = isFragile;
    }

    public Cargo setDimension(Dimensions dimension){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Cargo setWeight(double weight){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Cargo setAddress(String address){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Cargo setCanFlip(boolean canFlip){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Cargo setRegisterNumber(String registerNumber){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Cargo setIsFragile(boolean isFragile){
        return new Cargo(dimension, weight, address, canFlip, registerNumber, isFragile);
    }

    public Dimensions getDimension() {
        return dimension;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isCanFlip() {
        return canFlip;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public String toString(){
        return "Габариты: " + dimension + "\n" +
                "Вес: " + weight + " кг." + "\n" +
                "Адрес доставки: " + address + "\n" +
                "Можно переворачивать: " + (canFlip ? "да" : "нет") + "\n" +
                "Регистрационный номер: " +  registerNumber + "\n" +
                "Хрупкое: " + (isFragile ? "да" : "нет");
    }


}
