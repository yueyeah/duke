import java.util.Scanner;

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

    // main function
    public static void main(String[] args) {
        GreetDuke();
        Task[] listTasks = new Task[100];
        int counter = 0; // counter will count the number of items added to listTasks
        Scanner sc = new Scanner(System.in);
        while (true) {
            String inputString = sc.nextLine();
            inputString = inputString.trim(); // trim any possible trailing whitespace
            inputString = inputString.toLowerCase(); // convert everything to lower case
            if (inputString.equals(EXIT_CMD)) {
                ExitDuke();
                break;
            } else if (inputString.equals(LIST_CMD)){
                ListDuke(listTasks, counter);
            } else if (CheckDone(inputString)) {
                DoneDuke(inputString, listTasks);
            } else {
                AddDuke(listTasks, counter, inputString);
                counter++;
            }
        }
    }

    // Print a line.
    static void PrintLine(String str) {
        System.out.println(str);
    }

    // Actions to be taken upon initialising Duke
    static void GreetDuke() {
        PrintLine(HORIZONTAL_LINE);
        PrintLine(LOGO);
        PrintLine(GREETING);
        PrintLine(HORIZONTAL_LINE);
    }

    // Actions to be taken before exiting Duke
    static void ExitDuke() {
        PrintLine(HORIZONTAL_LINE);
        PrintLine(BYE_STRING + "\n");
        PrintLine(HORIZONTAL_LINE);
    }

    // Add tasks to list.
    static void AddDuke(Task[] arr, int pos, String input) {
        Task newTask = new Task(input);
        arr[pos] = newTask;
        PrintLine(HORIZONTAL_LINE);
        PrintLine("added: " + input + "\n");
        PrintLine(HORIZONTAL_LINE);
    }

    // List out all the tasks.
    static void ListDuke(Task[] listTasks, int pos) {
        PrintLine(HORIZONTAL_LINE);
        for (int a = 0; a < pos; a++) {
            int displayNum = a + 1;
            String taskStatus;
            if (listTasks[a].isDone()) {
                taskStatus = "\u2713";
            } else {
                taskStatus = "\u2718";
            }
            PrintLine(displayNum + ". [" + taskStatus + "] "+ listTasks[a] + "\n");
        }
        PrintLine(HORIZONTAL_LINE);
    }

    // Handle checking whether the inputSting contains the done keyword.
    static boolean CheckDone(String inputString) {
        return (inputString.length() >= 4) && (inputString.substring(0,4).equals(DONE));
    }

    static void DoneDuke(String inputString, Task[] listTasks) {
        String[] tokens = inputString.split(" ");
        int taskNum = Integer.parseInt(tokens[1]);
        int index = taskNum - 1; // list is zero-indexed while user sees a one-indexed list
        listTasks[index].doTask();
        PrintLine(HORIZONTAL_LINE);
        PrintLine(DONE_STRING);
        PrintLine("[\u2713] " + listTasks[index] + "\n");
        PrintLine(HORIZONTAL_LINE);
    }
}

class Task {
    protected String description;
    protected boolean isCompleted;
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
    public boolean isDone() {
        return this.isCompleted;
    }
    public String toString() {
        return this.description;
    }
    public boolean doTask() {
        this.isCompleted = true;
        return this.isCompleted;
    }
}