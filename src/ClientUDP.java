import java.io.IOException;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        int serverPort = 12344;
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Server is running and waitting to client...");
            InetAddress inetAddress = InetAddress.getLocalHost();
            //sendData
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Number: ");
            int numCheck = scanner.nextInt();

            byte[] sendNum = String.valueOf(numCheck).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendNum,sendNum.length,inetAddress,serverPort);
            clientSocket.send(sendPacket);


            //receive
            byte [] receive = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receive,receive.length);

            clientSocket.receive(receivePacket);

            String mess = new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
            System.out.println(numCheck+":"+ mess);

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
