package FiltersSorting;

import TaskManaging.Task;
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

    private void output(List<Task> taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task number: " + i + " | " + taskList.get(i).toString());
        }
    }

    private List<Task> addFilter(List<Task> taskList, TaskInputs taskInputs) {
        return switch (taskInputs.filterType) {
            case "title" -> taskSorters.sortByTitle(taskList);
            case "priority" -> taskSorters.sortByPriority(taskList);
            case "status" -> taskSorters.sortByDone(taskList);
            case "deadline" -> taskSorters.sortByDeadline(taskList);
            default -> null;
        };
    }
}
