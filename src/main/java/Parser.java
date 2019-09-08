/**
 * Parser class handles the parsing of the input from user.
 */
public class Parser {
    /**
     * These are the constants that are used in the decideCmd method.
     */
    static final String EXIT_CMD = "bye";
    static final String LIST_CMD = "list";
    static final String DONE_CMD = "done";
    static final String TODO_CMD = "todo";
    static final String DEADLINE_CMD = "deadline";
    static final String EVENT_CMD = "event";
    static final String DELETE_CMD = "delete";
    static final String FIND_CMD = "find";

    /**
     * Takes in the user input and interprets the command that the user
     * intended. Returns an enum called cmd that specifies the type of
     * command, which is used to decide the next course of action for
     * the list of tasks. If the user has not keyed in a valid command,
     * throws InvalidDukeInputException.
     *
     * @param inputString User input
     * @return The type of command that the user has input.
     * @throws InvalidDukeInputException If user has keyed in a generic incorrect input.
     */
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

/**
 * enum class that specifies the type of command based on the user input.
 */
enum cmd {
    EXIT, LIST, DONE, TODO, DEADLINE, EVENT, DELETE, FIND
}