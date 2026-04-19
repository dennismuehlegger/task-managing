package FiltersSorting;

import TaskManaging.Task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSorters {

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
}
