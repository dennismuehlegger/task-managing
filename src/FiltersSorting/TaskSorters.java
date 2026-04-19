package FiltersSorting;

import TaskManaging.Task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSorters {

    public List<Task> sortByPriority(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
    }

    public List<Task> sortByDeadline(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getDeadline)).collect(Collectors.toList());
    }

    public List<Task> sortByDone(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::isDone)).collect(Collectors.toList());
    }

    public List<Task> sortByTitle(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
    }
}
