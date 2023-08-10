import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String Ip = "127.0.0.1";
        int serverPort = 8000;

        try {
            Socket clientSocket = new Socket(Ip,serverPort);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number: ");
            int num = scanner.nextInt();

            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(num);

            InputStream inputStream = clientSocket.getInputStream();
            System.out.println(new String(inputStream.readAllBytes()));
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
