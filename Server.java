import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPort = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();
            System.out.println("Complete connect");

            InputStream inputStream = socket.getInputStream();
            int num = inputStream.read();

            OutputStream outputStream = socket.getOutputStream();
            if (checkNum(num)){
                outputStream.write("chan".getBytes());
            }else {
                outputStream.write("le".getBytes());
            }

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkNum (int num){
        if(num % 2 == 0){
            return true;
        }else {
            return false;
        }
//        return num % 2 == 0;
    }
}
