package Common.serverCommands;

import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Server.ConnectionChannel;

public class RemoveByIdCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager, ConnectionChannel connectionChannel) {
        super("remove_by_id <id>", "deletes element with provided <id>");
        this.collectionManager = collectionManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String arg) {
        Integer id = Integer.parseInt(arg);
        collectionManager.removeById(id);
        connectionChannel.sendMes("Study Group with ID:" + arg + " removed successfully");
        return "k";
    }
}
