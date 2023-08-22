package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private String name_user;
    private String name_task;
    private String description;
    private Date dueDate;

    public Task(String name_user, String name_task, String description,String dueDate) {
        this.name_user = name_user;
        this.name_task = name_task;
        this.description = description;

       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dueDate = dateFormat.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public String getName_user() {
        return name_user;
    }

    public String getName_task(){
        return name_task;
    }
    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
    public void setName_task(String name_task){
        this.name_task=name_task;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public Date getDue_date(){
        return dueDate;
    }

    public void Date(Date due_date){
        this.dueDate=due_date;
    }
}
