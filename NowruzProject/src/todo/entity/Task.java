package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Task extends Entity implements Trackable {
    public static final int TASK_ENTITY_CODE = 1;
    public enum Status{
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }

    public String title;
    public String description;
    public Date dueDate;
    public Status status;

    private Date creationDate;
    private Date lastModificationDate;

    public Task(String title, String description,Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
    @Override
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    @Override
    public Date getLastModificationDate() {
        return lastModificationDate;
    }
    @Override
    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public int getEntityCode() {
        return TASK_ENTITY_CODE;
    }

    @Override
    public Task copy() {
        Task copyTask = new Task(title, description, dueDate);
        copyTask.status = status;
        copyTask.setCreationDate(creationDate);
        copyTask.setLastModificationDate(lastModificationDate);
        return copyTask;
    }
}
