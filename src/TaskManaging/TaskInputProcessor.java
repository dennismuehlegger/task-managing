package TaskManaging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskInputProcessor {

    public TaskInputs processTaskCreation(TaskInputs taskInputs, String titleInput, String priorityInput, String deadlineInput) {
        taskInputs.setAdding(true);
        taskInputs.setTitle(titleInput);
        taskInputs.setDone(false);

        try {
            taskInputs.setPriority(Integer.parseInt(priorityInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input for priority. Must be an integer.");
        }
        taskInputs.setDeadline(scanToLocalDate(deadlineInput));
        return taskInputs;
    }

    public TaskInputs processInputsForTaskFilteringAndSorting(TaskInputs taskInputs, String filterInput, String sortingInput) {
        if (filterInput != null){
            taskInputs.setFiltering(true);
            if (filterInput.equalsIgnoreCase(TaskInputEnums.TITLE.value)
                    || filterInput.equalsIgnoreCase(TaskInputEnums.PRIORITY.value)
                    || filterInput.equalsIgnoreCase(TaskInputEnums.STATUS.value)
                    || filterInput.equalsIgnoreCase(TaskInputEnums.DEADLINE.value)) {
                taskInputs.setFilterType(filterInput);
            } else {
                throw new IllegalArgumentException("Invalid input for filter type.");
            }
        }

        if (sortingInput.equalsIgnoreCase(TaskInputEnums.DESC.value)) {
            taskInputs.setSorting(true);
        } else if (!sortingInput.equalsIgnoreCase(TaskInputEnums.ASC.value)) {
            throw new IllegalArgumentException("Invalid input for sorting type.");
        }
        return taskInputs;
    }

    private LocalDate scanToLocalDate(String input) {
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        }
    }
}
