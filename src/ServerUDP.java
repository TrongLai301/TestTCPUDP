import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class ServerUDP {
    public static void main(String[] args) {
        int serverPort = 12344;

        String isPrime = " is Prime";
        String isNotPrime = " isn't Prime";

        try {
            DatagramSocket clientSocket = new DatagramSocket(serverPort);

            //receiveData
            byte[] receiveData = new byte[1024];
            DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(serverPacket);
            String responseMess = new String(serverPacket.getData(), serverPacket.getOffset(), serverPacket.getLength());
            int numCheck = Integer.parseInt(responseMess);
            System.out.println("Checking number...");


            //SendData
            byte[] sendData = isNotPrime.getBytes();

            if (checkPrime(numCheck)) {
               sendData = isPrime.getBytes();
                System.out.println(isPrime);
            }
            InetAddress inetAddress = InetAddress.getLocalHost();
            int port = serverPacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,inetAddress,port);
            clientSocket.send(sendPacket);

            System.out.println("Done!");
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean checkPrime(int number) {
        if (number < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
