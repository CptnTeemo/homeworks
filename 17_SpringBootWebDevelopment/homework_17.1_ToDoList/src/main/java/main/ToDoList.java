package main;

import main.model.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ToDoList {
    private static int currentId = 1;
    private static HashMap<Integer, ToDo> toDoList = new HashMap<>();

    public static void setCurrentId(int currentId) {
        ToDoList.currentId = currentId;
    }

    public static void setToDoList(HashMap<Integer, ToDo> toDoList) {
        ToDoList.toDoList = toDoList;
    }

    public static List<ToDo> getAllToDo() {
        List<ToDo> bookList = new ArrayList<>();
        bookList.addAll(toDoList.values());
        return bookList;
    }

    public static int addToDo(ToDo toDo) {
        int id = currentId++;
        toDo.setId(id);
        toDoList.put(id, toDo);
        return id;
    }

    public static ToDo getToDO(int toDoId) {
        if (toDoList.containsKey(toDoId)) {
            return toDoList.get(toDoId);
        }
        return null;
    }

    public static boolean update(ToDo toDo, int id) {
        if (toDoList.containsKey(id)) {
            toDo.setId(id);
            toDoList.put(id, toDo);
            return true;
        }
        return false;
    }

    public static boolean delete(int id) {
        return toDoList.remove(id) != null;
    }

    public static boolean clearToDoList() {
        setCurrentId(1);
        setToDoList(new HashMap<>());
        return currentId == 1 && toDoList.isEmpty();
    }
}
