package Common.commandToSend;

import java.io.Serializable;

public class HistoryToSend extends CommandToSend implements Serializable {
    public HistoryToSend() {
        super("HISTORY", null,null);
    }
}