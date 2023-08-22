package model;
import java.util.LinkedList;

public class User {

    private Task newTask;
    private LinkedList<Task> listaTask ;

    public User() {
        this.listaTask=new LinkedList<>();
    }

    public void asignTask(String name_user, String name_task, String description) {
        newTask = new Task(name_user, name_task, description);
        listaTask.add(newTask);
    }

    public LinkedList<Task> getListTask() {
        return listaTask;
    }
}
