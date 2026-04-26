package taskmanaging;

import java.time.LocalDate;

public class Task implements Comparable<Task> {
    public String title;
    public boolean isDone;
    public int priority;
    public LocalDate deadline;

    public Task(String title, boolean isDone, int priority, LocalDate deadline) {
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
        this.deadline = deadline;
    }

    public Task() {

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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Done: " + isDone + " | Priority: " + priority + " | Deadline: " + deadline;
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }
}
