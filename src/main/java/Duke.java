import java.util.ArrayList;
import java.lang.String;

public class Duke {
    // main function
    public static void main(String[] args) {
        Ui.printGreet();
        ArrayList<Task> listTasks = Storage.readFile();
        TaskList dukeList = new TaskList(listTasks);
        boolean exit = false;
        while (!exit) {
            String inputString = Ui.takeInput();
            try {
                switch (Parser.decideCmd(inputString)) {
                    case EXIT:
                        Storage.exit(dukeList.ListTasks);
                        exit = true;
                        break;
                    case LIST:
                        dukeList.list();
                        break;
                    case DONE:
                        dukeList.doneTask(inputString);
                        break;
                    case TODO:
                        dukeList.addToDo(inputString);
                        break;
                    case DEADLINE:
                        dukeList.addDeadline(inputString);
                        break;
                    case EVENT:
                        dukeList.addEvent(inputString);
                        break;
                    case DELETE:
                        dukeList.deleteTask(inputString);
                        break;
                    case FIND:
                        dukeList.findTask(inputString);
                        break;
                }
            } catch (InvalidDukeInputException e) {
                Ui.printInvalidDuke();
            } catch (ToDoEmptyException e) {
                Ui.printToDoEmpty();
            } catch (DeadlineEmptyException e) {
                Ui.printDeadlineEmpty();
            } catch (EventEmptyException e) {
                Ui.printEventEmpty();
            } catch (DeleteInvalidException e) {
                Ui.printDeleteInvalid();
            } catch (FindEmptyException e) {
                Ui.printFindEmpty();
            }
        }
    }
}

class InvalidDukeInputException extends Exception {}