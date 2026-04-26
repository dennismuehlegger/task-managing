package tasksorting;

import taskmanaging.Task;
import taskinputhandling.TaskInputEnums;
import taskinputhandling.TaskInput;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskSorter {

    public List<Task> sortByPriority(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getPriority));
        return tasks;
    }

    public List<Task> sortByDeadline(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDeadline));
        return tasks;
    }

    public List<Task> sortByDone(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::isDone));
        return tasks;
    }

    public List<Task> sortByTitle(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getTitle));
        return tasks;
    }

    public void addSorting(List<Task> taskList, TaskInput taskInputs) {
        List<Task> sortedTasks = taskList;
        if (taskInputs.isSorting){
            sortedTasks = applySorting(taskList, taskInputs);
        }
        if (taskInputs.isDescSorting) {
            Collections.reverse(sortedTasks);
        }
        output(sortedTasks);
    }

    public void output(List<Task> taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task number: " + i + " | " + taskList.get(i).toString());
        }
    }

    private List<Task> applySorting(List<Task> taskList, TaskInput taskInputs) {
        TaskInputEnums taskInputEnums = TaskInputEnums.valueOf(taskInputs.sortingType.toUpperCase());
        return switch (taskInputEnums) {
            case TITLE -> sortByTitle(taskList);
            case PRIORITY -> sortByPriority(taskList);
            case STATUS -> sortByDone(taskList);
            case DEADLINE -> sortByDeadline(taskList);
            default -> null;
        };
    }
}
