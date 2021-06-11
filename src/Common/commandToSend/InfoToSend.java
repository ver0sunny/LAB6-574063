package Common.commandToSend;

import java.io.Serializable;

public class InfoToSend extends CommandToSend implements Serializable {
    public InfoToSend() {
        super("INFO", null,null);
    }
}