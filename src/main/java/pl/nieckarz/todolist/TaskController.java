package pl.nieckarz.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {

    public TaskManager taskManager;

    @Autowired
    public TaskController(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @GetMapping("/")
    String getTask(Model model){
        model.addAttribute("task",taskManager.findAll());
        model.addAttribute("newTask",new Task());


        return "index";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute ("newTask") Task task) {
        System.out.println(task.toString());
            taskManager.save(task);

        return "redirect:/";
    }

    @RequestMapping("/delete/{task}")
    public String deleteTask(@PathVariable(name = "task") String task){
        taskManager.deleteById(task);

        return "redirect:/";
    }

//    @PutMapping("/done/{task}")
//    public String update(@PathVariable(name = "task") String task){
//        System.out.println("button works");
//        return "redirect:/";
//    }




}
