import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String request;
        String type = scan.nextLine();
        if (type.equals("RESTORE")) request = "{\"type\": \"" + type + "\"}";
        else {
            String task = scan.nextLine();
            request = String.format("{\"type\": \"%s\", \"task\": \"%s\"}", type, task);
        }
        try (Socket socket = new Socket("127.0.0.1", 8989);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println(request);
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
