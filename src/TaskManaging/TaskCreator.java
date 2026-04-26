package TaskManaging;

import TaskInputHandling.TaskInput;
import TaskInputHandling.TaskInputProcessor;
import TaskSorting.TaskSorter;

import java.util.*;

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
