package Common.clientCommands;

import Client.CommandFactory;
import Client.ClientConsoleManager;
import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;

public class HelpCommandClient extends AbstractCommand implements Command {
    public HelpCommandClient() {
        super("help", "info on available commands");
    }

    @Override
    public String execute(String arg) {
//        ConsoleManager.println(CommandFactory.map.get("ADD").toString());
//        ConsoleManager.println(CommandFactory.map.get("ADD_IF_MIN").toString());
//        ConsoleManager.println(CommandFactory.map.get("CLEAR").toString());
//        ConsoleManager.println(CommandFactory.map.get("EXECUTE_SCRIPT").toString());
//        ConsoleManager.println(CommandFactory.map.get("EXIT").toString());
//        ConsoleManager.println(CommandFactory.map.get("FILTER_GREATER_THAN_FORM_OF_EDUCATION").toString());
        ClientConsoleManager.println(CommandFactory.map.get("HELP").toString());
//        ConsoleManager.println(CommandFactory.map.get("HISTORY").toString());
//        ConsoleManager.println(CommandFactory.map.get("INFO").toString());
//        ConsoleManager.println(CommandFactory.map.get("INSERT_AT").toString());
//        ConsoleManager.println(CommandFactory.map.get("PRINT_FIELD_DESCENDING_SEMESTER_ENUM").toString());
//        ConsoleManager.println(CommandFactory.map.get("REMOVE_BY_ID").toString());
//        ConsoleManager.println(CommandFactory.map.get("REMOVE_ANY_BY_STUDENTS_COUNT").toString());
//        ConsoleManager.println(CommandFactory.map.get("SAVE").toString());
//        ConsoleManager.println(CommandFactory.map.get("SHOW").toString());
//        ConsoleManager.println(CommandFactory.map.get("UPDATE").toString());
        return null;
    }
}
