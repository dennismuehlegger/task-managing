package FiltersSorting;

import TaskManaging.Task;
import TaskManaging.TaskInputEnums;
import TaskManaging.TaskInputs;

import java.util.Collections;
import java.util.List;

public class TaskFilters {

    TaskSorters taskSorters = new TaskSorters();

    public void createFilters(List<Task> taskList, TaskInputs taskInputs) {
        List<Task> filteredTasks = taskList;
        if (taskInputs.isFiltering){
            filteredTasks = addFilter(taskList, taskInputs);
        }
        if (taskInputs.isSorting) {
            Collections.reverse(filteredTasks);
        }
        output(filteredTasks);
    }

    public void output(List<Task> taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task number: " + i + " | " + taskList.get(i).toString());
        }
    }

    private List<Task> addFilter(List<Task> taskList, TaskInputs taskInputs) {
        TaskInputEnums taskInputEnums = TaskInputEnums.valueOf(taskInputs.filterType.toUpperCase());
        return switch (taskInputEnums) {
            case TITLE -> taskSorters.sortByTitle(taskList);
            case PRIORITY -> taskSorters.sortByPriority(taskList);
            case STATUS -> taskSorters.sortByDone(taskList);
            case DEADLINE -> taskSorters.sortByDeadline(taskList);
            default -> null;
        };
    }
}
