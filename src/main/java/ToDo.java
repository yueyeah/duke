public class ToDo extends Task {
    public ToDo(String description){
        super(description);
    }

    @Override
    public String getTaskType() {
        return "todo " + this.description;
    }

    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + super.toString();
    }
}
