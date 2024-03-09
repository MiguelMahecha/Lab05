package edu.eci.cvds.lab05.controller;

import edu.eci.cvds.lab05.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class TodoController {
    @GetMapping("/todos")
    private String getTodos(@RequestParam(name = "taskId", defaultValue = "1", required = false) String taskId, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        RestTemplate restTemplate = new RestTemplate();

        Task task = restTemplate.getForObject(uri, Task.class);

        assert task != null;

        model.addAttribute("userId", task.getUserId());
        model.addAttribute("id", task.getId());
        model.addAttribute("title", task.getTitle());
        model.addAttribute("completed", task.isCompleted());

        return "todos";

//        ModelAndView modelAndView = new ModelAndView("todos");
//        modelAndView.addObject("todo", task);
//
//        assert task != null;
//        System.out.println(task.getTitle());
//
//        return modelAndView;
    }
}
