package TestPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// DONE - filter functionality based on priority, deadline, done or title (alphabetic). sort of works now :)
// todo - refactoring so not everything is in this class
// todo - add H2 database and dont rely on scanner (makes it look more real so probably needs to be implemented)
// todo - asc and desc?
// todo - multiple filters at the same time?
// todo - add (input) validation (try catch)
// todo - tests
// todo - deadline cannot be set before current date?
// todo - visualization? (HIGHLY unlikely until end of project)
/*  DEADLINE FOR MYSELF PLEASE GET THIS DONE BY 26.04.2026!
    WORK ON IT AT LEAST 3 HOURS ON WEEKENDS AND AT LEAST 1 ON WEEKDAYS!!!
    THE (?) DONT NEED TO BE IMPLEMENTED BY THEN BUT AT LEAST THE BASIC FUNCTIONALITY SHOULD WORK
 */
public class TaskAdder {
    Scanner scanner = new Scanner(System.in);
    List<Task> taskList = new ArrayList<>();

    private void createTasks() {
        boolean continueAdding = true;
        do {
            System.out.print("Do you want to add a new Task? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                addTaskToList();
            } else {
                continueAdding = false;
            }
        } while (continueAdding);

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task number: " + i + " | " + taskList.get(i).toString());
        }
    }

    private void addTaskToList() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        boolean isDone = false;

        // 1 = low priority, 5 = high priority
        System.out.print("Enter task priority (1-5): ");
        int priority = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        LocalDate deadline = scanToLocalDate(scanner.nextLine());

        Task newTask = new Task(title, isDone, priority, deadline);
        taskList.add(newTask);
    }

    private void createFilters() {
        System.out.print("Do you want to add a Filter? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            List<Task> filteredTasks = addFilter();

            for (int i = 0; i < filteredTasks.size(); i++) {
                System.out.println("Task number: " + i + " | " + filteredTasks.get(i).toString());
            }
        }
    }

    private List<Task> addFilter() {
        System.out.print("Which filter should be used? (title, priority, status, deadline): ");
        String input = scanner.nextLine();
        return switch (input.toLowerCase()) {
            case "title" -> filterByTitle(taskList);
            case "priority" -> filterByPriority(taskList);
            case "status" -> filterByDone(taskList);
            case "deadline" -> filterByDeadline(taskList);
            default -> null;
        };
    }

    private LocalDate scanToLocalDate(String input) {
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        }
    }

    private List<Task> filterByPriority(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
    }

    private List<Task> filterByDeadline(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getDeadline)).collect(Collectors.toList());
    }

    private List<Task> filterByDone(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::isDone)).collect(Collectors.toList());
    }

    private List<Task> filterByTitle(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        TaskAdder taskAdder = new TaskAdder();
        taskAdder.createTasks();
        taskAdder.createFilters();
    }
}
