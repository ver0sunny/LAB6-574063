package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Server.ConnectionChannel;

public class ShowCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager, ConnectionChannel connectionChannel) {
        super("show","displays all collection elements");
        this.collectionManager = collectionManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String arg) {
        StringBuilder sb = new StringBuilder();
        sb.append(collectionManager);
        connectionChannel.sendMes("---collection--->");
        return sb.toString();
    }
}
