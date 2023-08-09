import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        int serverPort = 8080;

        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(serverIp,serverPort);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter number: ");
            int num = scanner.nextInt();

            dataOutputStream.writeUTF(String.valueOf(num));


            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            String mess = dataInputStream.readUTF();
            System.out.println(mess);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



