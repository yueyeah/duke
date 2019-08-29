import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.io.PrintWriter;

public class Duke {
    // Constants
    static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    static final String GREETING = "Hello! I'm Duke \n"
            + "What can I do for you? \n";
    static final String HORIZONTAL_LINE = new String(new char[42]).replace("\0", "\u23E4");
    static final String EXIT_CMD = "bye";
    static final String BYE_STRING = "Bye. Hope to see you again soon!";
    static final String LIST_CMD = "list";
    static final String DONE = "done";
    static final String DONE_STRING = "Nice! I've marked this task as done:";
    static final String ADD_STRING = "Got it. I've added this task: ";
    static final String TODO = "todo";
    static final String DEADLINE = "deadline";
    static final String EVENT = "event";
    static final String DELETE = "delete";
    static final String FILEPATH = "D:\\duke\\src\\main\\java\\duke.txt";
    // main function
    public static void main(String[] args) {
        greetDuke();
        ArrayList<Task> listTasks = readFileDuke();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String inputString = sc.nextLine();
            inputString = inputString.trim(); // trim any possible trailing whitespace
            if (inputString.equals(EXIT_CMD)) {
                exitDuke(listTasks);
                break;
            } else if (inputString.equals(LIST_CMD)){
                listDuke(listTasks);
            } else {
                try {
                    String[] inputParts = inputString.split(" ");
                    if (inputParts[0].equals(DONE)) {
                        doneDuke(inputString, listTasks);
                    } else if (inputParts[0].equals(TODO)) {
                        addToDoDuke(listTasks, inputString);
                    } else if (inputParts[0].equals(DEADLINE)) {
                        addDeadlineDuke(listTasks, inputString);
                    } else if (inputParts[0].equals(EVENT)) {
                        addEventDuke(listTasks, inputString);
                    } else {
                        throw new InvalidDukeInputException(); // define what to do for DukeException
                    }
                } catch (InvalidDukeInputException e) {
                    printLine(HORIZONTAL_LINE);
                    printLine("☹ OOPS!!! I'm sorry, but I don't know what that means :-(" + "\n");
                    printLine(HORIZONTAL_LINE);
                } catch (ToDoEmptyException e) {
                    printLine(HORIZONTAL_LINE);
                    printLine("☹ OOPS!!! The description of a todo cannot be empty." + "\n");
                    printLine(HORIZONTAL_LINE);
                } catch (DeadlineEmptyException e) {
                    printLine(HORIZONTAL_LINE);
                    printLine("☹ OOPS!!! The description of a deadline cannot be empty." + "\n");
                    printLine(HORIZONTAL_LINE);
                } catch (EventEmptyException e) {
                    printLine(HORIZONTAL_LINE);
                    printLine("☹ OOPS!!! The description of a event cannot be empty." + "\n");
                    printLine(HORIZONTAL_LINE);
                }
            }
        }
    }

    // Print a line.
    static void printLine(String str) {
        System.out.println(str);
    }

    // Actions to be taken upon initialising Duke
    static void greetDuke() {
        printLine(HORIZONTAL_LINE);
        printLine(LOGO);
        printLine(GREETING);
        printLine(HORIZONTAL_LINE);
    }

    static ArrayList<Task> readFileDuke() {
        ArrayList<Task> listTasks = new ArrayList<Task>();
        File file = new File(FILEPATH);
        try {
            Scanner sc1 = new Scanner(file);
            while (sc1.hasNextLine()) {
                String fileString = sc1.nextLine();
                String[] fileParts = fileString.split(" ");
                Scanner sc2 = new Scanner(fileString);
                sc2.next();
                if (fileParts[0].equals(TODO)) {
                    ToDo newToDo = new ToDo(sc2.nextLine());
                    listTasks.add(newToDo);
                } else if (fileParts[0].equals(DEADLINE)) {
                    String restOfString = sc2.nextLine();
                    String[] parts = restOfString.split("/by");
                    String description = parts[0].trim();
                    String byString = parts[1].trim();
                    Deadline newDeadline = new Deadline(description, byString);
                    listTasks.add(newDeadline);
                } else if (fileParts[0].equals(EVENT)) {
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

    // Actions to be taken before exiting Duke
    static void exitDuke(ArrayList<Task> listTasks) {
        try {
            PrintWriter writer = new PrintWriter(FILEPATH);
            for (Task eachTask: listTasks) {
                writer.println(eachTask.getTaskType());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printLine(HORIZONTAL_LINE);
        printLine(BYE_STRING + "\n");
        printLine(HORIZONTAL_LINE);
    }

    // Add todos to list.
    static void addToDoDuke(ArrayList<Task> arr, String input) throws ToDoEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore todo_word
        if (sc.hasNext()) {
            ToDo newToDo = new ToDo(sc.nextLine());
            arr.add(newToDo);
            printLine(HORIZONTAL_LINE);
            printLine(ADD_STRING);
            int pos = arr.size();
            printLine(arr.get(pos - 1).toString());
            printLine("Now you have " + pos + " tasks in the list.\n");
            printLine(HORIZONTAL_LINE);
        } else {
            throw new ToDoEmptyException();
        }
    }

    // Add deadlines to list.
    static void addDeadlineDuke(ArrayList<Task> arr, String input) throws DeadlineEmptyException {
        Scanner sc = new Scanner(input);
        sc.next(); // ignore deadline word
        if (sc.hasNext()) {
            String restOfInput = sc.nextLine();
            String[] parts = restOfInput.split("/by");
            String description = parts[0].trim();
            String byString = parts[1].trim();
            Deadline newDeadline = new Deadline(description, byString);
            arr.add(newDeadline);
            int pos = arr.size();
            printLine(HORIZONTAL_LINE);
            printLine(ADD_STRING);
            printLine(arr.get(pos - 1).toString());
            printLine("Now you have " + pos + " tasks in the list.\n");
            printLine(HORIZONTAL_LINE);
        } else {
            throw new DeadlineEmptyException();
        }
    }

    // Add tasks to list.
    static void addEventDuke(ArrayList<Task> arr, String input) throws EventEmptyException {
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
            arr.add(newEvent);
            int pos = arr.size();
            printLine(HORIZONTAL_LINE);
            printLine(ADD_STRING);
            printLine(arr.get(pos - 1).toString());
            printLine("Now you have " + pos + " tasks in the list.\n");
            printLine(HORIZONTAL_LINE);
        } else {
            throw new EventEmptyException();
        }
    }

    // List out all the tasks.
    static void listDuke(ArrayList<Task> listTasks) {
        printLine(HORIZONTAL_LINE);
        for (int a = 0; a < listTasks.size(); a++) {
            int displayNum = a + 1;
            printLine(displayNum + ". " + listTasks.get(a) + "\n");
        }
        printLine(HORIZONTAL_LINE);
    }

    static void doneDuke(String inputString, ArrayList<Task> listTasks) {
        String[] tokens = inputString.split(" ");
        int taskNum = Integer.parseInt(tokens[1]);
        int index = taskNum - 1; // list is zero-indexed while user sees a one-indexed list
        listTasks.get(index).markAsDone();
        printLine(HORIZONTAL_LINE);
        printLine(DONE_STRING);
        printLine(listTasks.get(index) + "\n");
        printLine(HORIZONTAL_LINE);
    }
}

class InvalidDukeInputException extends Exception {}
class ToDoEmptyException extends Exception {}
class EventEmptyException extends Exception {}
class DeadlineEmptyException extends Exception {}