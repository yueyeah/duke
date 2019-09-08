import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Event class is a subclass of Task, as specified in the Duke requirements.
 */
public class Event extends Task {
    /**
     * Event contains a date and time in addition to the basic description.
     * date_string and time_string will be concatenated into date for easy
     * output.
     */
    protected String date_string;
    protected String time_string;
    protected Date date;

    /**
     * Constructor method.
     *
     * @param description User-defined description of the Event.
     * @param date User-defined date of the Event.
     * @param time User-defined time of the Event.
     */
    public Event(String description, String date, String time) {
        super(description);
        this.date_string = date;
        this.time_string = time;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
            this.date = formatter.parse(date_string + " " + time_string);
        } catch (ParseException e) {
            System.out.println("☹ OOPS!!! Please enter your date and time for your event in the following format: dd/MM/yyyy HHmm");
        }
    }

    /**
     * Facilitating the storing of Events in disk as correct format, for
     * easy reinitialisation into task list.
     *
     * @return Correct format for storage of Event.
     */
    @Override
    public String getTaskType() {
        return "event " + this.description + " /at " + this.date_string + " " + this.time_string;
    }

    /**
     * Organise description, date (comprising both the date and time of Event)
     * for output.
     *
     * @return Correct format for output of Event.
     */
    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + super.toString() + " (at: " + date + ")";
    }
}
