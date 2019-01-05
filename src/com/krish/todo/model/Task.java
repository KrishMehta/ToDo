package com.krish.todo.model;

/**
 * Class created by Krish
 */

public class Task {

    private long date;
    private String description;
    private String task;

    public Task() {
    }

    public Task(long date, String description, String task) {
        this.date = date;
        this.description = description;
        this.task = task;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
