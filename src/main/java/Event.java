import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String date_string;
    protected String time_string;
    protected Date date;

    public Event(String description, String date, String time) {
        super(description);
        this.date_string = date;
        this.time_string = time;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
            this.date = formatter.parse(date_string + " " + time_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTaskType() {
        return "event " + this.description + " /at " + this.date_string + " " + this.time_string;
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + super.toString() + " (at: " + date + ")";
    }
}
