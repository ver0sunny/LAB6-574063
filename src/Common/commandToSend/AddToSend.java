package Common.commandToSend;

import Common.collectionInfo.StudyGroup;
import Common.managers.Serializer;

import java.io.Serializable;

public class AddToSend extends CommandToSend implements Serializable {
    Serializer serializer = new Serializer();
    public AddToSend() {
        super("ADD", null, null);
    }
}

