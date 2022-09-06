public class Printer {

    public String queue = "";
    public int totalPagesCount = 0;
    public static int allTimePagesCount = 0;
    public int printCount = 1;

    public void append(String text) {
        append(text, "", 1);
    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text, String name, int countPages) {
        queue = queue + "\n" + text + ", имя документа: " + name +
                ", количество страниц: " + countPages;;
        totalPagesCount = totalPagesCount + countPages;
        allTimePagesCount = allTimePagesCount + countPages;
    }

    public void clear() {
        queue = "";
    }

    public void print(String title) {
        if (queue.isEmpty()) {
            System.out.println("Список печати пуст");
            return;
        }
        System.out.println(title);
        System.out.println(queue);
        System.out.println("Страниц в " + printCount +" очереди на печать: " + getPendingPagesCount() + " шт.");
        printCount += 1;
        clear();
        totalPagesCount = 0;
    }

    public int getPendingPagesCount() {
        return totalPagesCount;
    }

    public int getAllTimePagesCount() {
        return allTimePagesCount;
    }

}
