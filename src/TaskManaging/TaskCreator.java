package TaskManaging;

import TaskInputHandling.TaskInput;
import TaskInputHandling.TaskInputProcessor;
import TaskSorting.TaskSorter;

import java.util.*;

// note - db implementation saved for another more suitable project
// DONE - filter functionality based on priority, deadline, done or title (alphabetic).
// DONE - asc and desc?
// DONE - make methods not reliant on scanner for better testability
// DONE - refactoring so not everything is in this class
// DONE - add (input) validation (try catch)
// DONE - magic string removal
// DONE? - task input class overhaul - getting closer to solution
// DONE - naming convention!!!
// DONE - add invalid tests
// DONE - refactoring is largely done but more will probably come later
// NOT NECESSARY - multiple filters at the same time?
// NOT NECESSARY - deadline cannot be set before current date?
// REVISION SOME TIME LATER - visualization?
public class TaskCreator {

    TaskSorter taskSorter = new TaskSorter();

    public void createTasks(List<Task> taskList, List<TaskInput> taskCreationInputs, TaskInput taskSortingInputs) {
        for (TaskInput taskInput : taskCreationInputs) {
            addTaskToList(taskList, taskInput);
        }
        if (taskSortingInputs != null && (taskSortingInputs.isSorting || taskSortingInputs.isDescSorting)) {
            taskSorter.addSorting(taskList, taskSortingInputs);
        } else {
            taskSorter.output(taskList);
        }
    }

    private List<TaskInput> prepareTaskCreationInputs() {
        List<TaskInput> taskInputList = new ArrayList<>();
        TaskInputProcessor taskInputProcessor = new TaskInputProcessor();
        boolean continueAdding = true;
        do {
            TaskInput taskInput = new TaskInput().readInputsForTaskCreation(taskInputProcessor);
            if (taskInput != null && taskInput.isAdding) {
                taskInputList.add(taskInput);
            } else {
                continueAdding = false;
            }
        } while (continueAdding);
        return taskInputList;
    }

    private TaskInput prepareTaskSortingInputs() {
        TaskInputProcessor taskInputProcessor = new TaskInputProcessor();
        return new TaskInput().readInputsForTaskSorting(taskInputProcessor);
    }

    private void addTaskToList(List<Task> taskList, TaskInput taskInputs) {
        Task newTask = new Task(taskInputs.getTitle(), taskInputs.isDone, taskInputs.getPriority(), taskInputs.getDeadline());
        taskList.add(newTask);
    }

    public static void main(String[] args) {
        TaskCreator taskCreator = new TaskCreator();
        List<Task> taskList = new ArrayList<>();
        TaskInput taskSortingInputs = null;
        List<TaskInput> taskInputs = taskCreator.prepareTaskCreationInputs();
        if (taskInputs.size() > 1){
            taskSortingInputs = taskCreator.prepareTaskSortingInputs();
        }
        taskCreator.createTasks(taskList, taskInputs, taskSortingInputs);
    }
}
