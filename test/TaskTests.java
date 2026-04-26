import taskmanaging.Task;
import taskmanaging.TaskCreator;
import taskinputhandling.TaskInput;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TaskTests {

    @Test
    public void testTaskCreation(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInput> taskCreationInputList = new ArrayList<>();

        TaskInput taskCreationInputs1 = new TaskInput(true, "bee", false, 5, LocalDate.of(2012, 2,2), false, false, null);
        taskCreationInputList.add(taskCreationInputs1);
        TaskInput taskSortingInputs = new TaskInput(false, null, false, 0, null, false, false, null);

        taskCreator.createTasks(tasklist, taskCreationInputList, taskSortingInputs);

        assertEquals("1 task should exist", 1, tasklist.size());
        assertEquals("task should be named bee", "bee", tasklist.get(0).getTitle());
        assertEquals("task should have priority 5", 5, tasklist.get(0).getPriority());
        assertEquals("task should have deadline 2012-02-02", LocalDate.of(2012, 2,2), tasklist.get(0).getDeadline());
    }

    @Test
    public void testMultipleTaskCreation(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInput> taskCreationInputList = new ArrayList<>();

        TaskInput taskCreationInputs = new TaskInput(true, "bee", false, 3, LocalDate.of(2019, 8, 15), false, false, null);
        TaskInput taskCreationInputs1 = new TaskInput(true, "apple", false, 5, LocalDate.of(2012, 2,2), false, false, null);
        taskCreationInputList.add(taskCreationInputs);
        taskCreationInputList.add(taskCreationInputs1);
        TaskInput taskSortingInputs = new TaskInput(false, null, false, 0, null, false, false, null);

        taskCreator.createTasks(tasklist, taskCreationInputList, taskSortingInputs);

        assertEquals("2 tasks should exist", 2, tasklist.size());
        assertEquals("task bee should exist", "bee", tasklist.get(0).getTitle());
        assertEquals("task apple should exist", "apple", tasklist.get(1).getTitle());
        assertEquals("task bee should have priority 3", 3, tasklist.get(0).getPriority());
        assertEquals("task apple should have priority 5", 5, tasklist.get(1).getPriority());
        assertEquals("task bee should have deadline 2019-08-15", LocalDate.of(2019, 8,15), tasklist.get(0).getDeadline());
        assertEquals("task apple should have deadline 2012-02-02", LocalDate.of(2012, 2,2), tasklist.get(1).getDeadline());
    }

    @Test
    public void testMultipleTaskCreationSorting(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInput> taskCreationInputList = new ArrayList<>();

        TaskInput taskCreationInputs = new TaskInput(true, "bee", false, 5, LocalDate.of(2019, 8, 15), false, false, null);
        TaskInput taskCreationInputs1 = new TaskInput(true, "apple", false, 5, LocalDate.of(2012, 2,2), false, false, null);
        taskCreationInputList.add(taskCreationInputs);
        taskCreationInputList.add(taskCreationInputs1);
        TaskInput taskSortingInputs = new TaskInput(false, null, false, 0, null, true, false, "title");

        taskCreator.createTasks(tasklist, taskCreationInputList, taskSortingInputs);

        assertEquals("2 tasks should exist", 2, tasklist.size());
        assertEquals("task apple should be first after sorting", "apple", tasklist.get(0).getTitle());
    }

    @Test
    public void testMultipleTaskCreationSortingDescSorting(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInput> taskCreationInputList = new ArrayList<>();

        TaskInput taskCreationInputs = new TaskInput(true, "bee", false, 5, LocalDate.of(2019, 8, 15), false, false, null);
        TaskInput taskCreationInputs1 = new TaskInput(true, "apple", false, 5, LocalDate.of(2012, 2,2), false, false, null);
        taskCreationInputList.add(taskCreationInputs);
        taskCreationInputList.add(taskCreationInputs1);
        TaskInput taskSortingInputs = new TaskInput(false, null, false, 0, null, true, true, "title");

        taskCreator.createTasks(tasklist, taskCreationInputList, taskSortingInputs);

        assertEquals("2 tasks should exist", 2, tasklist.size());
        assertEquals("task bee should be first after sorting by desc", "bee", tasklist.get(0).getTitle());
    }

    @Test
    public void testTaskCreationIllegalArgumentException(){

        TaskCreator taskCreator = new TaskCreator();
        List<Task> tasklist = new ArrayList<>();
        List<TaskInput> taskCreationInputList = new ArrayList<>();

        TaskInput taskCreationInputs = new TaskInput(true, "bee", false, 5, LocalDate.of(2019, 8, 15), false, false, null);
        taskCreationInputList.add(taskCreationInputs);
        TaskInput taskSortingInputs = new TaskInput(false, null, false, 0, null, true, false, "asdf");

        assertThrows("IllegalArgumentException should be thrown", IllegalArgumentException.class, () -> taskCreator.createTasks(tasklist, taskCreationInputList, taskSortingInputs));
    }
}
