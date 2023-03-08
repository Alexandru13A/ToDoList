package ro.alexandru.ToDoList.Service;

import org.springframework.stereotype.Service;
import ro.alexandru.ToDoList.Entity.Task;
import ro.alexandru.ToDoList.Repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
