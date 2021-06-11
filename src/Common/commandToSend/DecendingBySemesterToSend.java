package Common.commandToSend;

import java.io.Serializable;

public class DecendingBySemesterToSend extends CommandToSend implements Serializable {
    public DecendingBySemesterToSend() {
        super("PRINT_FIELD_DESCENDING_SEMESTER_ENUM", null,null);
    }
}
