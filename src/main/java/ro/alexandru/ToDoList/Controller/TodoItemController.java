package ro.alexandru.ToDoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.alexandru.ToDoList.Entity.Task;
import ro.alexandru.ToDoList.Service.TaskService;


@Controller
public class TodoItemController {

    private final TaskService taskService;

    public TodoItemController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public String allTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String createTaskForm() {
        return "create_task";
    }

    @PostMapping("/tasks")
    public String saveTask(@RequestParam("name") String name) {
        Task newTask = new Task(name, false);
        taskService.saveTask(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String ediTaskForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "update_task";
    }

    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task")Task task,Model model) {
        Task exisitngTask = taskService.getTaskById(id);
        exisitngTask.setId(id);
        exisitngTask.setStatus(task.getStatus());
        taskService.updateTask(exisitngTask);
        return "redirect:/tasks";


    }

    @GetMapping("/tasks/{id}")
    public String deleteTaskForm(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }


}
