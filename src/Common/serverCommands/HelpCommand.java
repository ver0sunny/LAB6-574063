package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Server.CommandFactory;
import Server.ConnectionChannel;

public class HelpCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;

    public HelpCommand(ConnectionChannel connectionChannel) {
        super("help", "info on available commands");
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String  arg) {

//        try {
//            if (arg == null) throw new NoArgumentException();
//        }catch (NoArgumentException e) {
//            ConsoleManager.printerror("No argument! " + toString());
//        }

        StringBuilder sb = new StringBuilder();
        sb.append(CommandFactory.map.get("ADD").toString());
        sb.append("\n");
//        sb.append(CommandFactory.map.get("ADD_IF_MIN").toString());
//        sb.append("\n");
        sb.append(CommandFactory.map.get("CLEAR").toString());
        sb.append("\n");
//        sb.append(CommandFactory.map.get("EXECUTE_SCRIPT").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("EXIT").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("FILTER_GREATER_THAN_FORM_OF_EDUCATION").toString());
//        sb.append("\n");
        sb.append(CommandFactory.map.get("HELP").toString());
        sb.append("\n");
//        sb.append(CommandFactory.map.get("HISTORY").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("INFO").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("INSERT_AT").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("PRINT_FIELD_DESCENDING_SEMESTER_ENUM").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("REMOVE_BY_ID").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("REMOVE_ANY_BY_STUDENTS_COUNT").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("SAVE").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("SHOW").toString());
//        sb.append("\n");
//        sb.append(CommandFactory.map.get("UPDATE").toString());
//        sb.append("\n");
        connectionChannel.sendMes("");
        return sb.toString();
    }
}
