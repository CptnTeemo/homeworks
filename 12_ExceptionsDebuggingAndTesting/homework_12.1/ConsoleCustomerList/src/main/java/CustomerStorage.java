import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private final String FORMAT_EMAIL = "(\\w+\\.?\\w+@\\w+\\.\\D+)";
    private final String FORMAT_NAME = "([А-я][а-я]+)\\s([А-я]+)";
    private final String FORMAT_PHONE = "([+])([7])([0-9]{10})";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if(components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format: " + System.lineSeparator() +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (!name.matches(FORMAT_NAME)){
            throw new IllegalArgumentException("Wrong name format. Correct format: " + System.lineSeparator() +
                    "Василий Петров");
        }

        if (!components[INDEX_EMAIL].matches(FORMAT_EMAIL)) {
            throw new IllegalArgumentException("Wrong email format. Correct format: " + System.lineSeparator() +
                    "vasily.petrov@gmail.com");
        }

        if (!components[INDEX_PHONE].matches(FORMAT_PHONE)) {
            throw new IllegalArgumentException("Wrong phone format. Correct format: " + System.lineSeparator() +
                    "+79215637722");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        checkIfEmpty();
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        checkIfEmpty();
        storage.remove(name);
    }

    public void checkIfEmpty(){
        if (storage.isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}