package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolist.dto.ToDoDto;
import todolist.entity.ToDo;
import todolist.service.impl.ToDoServiceImpl;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoServiceImpl toDoService;

    @GetMapping(value = "/todo")
    public List<ToDoDto> list() {
        return toDoService.listDto();
    }

    @PostMapping(value = "/todo")
    public int add(@RequestBody ToDoDto toDoDto) {
        return toDoService.add(toDoDto);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        return toDoService.get(id);
    }

    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ToDoDto toDoDto) {
        return toDoService.update(id, toDoDto);
    }

    @DeleteMapping(value = "/todo/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return toDoService.delete(id);
    }

    @DeleteMapping(value = "/todo")
    public ResponseEntity<?> clear() {
        return toDoService.clear();
    }
}
