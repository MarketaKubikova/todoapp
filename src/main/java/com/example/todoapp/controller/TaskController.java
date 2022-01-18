package com.example.todoapp.controller;

import com.example.todoapp.entity.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView taskList() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("taskList", taskService.taskList());
        return modelAndView;
    }

    /**
     * Displays a form for adding new task
     *
     * @param model
     * @return form for adding new tasks
     */
    @GetMapping("/add-task")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "new";
    }

    /**
     * Adds new task into list
     *
     * @param task using @Entity Task
     * @return redirects back to index
     */
    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    /**
     * Deletes selected task from list
     * @param id is auto-generated id of each task
     * @return redirects back to index
     */
    @DeleteMapping(value="/delete/{id}")
    public String deleteTask(@PathVariable Short id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
