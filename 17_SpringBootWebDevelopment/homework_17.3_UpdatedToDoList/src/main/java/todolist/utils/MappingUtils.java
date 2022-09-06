package todolist.utils;

import org.springframework.stereotype.Service;
import todolist.dto.ToDoDto;
import todolist.entity.ToDo;

@Service
public class MappingUtils {

    public static ToDoDto mapToToDoDto(ToDo toDo) {
        ToDoDto toDoDto = new ToDoDto();
        toDoDto.setId(toDo.getId());
        toDoDto.setToDo(toDo.getToDo());
        return toDoDto;
    }

    public static ToDo mapToToDo(ToDoDto toDoDto) {
        ToDo toDo = new ToDo();
        toDo.setId(toDoDto.getId());
        toDo.setToDo(toDoDto.getToDo());
        return toDo;
    }
}
