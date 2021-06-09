package Common.managers;

import Common.collectionInfo.StudyGroup;
import Common.commandToSend.CommandToSend;

import java.io.*;

public class Serializer {

    public byte[] serialize(CommandToSend obj) {
        try {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                    oos.writeObject(obj);
                    oos.flush();
                }
                return bos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] serializeContents(StudyGroup obj) {
        try {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                    oos.writeObject(obj);
                    oos.flush();
                }
                return bos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] serializeCommand(String obj) {
        try {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                    oos.writeObject(obj);
                    oos.flush();
                }
                return bos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deserializeCommand(byte[] bytes) {
        try {
            try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                try(ObjectInputStream ois = new ObjectInputStream(bis)){
                    return (String) ois.readObject();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public CommandToSend deserialize(byte[] bytes) {
        try {
            try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                try(ObjectInputStream ois = new ObjectInputStream(bis)){
                    return (CommandToSend) ois.readObject();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public StudyGroup deserializeContents(byte[] bytes) {
        try {
            try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                try(ObjectInputStream ois = new ObjectInputStream(bis)){
                    return (StudyGroup) ois.readObject();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
