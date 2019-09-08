/**
 * Basic Task class. Forms a base for ToDo, Deadline, and Event.
 */
public class Task {
    /**
     * Description of task and whether the task is marked as done.
     */
    protected String description;
    protected boolean isDone;

    /**
     * Constructor method.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Decides the status icon of the task, whether it is a tick
     * or cross.
     *
     * @return Tick if the task is marked as done, cross if not.
     */
    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    /**
     * Returns the type of task. General case will return task.
     *
     * @return A "task" string.
     */
    public String getTaskType() {
        return "task";
    }

    /**
     * General case, return the description of the task.
     *
     * @return The description of the task as a string.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Changes the isDone boolean to mark the task as done.
     *
     * @return The isDone boolean, which will be true.
     */
    public boolean markAsDone() {
        this.isDone = true;
        return this.isDone;
    }
}

