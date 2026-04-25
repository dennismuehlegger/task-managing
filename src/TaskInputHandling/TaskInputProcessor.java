package TaskInputHandling;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskInputProcessor {

    public TaskInput processTaskCreation(TaskInput taskInputs, String titleInput, String priorityInput, String deadlineInput) {
        taskInputs.setAdding(true);
        taskInputs.setTitle(titleInput);
        taskInputs.setDone(false);
        taskInputs.setPriority(Integer.parseInt(priorityInput));
        taskInputs.setDeadline(scanToLocalDate(deadlineInput));
        return taskInputs;
    }

    public TaskInput processInputsForTaskSorting(TaskInput taskInputs, String sortingInput, String sortingOrder) {
        if (sortingInput != null) {
            taskInputs.setSorting(true);
            if (sortingInput.equalsIgnoreCase(TaskInputEnums.TITLE.value)
                    || sortingInput.equalsIgnoreCase(TaskInputEnums.PRIORITY.value)
                    || sortingInput.equalsIgnoreCase(TaskInputEnums.STATUS.value)
                    || sortingInput.equalsIgnoreCase(TaskInputEnums.DEADLINE.value)) {
                taskInputs.setSortingType(sortingInput);
            } else {
                throw new IllegalArgumentException("Invalid input for sorting type.");
            }
        }

        if (sortingOrder.equalsIgnoreCase(TaskInputEnums.DESC.value)) {
            taskInputs.setDescSorting(true);
        } else if (!sortingOrder.equalsIgnoreCase(TaskInputEnums.ASC.value)) {
            throw new IllegalArgumentException("Invalid input for sorting order.");
        }
        return taskInputs;
    }

    private LocalDate scanToLocalDate(String input) {
        Scanner scanner = new Scanner(input);
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}
