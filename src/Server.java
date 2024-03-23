import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running on port 1234");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = fromClient.readLine();
            System.out.println("Received: " + line);
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            toClient.writeBytes("Hello world\n");
            System.out.println("Sent: Hello world");
            System.out.println("Closing connection");
            socket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server();
    }
}
