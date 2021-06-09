package Client;

import Common.commandToSend.CommandToSend;
import Common.managers.Serializer;

import java.net.*;

public class ClientManager {

    private Serializer serializer;
    private ConnectionPacket connectionPacket;
    private byte[] toSend;

    private DatagramSocket clientSocket;
    private final int SERVICE_PORT = 50001;
    InetAddress IPAddress;
    private byte[] receivingDataBuffer = new byte[65000];

    public ClientManager(Serializer serializer, ConnectionPacket connectionPacket) {
        this.serializer = serializer;
        this.connectionPacket = connectionPacket;
    }

    //
    public CommandToSend receive() {
        byte[] receivingPacket = connectionPacket.receive();
        return serializer.deserialize(receivingPacket);
    }

    public void send(CommandToSend commandToSend) {
        byte[] toSend = serializer.serialize(commandToSend);
        connectionPacket.send(toSend);
    }

    public String receiveMes() {
        return serializer.deserializeCommand(connectionPacket.receive());
    }

    public void sendMes(String mesToSend) {
        connectionPacket.send(serializer.serializeCommand(mesToSend));
    }
}

