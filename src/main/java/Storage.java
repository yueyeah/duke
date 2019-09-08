import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage class handles the writing and reading of task
 * list from disk.
 */
public class Storage {
    /**
     * Hardcoded file path constant.
     */
    static final String FILEPATH = "D:\\duke\\src\\main\\java\\duke.txt";

    /**
     * Reads the file, initialises each task correctly as a ToDo,
     * Event or Deadline, then enters them into the list.
     *
     * @return The list of tasks.
     */
    public static ArrayList<Task> readFile() {
        ArrayList<Task> listTasks = new ArrayList<Task>();
        File file = new File(FILEPATH);
        try {
            Scanner sc1 = new Scanner(file);
            while (sc1.hasNextLine()) {
                String fileString = sc1.nextLine();
                String[] fileParts = fileString.split(" ");
                Scanner sc2 = new Scanner(fileString);
                sc2.next();
                if (fileParts[0].equals(Parser.TODO_CMD)) {
                    ToDo newToDo = new ToDo(sc2.nextLine());
                    listTasks.add(newToDo);
                } else if (fileParts[0].equals(Parser.DEADLINE_CMD)) {
                    String restOfString = sc2.nextLine();
                    String[] parts = restOfString.split("/by");
                    String description = parts[0].trim();
                    String byString = parts[1].trim();
                    Deadline newDeadline = new Deadline(description, byString);
                    listTasks.add(newDeadline);
                } else if (fileParts[0].equals(Parser.EVENT_CMD)) {
                    String restOfInput = sc2.nextLine();
                    String[] parts = restOfInput.split("/at");
                    String description = parts[0].trim();
                    String[] dateAndTime = parts[1].trim().split(" ");
                    String date = dateAndTime[0].trim();
                    String time = dateAndTime[1].trim();
                    Event newEvent = new Event(description, date, time);
                    listTasks.add(newEvent);
                }
            }
            sc1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listTasks;
    }

    /**
     * When the user has ended usage, write all the tasks in the list
     * to the file path and say goodbye to the user.
     *
     * @param listTasks The list of tasks.
     */
    public static void exit(ArrayList<Task> listTasks) {
        try {
            PrintWriter writer = new PrintWriter(FILEPATH);
            for (Task eachTask: listTasks) {
                writer.println(eachTask.getTaskType());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Ui.printBye();
    }
}
