package TestPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// todo - filter functionality based on priority, deadline, done or title (alphabetic).
// todo - multiple filters at the same time?
// todo - add input validation (try catch)
// todo - tests
// todo - deadline cannot be set before current date?
// todo - visualization?
/*  DEADLINE FOR MYSELF PLEASE GET THIS DONE BY 26.04.2026!
    WORK ON IT AT LEAST 3 HOURS ON WEEKENDS AND AT LEAST 1 ON WEEKDAYS!!!
    THE (?) DONT NEED TO BE IMPLEMENTED BY THEN BUT AT LEAST THE BASIC FUNCTIONALITY SHOULD WORK
 */
public class TaskAdder {
    Scanner scanner = new Scanner(System.in);
    List<Task> taskList = (new ArrayList<>());

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

    private LocalDate scanToLocalDate(String input) {
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
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

    public static void main(String[] args) {
        TaskAdder taskAdder = new TaskAdder();
        taskAdder.createTasks();
    }
}
