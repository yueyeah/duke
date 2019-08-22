import java.util.Scanner;

public class Duke {
    static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    static final String GREETING = "Hello! I'm Duke \n"
            + "What can I do for you? \n";
    static final String HORIZONTAL_LINE = new String(new char[42]).replace("\0", "\u23E4");
    static final String EXIT_STRING = "bye";
    static final String BYE_STRING = "Bye. Hope to see you again soon!";
    public static void main(String[] args) {
        printLine(LOGO);
        printLine(GREETING);
        printLine(HORIZONTAL_LINE);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String inputString = sc.next();
            if (inputString.equals(EXIT_STRING)) {
                printLine(BYE_STRING);
                break;
            } else {
                printLine(inputString);
            }
            printLine(HORIZONTAL_LINE);
        }
    }
    public static void printLine(String str) {
        System.out.println(str);
    }
}
