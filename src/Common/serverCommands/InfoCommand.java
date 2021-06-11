package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Server.ConnectionChannel;

import java.time.LocalDateTime;

public class InfoCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager, ConnectionChannel connectionChannel) {
        super("info", "provides information on Collection");
        this.collectionManager = collectionManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String arg) {
        LocalDateTime creationTime = collectionManager.getCreationTime();
        StringBuilder sb = new StringBuilder();
//        sb.append("--Collection information--");
//        sb.append("\n");
        sb.append("Collection type -- " + collectionManager.getCollection().getClass().getName());
        sb.append("\n");
        sb.append("Collection size -- " + collectionManager.getCollectionSize());
        sb.append("\n");
        sb.append("Collection creation date -- " + collectionManager.getCreationTime());
        sb.append("\n");
        connectionChannel.sendMes("--Collection information--");
        return sb.toString();
    }
}
