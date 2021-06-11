package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Server.ConnectionChannel;
import Server.ServerConsoleManager;

public class ClearCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private ConnectionChannel connectionChannel;

    public ClearCommand(CollectionManager collectionManager,ConnectionChannel connectionChannel) {
        super("clear", "empties collection");
        this.collectionManager = collectionManager;
        this.connectionChannel =connectionChannel;
    }

    @Override
    public String execute(String args) {
        if (collectionManager.getCollectionSize() == 0) {
            connectionChannel.sendMes("This collection is already empty! Nothing to clear out");
            return "";
        }
        collectionManager.clearCollection();
        connectionChannel.sendMes("Collection cleared! Now it's so empty... ( •́ ‸ • ̀)");
        return "";
    }
}
