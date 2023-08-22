package presenter;

import model.Task;
import view.View;

import java.util.LinkedList;

public class Presenter {
    private View view;
    private LinkedList<Task> tasks = new LinkedList<>();

    public Presenter(View view) {
        this.view = view;
    }

    public void assignTask(String userName, String taskName, String description,String dueDate) {
        Task task = new Task(userName, taskName, description,dueDate);
        tasks.add(task);
    }

    public String getTaskList() {
        StringBuilder taskList = new StringBuilder();
        for (Task task : tasks) {
            taskList.append("\n\n   Usuario: ").append(task.getName_user()).append("\n");
            taskList.append("   Tarea: ").append(task.getName_task()).append("\n");
            taskList.append("   Descripción: ").append(task.getDescription()).append("\n");
            taskList.append("   Fecha limite: ").append(task.getDue_date()).append("\n\n");
        }
        return taskList.toString();
    }

    public static void main(String[] args) {
        View view = new View();
        Presenter presenter = new Presenter(view);
        view.setPresenter(presenter);
        view.showView();
    }
}