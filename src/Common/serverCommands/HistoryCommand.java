package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.HistoryManager;
import Server.ConnectionChannel;

public class HistoryCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;
    private HistoryManager historyManager;

    public HistoryCommand(HistoryManager historyManager,ConnectionChannel connectionChannel) {
        super("history", "displays 12 previous commands with no argument(s)");
        this.historyManager = historyManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String arg) {
        connectionChannel.sendMes(" ---command history--->");
        return historyManager.history();
    }
}
