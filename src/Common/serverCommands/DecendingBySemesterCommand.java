package Common.serverCommands;

import Common.collectionInfo.StudyGroup;
import Common.commandCommon.AbstractCommand;
import Common.commandCommon.Command;
import Common.managers.CollectionManager;
import Server.ConnectionChannel;

import java.util.LinkedList;
import java.util.List;

public class DecendingBySemesterCommand extends AbstractCommand implements Command {

    private ConnectionChannel connectionChannel;
    private CollectionManager collectionManager;

    public DecendingBySemesterCommand(CollectionManager collectionManager, ConnectionChannel connectionChannel) {
        super("print_field_descending_semester_enum", "displays field semesterEnum of all elements in descending order");
        this.collectionManager = collectionManager;
        this.connectionChannel = connectionChannel;
    }

    @Override
    public String execute(String arg) {
        connectionChannel.sendMes("---collection decending by semester--->");
//        String sortedStudyGroups = collectionManager.decendBySemester();
        List<String> listToSend = new LinkedList<>();
        for (StudyGroup studyGroup : collectionManager.getCollection()) {
            listToSend.add(studyGroup.getName() + " " + studyGroup.getSemester());
        }
        return listToSend.toString();
    }
}
