package com.example.todoapp.controller;

import com.example.todoapp.service.TaskService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller operating the displaying of tasks
 */
@Controller
@RequestMapping(value = "/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Displays list of tasks
     * <p>
     * Method operating the display of the path {@code /}. Using the template {@code /templates/index.html}.
     */
    @GetMapping("/")
    public ModelAndView taskList(@PageableDefault(sort = {"date"}) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("taskList", taskService.taskList(pageable));
        return modelAndView;
    }
}
