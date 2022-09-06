package todolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.dto.ToDoDto;
import todolist.entity.ToDo;
import todolist.repository.ToDoRepository;
import todolist.service.ToDoService;
import todolist.utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
    private MappingUtils mappingUtils;

    @Override
    public List<ToDo> list() {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        List<ToDo> toDoList = new ArrayList<>();
        toDoIterable.forEach(toDoList::add);
        return toDoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDoDto> listDto() {
        List<ToDoDto> toDoList;
        toDoList = toDoRepository.findAll().stream()
                .map(e -> mappingUtils.mapToToDoDto(e))
                .collect(Collectors.toList());
        return toDoList;
    }

    @Override
    @Transactional
    public Integer add(ToDoDto toDoDto) {
        ToDo toDo = mappingUtils.mapToToDo(toDoDto);
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    @Transactional
    public ToDoDto findById(Integer id) {
        return mappingUtils.mapToToDoDto(
                toDoRepository.findById(id)
                        .orElse(new ToDo())
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> get(Integer id) {

        ToDoDto searchToDo = findById(id);
//        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        return searchToDo.getId() != null
                ? new ResponseEntity<>(searchToDo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(Integer id, ToDoDto toDoDto) {
        ToDo toDo = mappingUtils.mapToToDo(toDoDto);
        ToDo newToDo = toDoRepository.findById(id).orElseThrow();
        newToDo.setToDo(toDo.getToDo());
        toDoRepository.save(newToDo);
        final boolean updated = toDoRepository.findById(id).equals(toDo);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Integer id) {
        toDoRepository.deleteById(id);
        ResponseEntity<?> getToDo = get(id);

        return !getToDo.getStatusCode().is2xxSuccessful()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> clear() {
        toDoRepository.deleteAll();
        List<ToDoDto> checkList = listDto();
        return checkList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
