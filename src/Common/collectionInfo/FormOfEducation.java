package Common.collectionInfo;

import java.io.Serializable;

public enum FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    public static String listAll() {
        StringBuilder listAll = new StringBuilder();
        for (FormOfEducation formOfEducation : values()) {
            listAll.append(formOfEducation.name()).append(" ");
        }
        return listAll.toString();
    }
}