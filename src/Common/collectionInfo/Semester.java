package Common.collectionInfo;

import java.io.Serializable;

public enum Semester {
    SECOND,
    FOURTH,
    FIFTH,
    SEVENTH,
    EIGHTH;

    public static String listAll() {
        StringBuilder listAll = new StringBuilder();
        for (Semester semester : values()) {
            listAll.append(semester.name()).append(" ");
        }
        return listAll.toString();
    }
}
