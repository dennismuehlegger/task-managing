package taskinputhandling;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskInput {
    public boolean isAdding;

    public String title;

    public boolean isDone;

    public int priority;

    public LocalDate deadline;

    public boolean isSorting;

    public boolean isDescSorting;

    public String sortingType;

    Scanner scanner = new Scanner(System.in);

    public TaskInput(boolean isAdding, String title, boolean isDone, int priority, LocalDate deadline, boolean isSorting, boolean isDescSorting, String sortingType) {
        this.isAdding = isAdding;
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
        this.deadline = deadline;
        this.isSorting = isSorting;
        this.isDescSorting = isDescSorting;
        this.sortingType = sortingType;
    }

    public TaskInput() {

    }

    public TaskInput readInputsForTaskCreation(TaskInputProcessor taskInputProcessor) {
        System.out.print("Do you want to add a new Task? (yes/no): ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(TaskInputEnums.YES.value)){
            System.out.print("Enter task title: ");
            String titleInput = scanner.nextLine();

            String priorityInput;
            do {
                // 1 = low priority, 5 = high priority
                System.out.print("Enter task priority (1-5): ");
                priorityInput = scanner.nextLine();
            } while (!priorityInput.matches("[1-5]"));

            String deadlineInput;
            do {
                System.out.print("Enter task deadline (YYYY-MM-DD): ");
                deadlineInput = scanner.nextLine();
            } while (!deadlineInput.matches("\\d{4}-\\d{2}-\\d{2}"));
            return taskInputProcessor.processTaskCreation(this, titleInput, priorityInput, deadlineInput);
        }
        return null;
    }

    public TaskInput readInputsForTaskSorting(TaskInputProcessor taskInputProcessor) {
        String sortingInput = null;
        System.out.print("Do you want to sort this list? (yes/no): ");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase(TaskInputEnums.YES.value)){
            System.out.print("Which field should this list be sorted by? (title, priority, status, deadline): ");
            sortingInput = scanner.nextLine();
        }

        System.out.print("sorting order? (asc/desc): ");
        String sortingOrder = scanner.nextLine();
        return taskInputProcessor.processInputsForTaskSorting(this, sortingInput, sortingOrder);
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

    public boolean isSorting() {
        return isSorting;
    }

    public void setSorting(boolean sorting) {
        isSorting = sorting;
    }

    public boolean isDescSorting() {
        return isDescSorting;
    }

    public void setDescSorting(boolean descSorting) {
        isDescSorting = descSorting;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
