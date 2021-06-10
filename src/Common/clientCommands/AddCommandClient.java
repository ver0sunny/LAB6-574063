package Common.clientCommands;

import Client.ClientManager;
import Client.ClientConsoleManager;
import Common.collectionInfo.StudyGroup;
import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Common.managers.InputAndVerifier;

import java.time.LocalDateTime;
import java.util.Objects;

public class AddCommandClient extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private InputAndVerifier inputAndVerifier;
    private ClientManager clientManager;

    public AddCommandClient(CollectionManager collectionManager, InputAndVerifier inputAndVerifier, ClientManager clientManager) {
        super("add", "adds a new element to the collection");
        this.collectionManager = collectionManager;
        this.inputAndVerifier = inputAndVerifier;
        this.clientManager = clientManager;
    }

    public String execute(String args) {
        StudyGroup studyGroup = new StudyGroup(0,
                inputAndVerifier.askName(),
                LocalDateTime.now(),
                inputAndVerifier.askAdminInfo(),
                inputAndVerifier.askCoordinates(),
                inputAndVerifier.askStudentsCount(),
                inputAndVerifier.askShouldBeExpelled(),
                inputAndVerifier.askFormOfEducation(),
                inputAndVerifier.askSemester());
        ClientConsoleManager.print("Study Group created successfully");
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddCommandClient that = (AddCommandClient) o;
        return Objects.equals(collectionManager, that.collectionManager) &&
                Objects.equals(inputAndVerifier, that.inputAndVerifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectionManager, inputAndVerifier);
    }
}