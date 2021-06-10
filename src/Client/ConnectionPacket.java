package Client;

import java.io.IOException;
import java.net.*;

public class ConnectionPacket {

    private DatagramSocket clientSocket;
    private final int SERVICE_PORT = 50001;
    InetAddress IPAddress;
    private byte[] receivingDataBuffer = new byte[65000];

    public ConnectionPacket() {
        setUp();
    }

    public void setUp() {
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            IPAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] pack = new byte[1];
        send(pack);
        ClientConsoleManager.println("..Client activated..");
    }

    public byte[] receive() {
        DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
        try {
            clientSocket.receive(receivingPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivingPacket.getData();
    }

//    public String receiveMes() {
//        DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
//        try {
//            clientSocket.receive(receivingPacket);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return serializer.deserializeCommand(receivingPacket.getData());
//    }

    public void send(byte[] toSend) {
        DatagramPacket sendingPacket = new DatagramPacket(toSend,toSend.length,IPAddress, SERVICE_PORT);
        try {
            clientSocket.send(sendingPacket);
//            ClientConsoleManager.println("Packet sent successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void sendMes(String mesToSend) {
//        DatagramPacket sendingPacket = new DatagramPacket(serializer.serializeCommand(mesToSend),serializer.serializeCommand(mesToSend).length,IPAddress, SERVICE_PORT);
//        try {
//            clientSocket.send(sendingPacket);
//            System.out.println("Message sent successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
