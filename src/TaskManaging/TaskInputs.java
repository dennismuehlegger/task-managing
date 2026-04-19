package TaskManaging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void getInputsForTaskCreation(boolean isAdding, String title, boolean isDone, int priority, LocalDate deadline) {
        TaskInputs taskInputs = new TaskInputs();
        taskInputs.setAdding(isAdding);
        taskInputs.setTitle(title);
        taskInputs.setDone(isDone);
        taskInputs.setPriority(priority);
        taskInputs.setDeadline(deadline);
    }

    public void getInputsForTaskFilteringAndSorting(boolean isFiltering, boolean isSorting, String filterType) {
        TaskInputs taskInputs = new TaskInputs();
        taskInputs.setFiltering(isFiltering);
        taskInputs.setSorting(isSorting);
        taskInputs.setFilterType(filterType);
    }

    public void readInputsForTaskCreation() {
            System.out.print("Do you want to add a new Task? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                setAdding(true);

                System.out.print("Enter task title: ");
                setTitle(scanner.nextLine());

                setDone(false);

                // 1 = low priority, 5 = high priority
                System.out.print("Enter task priority (1-5): ");
                setPriority(Integer.parseInt(scanner.nextLine()));

                System.out.print("Enter task deadline (YYYY-MM-DD): ");
                setDeadline(scanToLocalDate(scanner.nextLine()));
            }
            else {
                setAdding(false);
            }
        getInputsForTaskCreation(isAdding(), getTitle(), isDone(), getPriority(), getDeadline());
    }

    public void readInputsForTaskFilteringAndSorting(){
        System.out.print("Do you want to add a Filter? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            setFiltering(true);
        }

        System.out.print("Which filter should be used? (title, priority, status, deadline): ");
        setFilterType(scanner.nextLine());

        System.out.print("sorting order? (asc/desc): ");
        if (scanner.nextLine().equalsIgnoreCase("desc")) {
            setSorting(true);
        }
        getInputsForTaskFilteringAndSorting(isFiltering(), isSorting(), getFilterType());
    }

    private LocalDate scanToLocalDate(String input) {
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        }
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
