package main;

import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoListController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(value = "/todo/")
    public List<ToDo> list() {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        List<ToDo> toDoList = new ArrayList<>();
        toDoIterable.forEach(toDoList::add);
        return toDoList;
    }

    @PostMapping(value = "/todo/")
    public int add(@RequestBody ToDo toDo) {
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {

        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        return optionalToDo.isPresent()
                ? new ResponseEntity<>(optionalToDo.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ToDo toDo) {
        ToDo newToDo = toDoRepository.findById(id).orElseThrow();
        newToDo.setToDo(toDo.getToDo());
        toDoRepository.save(newToDo);
        final boolean updated = toDoRepository.findById(id).equals(toDo);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/todo/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        toDoRepository.deleteById(id);
        ResponseEntity<?> getToDo = get(id);

        return !getToDo.getStatusCode().is2xxSuccessful()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/todo/")
    public ResponseEntity<?> clear() {
        toDoRepository.deleteAll();
        List<ToDo> checkList = list();
        return checkList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
