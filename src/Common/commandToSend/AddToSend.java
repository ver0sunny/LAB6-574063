package Common.commandToSend;

import Common.collectionInfo.StudyGroup;
import Common.managers.Serializer;

import java.io.Serializable;

public class AddToSend extends CommandToSend implements Serializable {
    public AddToSend() {
        super("ADD", null, null);
    }
}

