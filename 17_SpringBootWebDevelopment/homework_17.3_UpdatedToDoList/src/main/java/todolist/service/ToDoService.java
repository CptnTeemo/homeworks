package todolist.service;

import org.springframework.http.ResponseEntity;
import todolist.dto.ToDoDto;
import todolist.entity.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> list();
    List<ToDoDto> listDto();
    Integer add(ToDoDto toDoDto);
    ResponseEntity<?> get(Integer id);
    ResponseEntity<?> update(Integer id, ToDoDto toDoDto);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> clear();

}
