package ru.skillbox;

public class Dimensions {

//    width, height and length
    public final int width;
    public final int height;
    public final int length;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getCalculationDimension(){
        return width * height * length;
    }

    public Dimensions setDimensions(int width, int height, int length){
        return new Dimensions(width, height, length);
    }

    public String toString(){
        return width + " x " + height + " x " + length;
    }

}
