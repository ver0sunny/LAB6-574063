package Common.commandToSend;

import Common.collectionInfo.StudyGroup;

import java.io.Serializable;

public abstract class CommandToSend implements Serializable {
    private String name;
    private String args;
    private String contents;

    CommandToSend(String name, String args, String contents) {
        this.name = name;
        this.args = args;
        this.contents = contents;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getArgs() {
        return args;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {return contents;}

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(" - ").append(args).append('\'').toString();
    }
}