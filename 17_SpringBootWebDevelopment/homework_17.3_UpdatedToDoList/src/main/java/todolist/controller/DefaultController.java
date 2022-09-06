package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import todolist.dto.ToDoDto;
import todolist.service.impl.ToDoServiceImpl;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private ToDoServiceImpl toDoService;

    @GetMapping("/")
    public String todo(Model model) {

        List<ToDoDto> toDoDtoList = toDoService.listDto();
        model.addAttribute("todoList", toDoDtoList);
        model.addAttribute("todoCount", toDoDtoList.size());
        return "todo";
    }
}
