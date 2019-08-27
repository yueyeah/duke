import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Deadline extends Task {
    protected String by;
    protected Date date;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(this.by);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTaskType() {
        return "deadline " + this.description + " /by " + this.by;
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + super.toString() + " (by: " + date + ")";
    }
}