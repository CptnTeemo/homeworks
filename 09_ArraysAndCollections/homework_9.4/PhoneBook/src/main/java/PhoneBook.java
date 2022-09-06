import java.util.*;

public class PhoneBook {

    private static final String REGEX_NAME = "([А-я][а-я]+)\\s?([А-я]+)?\\s?([А-я]+)?";
    private static final String REGEX_PHONE = "([7]|[8])([0-9]{10})";
    TreeMap<String, ArrayList<String>> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isValidPhone(phone) && isValidName(name)) {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phone);
            if (!isNameContained(name)) {
                if (isPhoneContained(phone)) {
                    replaceByName(name, phone);
                }
                phoneBook.put(name, phoneNumbers);
                System.out.println("Контакт сохранен!");
            } else if (!isPhoneContained(phone)) {
                addPhoneToContact(name, phone);
                System.out.println("Контакт сохранен!");
            }
        } else {
            System.out.println("Введены некорректные данные." +
                    "Контакт не может быть сохранен." + System.lineSeparator() +
                    "Имя должно начинаться с заглавной буквы и содержать только кириллицу," +
                    "а номер с цифры 7 или 8 без разделителей или специальных знаков");
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (!isPhoneContained(phone)) {
            return "";
        } else {
            for (String key : phoneBook.keySet()) {
                if (phoneBook.get(key).contains(phone)) {
                    StringJoiner joiner = new StringJoiner(", ");
                    ArrayList<String> phoneNumbers = new ArrayList<>(phoneBook.get(key));
                    for (String nextNumber : phoneNumbers) {
                        joiner.add(nextNumber);
                    }
                    return key + " - " + joiner.toString();
                }
            }
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> desiredEntry = new TreeSet<>();
        StringJoiner joiner = new StringJoiner(", ");
        ArrayList<String> phoneNumbers = phoneBook.get(name);
        for (String index : phoneNumbers) {
            joiner.add(index);
        }
        desiredEntry.add(name + " - " + joiner.toString());
        return new TreeSet<>(desiredEntry);
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонная книга пуста");
            return new TreeSet<>();
        } else {
            for (String key : phoneBook.keySet()) {
                StringJoiner joiner = new StringJoiner(", ");
                ArrayList<String> phoneNumbers = new ArrayList<>(phoneBook.get(key));
                for (String nextNumber : phoneNumbers) {
                    joiner.add(nextNumber);
                }
                allContacts.add(key + " - " + joiner.toString());
            }
        }
        return new TreeSet<>(allContacts);
    }

    public void replaceByName(String newName, String phone) {
        String oldName = "";
        ArrayList<String> phoneNumber;
        for (String key : phoneBook.keySet()) {
            if (isPhoneContained(phone)) {
                oldName = key;
                phoneNumber = phoneBook.get(key);
                phoneBook.remove(oldName);
                phoneBook.put(newName, phoneNumber);
            }
        }
        System.out.println("Контакт с номером \"" + phone + "\"" +
                " уже был в списке под именем \"" + oldName + "\"." + System.lineSeparator() +
                "Имя контакта было заменено на \"" + newName + "\"");

    }

    public void addPhoneToContact(String name, String phone) {
        ArrayList<String> newNumbers = phoneBook.get(name);
        newNumbers.add(phone);
        phoneBook.replace(name, newNumbers);
    }

    public boolean isValidName(String name) {
//        String regexName = "([А-я][а-я]+)\\s?([А-я]+)?\\s?([А-я]+)?";
        return name.matches(REGEX_NAME);
    }

    public boolean isValidPhone(String phone) {
//        String regexPhone = "([7]|[8])([0-9]{10})";
        return phone.matches(REGEX_PHONE);
    }

    public boolean isPhoneContained(String phone) {
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).contains(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameContained(String name) {
        return phoneBook.containsKey(name);
    }

    public String phoneBookToString() {
        Set<String> newSet = getAllContacts();
        String list = "";
        for (String nextData : newSet) {
            list += nextData + System.lineSeparator();
        }
        return list.trim();
    }

    public String contactToString(String name) {
        Set<String> newSet = getPhonesByName(name);
        StringJoiner joiner = new StringJoiner(", ");
        for (String index : newSet) {
            joiner.add(index);
        }
        return joiner.toString();
    }

    // старый вариант для TreeMap<String, String>
//    public void addContact(String phone, String name) {
//        // проверьте корректность формата имени и телефона
//        // если такой номер уже есть в списке, то перезаписать имя абонента
//
//        if (isValidPhone(phone) && isValidName(name)) {
//            if (!isNameContained(name)) {
//                if (isPhoneContained(phone)) {
//                    replaceByName(name, phone);
//                }
//                phoneBook.put(name, phone);
//                System.out.println("Контакт сохранен!");
//            }
//            else if (!isPhoneContained(phone))
//            {
//                String oldPhone = phoneBook.get(name);
//                phoneBook.replace(name, oldPhone, oldPhone.concat(", " + phone));
//                System.out.println("Контакт сохранен!");
//            }
//        } else {
//            System.out.println("Введены некорректные данные." +
//                    "Контакт не может быть сохранен." + System.lineSeparator() +
//                    "Имя должно начинаться с заглавной буквы и содержать только кириллицу," +
//                            "а номер с цифы 7 или 8 без разделителей или специальных знаков");
//        }
//    }
//
//    public String getNameByPhone(String phone) {
//        // формат одного контакта "Имя - Телефон"
//        // если контакт не найдены - вернуть пустую строку
//        if (!isPhoneContained(phone)) {
//            return "";
//        } else {
//            for (String key : phoneBook.keySet()) {
//                if (phoneBook.get(key).equals(phone)) {
//                    return key + " - " + phoneBook.get(key);
//                }
//            }
//        }
//        return "";
//    }
//
//    public Set<String> getPhonesByName(String name) {
//        // формат одного контакта "Имя - Телефон"
//        // если контакт не найден - вернуть пустой TreeSet
//        TreeSet<String> desiredEntry = new TreeSet<>();
//        String phone = phoneBook.get(name);
//        desiredEntry.add(name + " - " + phone);
//        return new TreeSet<>(desiredEntry);
//    }
//
//    public Set<String> getAllContacts() {
//        TreeSet<String> allContacts = new TreeSet<>();
//        // формат одного контакта "Имя - Телефон"
//        // если контактов нет в телефонной книге - вернуть пустой TreeSet
//        if (phoneBook.isEmpty()) {
//            System.out.println("Телефонная книга пуста");
//            return new TreeSet<>();
//        } else {
//            for (String key : phoneBook.keySet()) {
//                allContacts.add(key + " - " + phoneBook.get(key));
//            }
//        }
//        return new TreeSet<>(allContacts);
//    }
//
//    public void replaceByName(String name, String phone){
//        String oldName = "";
//        for (String key : phoneBook.keySet()) {
//            if (phoneBook.get(key).equals(phone)) {
//                oldName = key;
//            }
//        }
//        System.out.println("Контакт с номером \"" + phone + "\"" +
//                " уже был в списке под именем \"" + oldName + "\"." + System.lineSeparator() +
//                        "Имя контакта было заменено на \"" + name + "\"");
//        phoneBook.remove(oldName);
//        phoneBook.put(name, phone);
//    }
//
//    public boolean isValidName(String name) {
//        String regexName = "([А-я][а-я]+)\\s?([А-я]+)?\\s?([А-я]+)?";
//        if (name.matches(regexName)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isValidPhone(String phone) {
//        String regexPhone = "([7]|[8])([0-9]{10})";
//        if (phone.matches(regexPhone)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isPhoneContained(String phone){
//        return phoneBook.containsValue(phone);
//    }
//
//    public boolean isNameContained(String name){
//        return phoneBook.containsKey(name);
//    }
//
//    public String phoneBookToString(){
//        Set<String> newSet = getAllContacts();
//        String list = "";
//
//        for (String nextData : newSet) {
//            list += nextData + System.lineSeparator();
//        }
//        return list.trim();
//    }
//
//    public String contactToString(String name){
//        Set<String> newSet = getPhonesByName(name);
//        String contact = "";
//
//        for (String nextData : newSet) {
//            contact += nextData + System.lineSeparator();
//        }
//        return contact.trim();
//    }

}