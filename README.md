# Task Managing

## Overview

This project is a **console-based task management application** focused on backend design, clean structure, and testability.

It allows users to:

* Create tasks with a title, priority, and deadline
* Apply sorting (title, priority, status, deadline)
* Reverse sorting order (ascending / descending)
* Validate user input to prevent invalid data

---

## Key Features

### Task Creation

* Create multiple tasks in a single run
* Each task contains:

  * Title
  * Priority (1–5)
  * Deadline (YYYY-MM-DD)
  * Status (default: not done)

### Sorting

* Sort tasks by:

  * Title (alphabetical)
  * Priority
  * Deadline
  * Status
* Optional descending order

### Input Validation

* Handles:

  * Invalid numbers (priority)
  * Invalid date formats
  * Invalid filter types
* Uses exceptions to enforce correctness

### Testing

* Unit tests for:

  * Task creation
  * Multiple task handling
  * Sorting behavior

---

## Design Decisions

### Separation of Concerns

The project separates:

* Input handling
* Business logic
* Data representation
* Sorting logic

Improving:

* readability
* maintainability
* testability

---

### No Persistence (by design)

Tasks exist **only during runtime** and are not saved.


Future extensions may include database integration

---

### No UI Focus

The application uses console input/output.

Future extensions may include simple UI

---

## How to Run

1. Clone the repository
2. Compile the project
3. Run:

```
TaskCreator.main()
```

4. Follow console prompts to:

   * create tasks
   * apply sorting

---

## Running Tests

Run:

```
TaskTests
```

Requires **JUnit 4**.

---

## Future Improvements

* Support multiple filters simultaneously
* Add persistence (database)
* Simple visualization layer

---
## Purpose of This Project 

This project was primarily built to get back into coding specifically: 
* relearn backend design principles
* improve code structure and modularity
* planning and executing design decisions
* setting goals and deadlines for myself
