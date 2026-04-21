package TaskManaging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskInputProcessor {

    TaskInputs taskInputs;

    public TaskInputs processTaskCreation(String userInput, String titleInput, String priorityInput, String deadlineInput) {
        if (userInput.equalsIgnoreCase(TaskInputEnums.YES.value)) {
            taskInputs.setAdding(true);
            taskInputs.setTitle(titleInput);
            taskInputs.setDone(false);

            try {
                taskInputs.setPriority(Integer.parseInt(priorityInput));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input for priority.");
            }

            try {
                taskInputs.setDeadline(scanToLocalDate(deadlineInput));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid input for deadline.");
            }
        } else {
            taskInputs.setAdding(false);
        }
        return taskInputs;
    }

    public TaskInputs processInputsForTaskFilteringAndSorting(String userInput, String filterInput, String sortingInput) {
        if (userInput.equalsIgnoreCase(TaskInputEnums.YES.value)) {
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
