import java.util.Scanner;

/**
 * Ui class deals with interaction with the user, asking for
 * input and dealing with output.
 */
public class Ui {
    /**
     * The constants that will be printed out by the methods in Ui class.
     */
    static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    static final String GREETING = "Hello! I'm Duke \n"
            + "What can I do for you? \n";
    static final String HORIZONTAL_LINE = new String(new char[42]).replace("\0", "\u23E4");
    static final String BYE_STRING = "Bye. Hope to see you again soon!";
    static final String DONE_STRING = "Nice! I've marked this task as done:";
    static final String ADD_STRING = "Got it. I've added this task: ";
    static final String DELETE_STRING = "Noted. I've removed this task: ";
    static final String TASK_NUM_STRING_1  ="Now you have ";
    static final String TASK_NUM_STRING_2 = " tasks in the list.";
    static final String FIND_STRING = "Here are the matching tasks in your list: ";
    static final String NONE_FOUND = "Sorry, could not find any tasks containing your search words. ";

    /**
     * Prints a line.
     *
     * @param str The string of words to be printed.
     */
    static public void printLine(String str) {
        System.out.println(str);
    }

    /**
     * Prints a horizontal line.
     */
    static public void printHoriLine() {
        printLine(HORIZONTAL_LINE);
    }

    /**
     * Prints the greeting for Duke, when Duke is first brought up.
     */
    static public void printGreet() {
        printHoriLine();
        printLine(LOGO);
        printLine(GREETING);
        printHoriLine();
    }

    /**
     * Prints the exit message for Duke, when user has ended usage.
     */
    static public void printBye() {
        printHoriLine();
        printLine(BYE_STRING + "\n");
        printHoriLine();
    }

    /**
     * Takes in the user input.
     *
     * @return User input as a string of words.
     */
    static public String takeInput() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        inputString.trim(); // trim any trailing whitespace
        return inputString;
    }

    /**
     * Prints confirmation of task addition and number of tasks in the list.
     *
     * @param pos The number of tasks in the list
     * @param newTask The task that was added. Can be ToDo, Deadline or Event.
     */
    static public void printAddTask(int pos, Task newTask) {
        printHoriLine();
        printLine(ADD_STRING);
        printLine(newTask.toString());
        printLine("Now you have " + pos + " tasks in the list.\n");
        printHoriLine();
    }

    /**
     * Prints confirmation of task deletion and number of tasks in the list.
     *
     * @param pos The number of tasks in the list.
     * @param delTask The task that was deleted. Can be ToDo, Deadline or Event.
     */
    static public void printDeleteTask(int pos, Task delTask) {
        printHoriLine();
        printLine(DELETE_STRING);
        printLine(delTask.toString());
        printLine(TASK_NUM_STRING_1 + pos + TASK_NUM_STRING_2);
    }

    /**
     * Prints error message for invalidDukeInputException.
     */
    static public void printInvalidDuke() {
        printHoriLine();
        printLine("☹ OOPS!!! I'm sorry, but I don't know what that means :-(" + "\n");
        printHoriLine();
    }

    /**
     * Prints error message for an Empty Todo Command.
     */
    static public void printToDoEmpty() {
        printHoriLine();
        printLine("☹ OOPS!!! The description of a todo cannot be empty." + "\n");
        printHoriLine();
    }

    /**
     * Prints error message for Empty Deadline Command.
     */
    static public void printDeadlineEmpty() {
        printHoriLine();
        printLine("☹ OOPS!!! The description of a deadline cannot be empty." + "\n");
        printHoriLine();
    }

    /**
     * Prints error message for Empty Event Command.
     */
    static public void printEventEmpty() {
        printHoriLine();
        printLine("☹ OOPS!!! The description of a event cannot be empty." + "\n");
        printHoriLine();
    }

    /**
     * Prints error message for Invalid Delete Command.
     */
    static public void printDeleteInvalid() {
        printHoriLine();
        printLine("☹ OOPS!!! Please enter the valid number of a Task." + "\n");
    }

    /**
     * Prints error message for Empty Find Command.
     */
    static public void printFindEmpty() {
        printHoriLine();
        printLine("☹ OOPS!!! Please enter a valid search word." + "\n");
        printHoriLine();
    }
}
