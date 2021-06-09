package Common.commandCommon;

import Common.collectionInfo.StudyGroup;

public interface Command {
    String execute(String arg);
    String getName();
    String getDescription();
}
