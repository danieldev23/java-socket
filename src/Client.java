import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws Exception {
        Socket socket = new Socket("localhost", 1234);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String message = sc.nextLine();
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.writeBytes(message +"\n");

        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = fromServer.readLine();
        System.out.println(response);
        socket.close();
    }

    public static void main(String[] args) throws Exception{
        new Client();
    }
}
