import TaskManaging.Task;
import TaskManaging.TaskCreator;
import TaskManaging.TaskInputs;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TaskTests {

    //simple test to prove that it works. needs to be separated more in the future into multiple tests for creation, filtering and sorting
    @Test
    public void testTaskCreation(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInputs> taskCreationInputList = new ArrayList<>();

        TaskInputs taskCreationInputs = new TaskInputs(true, "b", false, 5, LocalDate.now(), false, false, null);
        TaskInputs taskCreationInputs1 = new TaskInputs(true, "a", false, 5, LocalDate.of(2012, 2,2), false, false, null);
        taskCreationInputList.add(taskCreationInputs);
        taskCreationInputList.add(taskCreationInputs1);
        TaskInputs taskFilteringInputs = new TaskInputs(false, null, false, 0, null, true, false, "title");

        taskCreator.createTasks(tasklist, taskCreationInputList, taskFilteringInputs);

        assertEquals("2 tasks should exist", 2, tasklist.size());
        assertEquals("task a should be first after sorting", "a", tasklist.get(0).getTitle());
    }
}
