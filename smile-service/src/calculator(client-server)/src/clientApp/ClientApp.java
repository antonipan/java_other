package clientApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mathExample;
        Socket socket;

        {
            try {
                socket = new Socket("LocalHost", 4444);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    System.out.println("Введите пример типа (3+20)*4: ");
                    mathExample = scan.nextLine();
                    dataOutputStream.writeUTF(mathExample);
                    if("end".equals(mathExample))
                        break;
                    System.out.println("Получили от сервера и прочитали: " + dataInputStream.readUTF());

                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
