/**
 * ToDo class is a subclass of Task. It is mostly the same
 * except that Task methods are overriden with more extensive versions.
 */
public class ToDo extends Task {
    /**
     * Constructor method.
     *
     * @param description User-defined description of the ToDo.
     */
    public ToDo(String description){
        super(description);
    }

    /**
     * Facilitating the storing of ToDo in disk as correct format, for
     * easy reinitialisation into task list.
     *
     * @return Correct format for storage of ToDo.
     */
    @Override
    public String getTaskType() {
        return "todo " + this.description;
    }

    /**
     * Organise description of ToDo for output.
     *
     * @return Correct format for output of ToDo.
     */
    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + super.toString();
    }
}
