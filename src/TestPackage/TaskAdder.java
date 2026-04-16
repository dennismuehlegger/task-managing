package TestPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskAdder {
    Scanner scanner = new Scanner(System.in);
    TaskList taskList = new TaskList(new ArrayList<>());

    public void addTask(){
        System.out.print("Do you want to add a new Task? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")){
            System.out.print("Enter task title: ");
            String title = scanner.nextLine();

            boolean isDone = false;

            // 1 = low priority, 5 = high priority
            System.out.print("Enter task priority (1-5): ");
            int priority = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter task deadline (YYYY-MM-DD): ");
            String deadline = scanner.nextLine();

            Task newTask = new Task(title, isDone, priority, deadline);

            taskList.addTask(newTask);
        }
    }
}
