package Common.commandToSend;

import java.io.Serializable;

public class RemoveByIdToSend extends CommandToSend implements Serializable {
    public RemoveByIdToSend() {
        super("REMOVE_BY_ID", null,null);
    }
}