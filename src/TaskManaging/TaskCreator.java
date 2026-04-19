package TaskManaging;

import FiltersSorting.TaskFilters;

import java.util.*;

// note - db implementation saved for another more suitable project
// DONE - filter functionality based on priority, deadline, done or title (alphabetic).
// DONE - asc and desc?
// DONE - make methods not reliant on scanner for better testability
// DONE - refactoring so not everything is in this class
// todo - refactoring is largely done but more will probably come later
// todo - task input class overhaul - messy asf rn
// todo - naming convention
// todo - add (input) validation (try catch)
// todo - tests (ADD SOME TESTS IN THE EVENING OR TOMORROW)
// todo - multiple filters at the same time?
// todo - deadline cannot be set before current date?
// todo - visualization? (HIGHLY unlikely until end of project)
/*  DEADLINE FOR MYSELF PLEASE GET THIS DONE BY 26.04.2026!
    WORK ON IT AT LEAST 3 HOURS ON WEEKENDS AND AT LEAST 1 ON WEEKDAYS!!!
    THE (?) DONT NEED TO BE IMPLEMENTED BY THEN BUT AT LEAST THE BASIC FUNCTIONALITY SHOULD WORK
 */
public class TaskCreator {

    TaskFilters taskFilters = new TaskFilters();

    TaskInputs taskInputs = new TaskInputs();

    private void createTasks(List<Task> taskList) {
        boolean continueAdding = true;
        do {
            taskInputs.readInputsForTaskCreation();
            if (taskInputs.isAdding){
                addTaskToList(taskList, taskInputs);
            }
            else {
                continueAdding = false;
            }
        } while (continueAdding);
        taskInputs.readInputsForTaskFilteringAndSorting();
        if (taskInputs.isFiltering || taskInputs.isSorting) {
            taskFilters.createFilters(taskList, taskInputs);
        }
    }

    private void addTaskToList(List<Task> taskList, TaskInputs taskInputs) {
        Task newTask = new Task(taskInputs.getTitle(), taskInputs.isDone, taskInputs.getPriority(), taskInputs.getDeadline());
        taskList.add(newTask);
    }

    public static void main(String[] args) {
        TaskCreator taskCreator = new TaskCreator();
        List<Task> taskList = new ArrayList<>();
        taskCreator.createTasks(taskList);
    }
}
