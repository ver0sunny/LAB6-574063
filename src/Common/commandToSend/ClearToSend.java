package Common.commandToSend;

import Common.managers.Serializer;

import java.io.Serializable;

public class ClearToSend extends CommandToSend implements Serializable {
    public ClearToSend() {
        super("CLEAR", null, null);
    }
}
