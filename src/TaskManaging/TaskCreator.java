package TaskManaging;

import FiltersSorting.TaskFilters;

import java.util.*;

// note - db implementation saved for another more suitable project
// DONE - filter functionality based on priority, deadline, done or title (alphabetic).
// DONE - asc and desc?
// DONE - make methods not reliant on scanner for better testability
// DONE - refactoring so not everything is in this class
// DONE - add (input) validation (try catch)
// DONE - magic string removal
// todo - refactoring is largely done but more will probably come later
// todo - task input class overhaul - better rn but still not ideal
// todo - naming convention!!!
// todo - add more tests XXX NEXT UP
// todo - multiple filters at the same time?
// todo - deadline cannot be set before current date?
// todo - visualization? (HIGHLY unlikely until end of project)
/*  DEADLINE FOR MYSELF PLEASE GET THIS DONE BY 26.04.2026!
    WORK ON IT AT LEAST 3 HOURS ON WEEKENDS AND AT LEAST 1 ON WEEKDAYS!!!
    THE (?) DONT NEED TO BE IMPLEMENTED BY THEN BUT AT LEAST THE BASIC FUNCTIONALITY SHOULD WORK
 */
public class TaskCreator {

    TaskFilters taskFilters = new TaskFilters();

    public void createTasks(List<Task> taskList, List<TaskInputs> taskCreationInputs, TaskInputs taskFilteringInputs) {
        for (TaskInputs taskInput : taskCreationInputs) {
            addTaskToList(taskList, taskInput);
        }
        if (taskFilteringInputs.isFiltering || taskFilteringInputs.isSorting) {
            taskFilters.createFilters(taskList, taskFilteringInputs);
        } else {
            taskFilters.output(taskList);
        }
    }

    private List<TaskInputs> prepareTaskCreationInputs() {
        List<TaskInputs> taskInputsList = new ArrayList<>();
        boolean continueAdding = true;
        do {
            TaskInputs taskInput = new TaskInputs().readInputsForTaskCreation();
            if (taskInput.isAdding &&
                    (taskInput.getPriority() != 0 || taskInput.getDeadline() != null)) {
                taskInputsList.add(taskInput);
            } else {
                continueAdding = false;
            }
        } while (continueAdding);
        return taskInputsList;
    }

    private TaskInputs prepareTaskFilteringInputs() {
        try {
            return new TaskInputs().readInputsForTaskFilteringAndSorting();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for filtering/sorting. Please try again.");
            return new TaskInputs().readInputsForTaskFilteringAndSorting();
        }
    }

    private void addTaskToList(List<Task> taskList, TaskInputs taskInputs) {
        Task newTask = new Task(taskInputs.getTitle(), taskInputs.isDone, taskInputs.getPriority(), taskInputs.getDeadline());
        taskList.add(newTask);
    }

    public static void main(String[] args) {
        TaskCreator taskCreator = new TaskCreator();
        List<Task> taskList = new ArrayList<>();
        List<TaskInputs> taskInputs = taskCreator.prepareTaskCreationInputs();
        TaskInputs taskFilteringInputs = taskCreator.prepareTaskFilteringInputs();
        taskCreator.createTasks(taskList, taskInputs, taskFilteringInputs);
    }
}
