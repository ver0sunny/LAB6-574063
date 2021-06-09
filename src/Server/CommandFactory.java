package Server;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.InputAndVerifier;
import Common.serverCommands.AddCommand;
import Common.serverCommands.HelpCommand;
import Common.exceptions.NoSuchCommandException;
import Common.managers.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public final static Map<String, AbstractCommand> map = new HashMap<>();

    private CollectionManager collectionManager;
    private InputAndVerifier inputAndVerifier;

    public CommandFactory(CollectionManager collectionManager, InputAndVerifier inputAndVerifier, AddCommand addCommand,
                          //AddIfMinCommand addIfMinCommand, ClearCommand clearCommand, ExecuteScript executeScript,
                          // ExitCommand exitCommand, FilterByFormOfEducationCommand filterByFormOfEducationCommand,
                          HelpCommand helpCommand) //History history, InfoCommand infoCommand, InsertAtCommand insertAtCommand,
                          //  PrintDecendingBySemester printDecendingBySemester, RemoveByIdCommand removeByIdCommand,
                          //  RemoveByStudentCount removeByStudentCount, ShowCommand showCommand,
                          // UpdateCommand updateCommand)
                          {
        this.inputAndVerifier = inputAndVerifier;
        this.collectionManager = collectionManager;
        {
            map.put("ADD", addCommand);
//            map.put("ADD_IF_MIN", addIfMinCommand);
//            map.put("CLEAR", clearCommand);
//            map.put("EXECUTE_SCRIPT", executeScript);
//            map.put("EXIT", exitCommand);
//            map.put("FILTER_GREATER_THAN_FORM_OF_EDUCATION", filterByFormOfEducationCommand);
            map.put("HELP", helpCommand);
//            map.put("HISTORY", history);
//            map.put("INFO", infoCommand);
//            map.put("INSERT_AT", insertAtCommand);
//            map.put("PRINT_FIELD_DESCENDING_SEMESTER_ENUM", printDecendingBySemester);
//            map.put("REMOVE_BY_ID", removeByIdCommand);
//            map.put("REMOVE_ANY_BY_STUDENTS_COUNT", removeByStudentCount);
//            map.put("SHOW", showCommand);
//            map.put("UPDATE", updateCommand);

        }
    }

    public Command getCommand(String commandName) throws NoSuchCommandException {

        AbstractCommand command = map.get(commandName.toUpperCase());
        //check
        return command;
    }
}
