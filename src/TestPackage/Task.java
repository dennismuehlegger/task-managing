package TestPackage;

import java.util.Date;

public class Task {
    public String title;
    public boolean isDone;
    public int priority;
    public Date deadline;

    public Task(String title, boolean isDone, int priority, Date deadline) {
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
        this.deadline = deadline;
    }

    private boolean markAsDone(){
        return this.isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
