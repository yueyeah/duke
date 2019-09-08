public class Parser {
    // Constants
    static final String EXIT_CMD = "bye";
    static final String LIST_CMD = "list";
    static final String DONE_CMD = "done";
    static final String TODO_CMD = "todo";
    static final String DEADLINE_CMD = "deadline";
    static final String EVENT_CMD = "event";
    static final String DELETE_CMD = "delete";
    static final String FIND_CMD = "find";

    public static cmd decideCmd(String inputString) throws InvalidDukeInputException {
        if (inputString.equals(EXIT_CMD)) {
            return cmd.EXIT;
        } else if (inputString.equals(LIST_CMD)) {
            return cmd.LIST;
        } else {
            String[] inputParts = inputString.split(" ");
            if (inputParts[0].equals(DONE_CMD)) {
                return cmd.DONE;
            } else if (inputParts[0].equals(TODO_CMD)) {
                return cmd.TODO;
            } else if (inputParts[0].equals(DEADLINE_CMD)) {
                return cmd.DEADLINE;
            } else if (inputParts[0].equals(EVENT_CMD)) {
                return cmd.EVENT;
            } else if (inputParts[0].equals(DELETE_CMD)) {
                return cmd.DELETE;
            } else if (inputParts[0].equals(FIND_CMD)) {
                return cmd.FIND;
            } else {
                throw new InvalidDukeInputException(); // define what to do for DukeException
            }
        }
    }
}

enum cmd {
    EXIT, LIST, DONE, TODO, DEADLINE, EVENT, DELETE, FIND
}