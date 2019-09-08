import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * Deadline class is a subclass of Task, as specified in the Duke requirements.
 */
public class Deadline extends Task {
    /**
     * Deadline contains a date in addition to the basic description.
     */
    protected String by;
    protected Date date;

    /**
     * Constructor method.
     *
     * @param description User-defined description of the Deadline.
     * @param by User-defined date of the Deadline.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(this.by);
        } catch (ParseException e) {
            System.out.println("☹ OOPS!!! Please enter your date for deadline in the following format: dd/MM/yyyy");
        }
    }

    /**
     * Facilitating the storing of Deadline in disk as correct format, for
     * easy reinitialisation into task list.
     *
     * @return Correct format for storage of Deadline.
     */
    @Override
    public String getTaskType() {
        return "deadline " + this.description + " /by " + this.by;
    }

    /**
     * Organise description, date for output.
     *
     * @return Correct format for output of Deadline.
     */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + super.toString() + " (by: " + date + ")";
    }
}