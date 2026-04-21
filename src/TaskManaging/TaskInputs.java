package TaskManaging;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskInputs {
    public boolean isAdding;

    public String title;

    public boolean isDone;

    public int priority;

    public LocalDate deadline;

    public boolean isFiltering;

    public boolean isSorting;

    public String filterType;

    public TaskInputProcessor taskInputProcessor;

    Scanner scanner = new Scanner(System.in);

    public TaskInputs(boolean isAdding, String title, boolean isDone, int priority, LocalDate deadline, boolean isFiltering, boolean isSorting, String filterType) {
        this.isAdding = isAdding;
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
        this.deadline = deadline;
        this.isFiltering = isFiltering;
        this.isSorting = isSorting;
        this.filterType = filterType;
    }

    public TaskInputs() {

    }

    public TaskInputs readInputsForTaskCreation() {
        System.out.print("Do you want to add a new Task? (yes/no): ");
        String userInput = scanner.nextLine();


        System.out.print("Enter task title: ");
        String titleInput = scanner.nextLine();

        // 1 = low priority, 5 = high priority
        System.out.print("Enter task priority (1-5): ");
        String priorityInput = scanner.nextLine();

        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        String deadlineInput = scanner.nextLine();

        return taskInputProcessor.processTaskCreation(userInput, titleInput, priorityInput, deadlineInput);
    }

    public TaskInputs readInputsForTaskFilteringAndSorting() {
        System.out.print("Do you want to add a Filter? (yes/no): ");
        String userInput = scanner.nextLine();
        System.out.print("Which filter should be used? (title, priority, status, deadline): ");
        String filterInput = scanner.nextLine();

        System.out.print("sorting order? (asc/desc): ");
        String sortingInput = scanner.nextLine();
        return taskInputProcessor.processInputsForTaskFilteringAndSorting(userInput, filterInput, sortingInput);
    }

    public boolean isAdding() {
        return isAdding;
    }

    public void setAdding(boolean adding) {
        isAdding = adding;
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

    public boolean isFiltering() {
        return isFiltering;
    }

    public void setFiltering(boolean filtering) {
        isFiltering = filtering;
    }

    public boolean isSorting() {
        return isSorting;
    }

    public void setSorting(boolean sorting) {
        isSorting = sorting;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
