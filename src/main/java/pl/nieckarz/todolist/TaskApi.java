package pl.nieckarz.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskApi {

    private TaskManager taskManager;

    @Autowired
    public TaskApi(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @GetMapping("/all")
    public Iterable<Task> getAll() {
        return taskManager.findAll();
    }

    @GetMapping
    public Optional<Task> getById(@RequestParam Long id) {
        return taskManager.findById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
         return taskManager.save(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskManager.save(task);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Long id) {
        taskManager.deleteById(id);
    }

}
