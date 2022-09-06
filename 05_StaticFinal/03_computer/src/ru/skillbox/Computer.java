package ru.skillbox;

public class Computer {

    private Processor processor;
    private Ram ram;
    private Drive drive;
    private Display display;
    private Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public Drive getDrive() {
        return drive;
    }

    public Display getDisplay() {
        return display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String toString(){
        return "Процессор: " + processor + "\n" +
                "Оперативная память: " + ram + "\n" +
                "Жесткий диск: " + drive + "\n" +
                "Экран: " + display + "\n" +
                "Клавиатура" + keyboard;
    }

    public int getTotalWeight(){
        return getProcessor().getWeight() + getRam().getWeight() +
                getDrive().getWeight() + getDisplay().getWeight() +
                getKeyboard().getWeight();
    }

}
