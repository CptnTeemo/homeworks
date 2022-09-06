import java.util.ArrayList;

public class TodoList {

    public ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("Добавлено дело \"" + todo.trim() + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index < todoList.size()){
            System.out.println("Дело \"" + todo + "\" было поставлено " +
                    "на место " + index);
            todoList.add(index, todo);
        } else {
            System.out.println("Дела с номером " + index + " нет в списке." +
                    " Дело \"" + todo + "\" было добавлено в конец списка");
            todoList.add(todo);
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index < todoList.size()){
            System.out.println("Дело \"" + todoList.get(index) + "\"" +
                    " было заменено на \"" + todo.trim() + "\"");
            todoList.remove(index);
            todoList.add(index, todo);
        } else {
            System.out.println("Дела с номером " + index + " нет в списке." +
                    "Изменения не приняты");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index < todoList.size()){
            System.out.println("Дело \"" + todoList.get(index) + "\"" +
                    " было удалено");
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }

    public String toString(){
        String list = "";
        if (todoList.size() == 0){
            return "Список дел пуст. Добавьте новые дела";
        }
        for (int i = 0; i < todoList.size(); i++){
            list += i + " - " + todoList.get(i) + System.lineSeparator();
        }

        return list.trim();
    }

}