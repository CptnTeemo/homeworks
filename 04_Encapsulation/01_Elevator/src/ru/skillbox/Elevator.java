package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator (int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor){
        if (floor < minFloor || floor > maxFloor){
            System.out.println("Некорректное значение этажа");
            System.out.println("Введите значение от " + minFloor + " до " + maxFloor);
            return;
        }

        if (currentFloor < floor){
            System.out.println("Едем вверх");
            for (int i = currentFloor; i < floor; i++){
                moveUp();
                System.out.println("Текущий этаж: " + i);
            }
            System.out.println("Вы достигли места назначения: " + currentFloor + " этаж");

        } else if (currentFloor > floor) {
            System.out.println("Едем вниз");
            for (int i = currentFloor; i > floor; i--){
                moveDown();
                System.out.println("Текущий этаж: " + i);
            }
            System.out.println("Вы достигли места назначения: " + currentFloor + " этаж");

        } else if (currentFloor == floor) {
            System.out.println("Вы уже находитесь на этаже №" + currentFloor);

        }
    }
}
