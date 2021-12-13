package pl.nieckarz.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskManager {

    private TaskRepository taskRepository;

    @Autowired
    public TaskManager(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> findById(String task){
        return  taskRepository.findById(task);
    }

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(String task){
        taskRepository.deleteById(task);
    }





    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Task("make a bed",Difficult.EASY));
    }
}
