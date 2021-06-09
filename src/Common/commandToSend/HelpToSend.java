package Common.commandToSend;

import java.io.Serializable;

public class HelpToSend extends CommandToSend implements Serializable {
    public HelpToSend() {
        super("HELP", null,null);
    }
}
