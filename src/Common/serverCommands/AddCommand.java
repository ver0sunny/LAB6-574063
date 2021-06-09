package Common.serverCommands;

import Common.collectionInfo.StudyGroup;
import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Common.managers.InputAndVerifier;
import Common.managers.Serializer;
import Server.ConnectionChannel;
import Server.ServerManager;

import java.time.LocalDateTime;
import java.util.Objects;

public class AddCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private InputAndVerifier inputAndVerifier;
    private ConnectionChannel connectionChannel;

    public AddCommand(CollectionManager collectionManager, ConnectionChannel connectionChannel) {
        super("add", "adds a new element to the collection");
        this.collectionManager = collectionManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String args) {

        connectionChannel.sendMes(inputAndVerifier.askName());
        String name = connectionChannel.receiveMes();
        connectionChannel.sendMes(inputAndVerifier.askAdminName());
        String adminName = connectionChannel.receiveMes();



        StudyGroup studyGroup;

//        StudyGroup studyGroup;
//        studyGroup = serializer.deserializeContents(args);
//        studyGroup.setId(collectionManager.generateId());
//        collectionManager.addToCollection(studyGroup);
//        StudyGroup studyGroup = new StudyGroup(
//                collectionManager.generateId(),
//                inputAndVerifier.askName(),
//                LocalDateTime.now(),
//                inputAndVerifier.askAdminInfo(),
//                inputAndVerifier.askCoordinates(),
//                inputAndVerifier.askStudentsCount(),
//                inputAndVerifier.askShouldBeExpelled(),
//                inputAndVerifier.askFormOfEducation(),
//                inputAndVerifier.askSemester());
//        collectionManager.addToCollection(studyGroup);
        return "Study Group added successfully";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddCommand that = (AddCommand) o;
        return Objects.equals(collectionManager, that.collectionManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectionManager);
    }
}