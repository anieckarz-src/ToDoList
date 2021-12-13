package pl.nieckarz.todolist;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    private String task;

    private Difficult dif;
    private boolean done;

    public Task() {
    }

    public Task(String task, Difficult dif) {
        this.task = task;
        this.dif = dif;
        this.done = false;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Difficult getDif() {
        return dif;
    }

    public void setDif(Difficult dif) {
        this.dif = dif;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", task='" + task + '\'' +
                ", dif=" + dif +
                ", done=" + done +
                '}';
    }


}
