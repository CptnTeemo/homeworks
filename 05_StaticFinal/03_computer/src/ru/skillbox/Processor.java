package ru.skillbox;

public class Processor {

    private final double clockFrequency;
    private final int coreAmount;
    private final ProcessorVendor vendor;
    private final int weight;

    public Processor(double clockFrequency, int coreAmount, ProcessorVendor vendor, int weight) {
        this.clockFrequency = clockFrequency;
        this.coreAmount = coreAmount;
        this.vendor = vendor;
        this.weight = weight;
    }

    public double getClockFrequency() {
        return clockFrequency;
    }

    public int getCoreAmount() {
        return coreAmount;
    }

    public ProcessorVendor getVendor() {
        return vendor;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return "\nТактовая частота, ГГц: " + getClockFrequency() + "\n" +
                "Количество ядер: " + getCoreAmount() + "\n" +
                "Производитель: " + getVendor() + "\n" +
                "Вес, гр: " + getWeight();
    }

}
