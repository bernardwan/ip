package duke;

import duke.Command.AddCommand;
import duke.Command.Command;
import duke.Command.DeleteCommand;
import duke.Command.DoneCommand;
import duke.Command.ExitCommand;
import duke.Command.FindCommand;
import duke.Command.ListCommand;


public class Parser {

    /**
     * Parses the input provided into relevant Commands
     *
     * @param input String of next line of user input
     * @return Relevant Command corresponding to input
     * @throws DukeException
     */
    public static Command parse(String input) throws DukeException {
        String firstWord = input.split(" ")[0];
        assert firstWord != null;


        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (firstWord.equals("done")) {
            int index;
            try {
                index = Integer.parseInt(input.split(" ")[1]) - 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("Sorry, please enter an integer after 'done'. (e.g. done 2)");
            }
            return new DoneCommand(index);
        } else if (firstWord.equals("delete")) {
            int index;
            try {
                index = Integer.parseInt(input.split(" ")[1]) - 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("Sorry, please enter an integer after 'delete'. (e.g. delete 2)");
            }
            return new DeleteCommand(index);
        } else if (firstWord.equals("find")) {
            String remaining;
            try {
                remaining = input.split(" ", 2)[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("Sorry, please enter a keyword after 'find'.");
            }
            return new FindCommand(remaining);
        } else {
            String remaining;
            try {
                remaining = input.split(" ", 2)[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("Sorry, tasks must include descriptions.");
            }
            return new AddCommand(firstWord, remaining);
        }


    }
}
