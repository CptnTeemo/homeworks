import java.util.Scanner;

public class Main {

    public static final int CONTAINERS_LIMIT = 12;
    public static final int BOXES_LIMIT = 27;

    public static void main(String[] args) {

        int containers = 1;
        int trucks = 1;

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int boxesCount = Integer.parseInt(boxes);

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
        int boxesRemains = boxesCount % BOXES_LIMIT;
        int containersRemains = containers % CONTAINERS_LIMIT;

        if (boxesCount <= 0){
            containers = 0;
        } else {
            if (boxesCount <= BOXES_LIMIT){
                containers = 1;
            } else {
                containers = boxesCount / BOXES_LIMIT;
                if (boxesRemains > 0){
                    containers++;
                }
            }
        }

        if (containers == 0){
            trucks = 0;
        } else {
            trucks = containers / CONTAINERS_LIMIT;
            if (containersRemains > 0){
                trucks++;
            }
        }

        for(int t = 1; t <= trucks; t++){
            System.out.print("Грузовик: " + t + System.lineSeparator());
            for (int i = 1; i <= CONTAINERS_LIMIT; i++){
                int currentContainer = (t - 1) * CONTAINERS_LIMIT + i;
                // расчёт номера контейнера в зависимости от номера грузовика
                if (currentContainer <= containers){
                    System.out.print("\tКонтейнер: " + currentContainer + System.lineSeparator());
                    for (int j = 1; j <= BOXES_LIMIT; j++) {
                        int currentBox = (currentContainer - 1) * BOXES_LIMIT + j;
                        // расчёт номера ящика в зависимости от номера контейнера
                        if (currentBox <= boxesCount) {
                            System.out.print("\t\tЯщик: " + currentBox +
                                    System.lineSeparator());
                        }
                    }
                }
            }
        }

        System.out.print("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + trucks + " шт."+ System.lineSeparator() +
                "контейнеров - " + containers + " шт.");

    }
}
