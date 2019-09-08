import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    protected ArrayList<Task> ListTasks;

    public TaskList(ArrayList<Task> list) {
        ListTasks = list;
    }

    // Add todos to list.
    public void addToDo(String input) throws ToDoEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore todo_word
        if (sc.hasNext()) {
            ToDo newToDo = new ToDo(sc.nextLine());
            this.ListTasks.add(newToDo);
            int pos = this.ListTasks.size();
            Ui.printAddTask(pos, newToDo);
        } else {
            throw new ToDoEmptyException();
        }
    }

    // Add deadlines to the list.
    public void addDeadline(String input) throws DeadlineEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore deadline word
        if (sc.hasNext()) {
            String restOfInput = sc.nextLine();
            String[] parts = restOfInput.split("/by");
            String description = parts[0].trim();
            String byString = parts[1].trim();
            Deadline newDeadline = new Deadline(description, byString);
            this.ListTasks.add(newDeadline);
            int pos = this.ListTasks.size();
            Ui.printAddTask(pos, newDeadline);
        } else {
            throw new DeadlineEmptyException();
        }
    }

    // Add tasks to list.
    public void addEvent(String input) throws EventEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore event word
        if (sc.hasNext()) {
            String restOfInput = sc.nextLine();
            String[] parts = restOfInput.split("/at");
            String description = parts[0].trim();
            String[] dateAndTime = parts[1].trim().split(" ");
            String date = dateAndTime[0].trim();
            String time = dateAndTime[1].trim();
            Event newEvent = new Event(description, date, time);
            this.ListTasks.add(newEvent);
            int pos = this.ListTasks.size();
            Ui.printAddTask(pos, newEvent);
        } else {
            throw new EventEmptyException();
        }
    }

    // Delete tasks from list.
    public void deleteTask(String input) throws DeleteInvalidException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore delete word
        if (sc.hasNextInt()) {
            int taskIdx = sc.nextInt() - 1;
            Task delTask = this.ListTasks.get(taskIdx);
            this.ListTasks.remove(taskIdx);
            int num = this.ListTasks.size();
            Ui.printDeleteTask(num, delTask);
        } else {
            throw new DeleteInvalidException();
        }
    }

    public void findTask(String input) throws FindEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore find word
        if (sc.hasNext()) {
            String searchWord = sc.nextLine();
            Ui.printHoriLine();
            Ui.printLine(Ui.FIND_STRING);
            int countFound = 0;
            for (Task eachTask : this.ListTasks) {
                if (eachTask.toString().contains(searchWord)) {
                    countFound++;
                    Ui.printLine(countFound + "." + eachTask);
                }
            }
            if (countFound == 0) {
                Ui.printLine(Ui.NONE_FOUND);
            }
            Ui.printHoriLine();
        } else {
            throw new FindEmptyException();
        }
    }

    // List out all the tasks.
    public void list() {
        Ui.printHoriLine();
        for (int a = 0; a < this.ListTasks.size(); a++) {
            int displayNum = a + 1;
            Ui.printLine(displayNum + ". " + this.ListTasks.get(a) + "\n");
        }
        Ui.printHoriLine();
    }

    // Mark task as done.
    public void doneTask(String inputString) {
        String[] tokens = inputString.split(" ");
        int taskNum = Integer.parseInt(tokens[1]);
        int index = taskNum - 1; // list is zero-indexed while user sees a one-indexed list
        this.ListTasks.get(index).markAsDone();
        Ui.printHoriLine();
        Ui.printLine(Ui.DONE_STRING);
        Ui.printLine(this.ListTasks.get(index) + "\n");
        Ui.printHoriLine();
    }
}

class ToDoEmptyException extends Exception {}
class EventEmptyException extends Exception {}
class DeadlineEmptyException extends Exception {}
class DeleteInvalidException extends Exception {}
class FindEmptyException extends Exception {}