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

    // main function
    public static void main(String[] args) {
        GreetDuke();
        String[] listTasks = new String[100];
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
            } else {
                AddDuke(listTasks, counter, inputString);
                counter++;
            }
        }
    }

    // Print a line.
    public static void PrintLine(String str) {
        System.out.println(str);
    }

    // Actions to be taken upon initialising Duke
    public static void GreetDuke() {
        PrintLine(HORIZONTAL_LINE);
        PrintLine(LOGO);
        PrintLine(GREETING);
        PrintLine(HORIZONTAL_LINE);
    }

    // Actions to be taken before exiting Duke
    public static void ExitDuke() {
        PrintLine(HORIZONTAL_LINE);
        PrintLine(BYE_STRING);
        PrintLine(" ");
        PrintLine(HORIZONTAL_LINE);
    }

    // Add tasks to list.
    public static void AddDuke(String[] arr, int pos, String input) {
        arr[pos] = input;
        PrintLine(HORIZONTAL_LINE);
        PrintLine("added: " + input);
        PrintLine(" ");
        PrintLine(HORIZONTAL_LINE);
    }

    // List out all the tasks.
    public static void ListDuke(String[] listTasks, int pos) {
        PrintLine(HORIZONTAL_LINE);
        for (int a = 0; a < pos; a++) {
            int displayNum = a + 1;
            PrintLine(displayNum + ". " + listTasks[a]);
        }
        PrintLine(" ");
        PrintLine(HORIZONTAL_LINE);
    }
}
