package Server;

import Common.commandToSend.CommandToSend;
import Common.exceptions.NoSuchCommandException;
import Common.managers.Serializer;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerManager {
    private DatagramSocket serverSocket;
    private InetAddress senderAddress;
    private int senderPort;
    private byte[] receivingDataBuffer = new byte[65000];
    private final int SERVICE_PORT = 50001;
    private CommandManager commandManager;
    private Serializer serializer;
    private ConnectionChannel connectionChannel;
    private byte[] toSend;

    public ServerManager(CommandManager commandManager, Serializer serializer, ConnectionChannel connectionChannel) {
        this.commandManager = commandManager;
        this.serializer = serializer;
        this.connectionChannel = connectionChannel;
    }

    public byte[] receiveExecute() {

        byte[] inputPacket = connectionChannel.receive();
        CommandToSend receivedObject;
        receivedObject = serializer.deserialize(inputPacket);
//        ConsoleManager.println(receivedObject.toString());
        String commandName = receivedObject.getName();
        String args = receivedObject.getArgs();
        String messageToSend = null;
            try {
                messageToSend = commandManager.execute(commandName, args);
            } catch (NoSuchCommandException e) {
                ConsoleManager.println("Client mistake");
            }
        receivedObject.setArgs(messageToSend);
        toSend = serializer.serialize(receivedObject);
        return toSend;
    }

    public void send() {
        connectionChannel.send(toSend);
        ConsoleManager.println("^-^ Executed " + serializer.deserialize(toSend).getName() + " command successfully sent ^0^");
    }

    public String receiveMes() {
        return connectionChannel.receiveMes();
    }
}
