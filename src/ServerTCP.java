import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        int serverPort = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Waitting for connect");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Checking number..." + message);

            String even = "This is even number";
            String odd = "This is odd number";

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            if (checkNumber(Integer.parseInt(message))){
                dataOutputStream.writeUTF(even);
            }else {
                dataOutputStream.writeUTF(odd);
            }
            dataOutputStream.flush();

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkNumber (int number){
        return number % 2 == 0;
    }
}
