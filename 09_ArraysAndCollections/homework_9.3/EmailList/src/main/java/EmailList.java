import java.util.*;

public class EmailList {

    public TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется

        if (!emailList.contains(email.toLowerCase(Locale.ROOT)) &&
                isValidEmail(email)) {
            emailList.add(email.toLowerCase(Locale.ROOT));
            System.out.println("Почта \"" + email +
                    "\" была добавлена в список");
        } else {
            System.out.println("Почта \"" + email +
                    " уже есть в списке.");
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);
    }

    public boolean isValidEmail(String email) {
        String regexEmail = ("(\\w+@\\w+\\.\\D+)");
        if (email.matches(regexEmail)){
            return true;
        } else{
            return false;
        }
    }

    public String toString() {
        String list = "";
        List<String> sortedEmails = getSortedEmails();
        for (int nextEmail = 0; nextEmail < sortedEmails.size(); nextEmail++) {
            list += sortedEmails.get(nextEmail) + System.lineSeparator();
        }
        return list.trim();
    }

}
