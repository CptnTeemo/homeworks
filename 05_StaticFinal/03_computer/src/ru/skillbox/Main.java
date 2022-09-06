package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Processor processor = new Processor(4.2, 4, ProcessorVendor.AMD, 125);
        Ram ram = new Ram(RamType.DDR4, 16, 200);
        Drive drive = new Drive(DriveType.SSD, 256, 1250);
        Display display = new Display(21, DisplayType.IPS, 5600);
        Keyboard keyboard = new Keyboard(KeyboardType.MECHANICAL, KeyboardIllumination.YES, 565);

        Computer computer = new Computer("HighTech Co.", "Gamer PRO");
        computer.setProcessor(processor);
        computer.setRam(ram);
        computer.setDrive(drive);
        computer.setDisplay(display);
        computer.setKeyboard(keyboard);

        System.out.println(computer);
        System.out.println("Общий вес оборудования: " + computer.getTotalWeight() + " гр.");

    }
}
