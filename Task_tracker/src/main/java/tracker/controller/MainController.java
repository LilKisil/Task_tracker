package tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tracker.entity.Task;
import tracker.service.TaskService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public String showHomePage(Model model){
        List<Task> taskList = taskService.findAllNotes();
        model.addAttribute("taskList", taskList);
        return "home_page";
    }

    @GetMapping("/new")
    public String createNewTask() {
        return "create_task";
    }

    @PostMapping("/save")
    public String createTask(@RequestParam String title, @RequestParam String description, @RequestParam String status) {
        taskService.saveNote(new Task(title, description, status));
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Integer id, Model model) {
        Task task = taskService.getNoteById(id);
        model.addAttribute("task", task);
        return "edit_page";
    }

    @PostMapping("/update")
    public String saveTask(@RequestParam Integer id, @RequestParam String title, @RequestParam String description,
                           @RequestParam String status) {
        taskService.updateTask(id, title, description, status);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteNoteById(id);
        return "redirect:/";
    }

}
