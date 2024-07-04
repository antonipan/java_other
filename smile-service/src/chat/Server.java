package chat;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocketImpl;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serv = new ServerSocket(3210)){
            Socket client = serv.accept();
            System.out.println("Connected...");

            DataOutputStream out_serv = new DataOutputStream(client.getOutputStream());
            System.out.println("System output stream created");

            DataInputStream in_serv = new DataInputStream(client.getInputStream());
            System.out.println("Data input stream created");

            while (!client.isClosed()) {
                System.out.println("Reading from client");
                String entry = in_serv.readUTF();
                System.out.println("Получено сообщение: " + entry);

                if (entry.equals("exit")) {
                    System.out.println("Вы выходите? Хорошо. ");
                    out_serv.writeUTF(" Вы нажали " + entry + ". By");
                    out_serv.flush();
                    Thread.sleep(1000);
                    break;
                }
                out_serv.writeUTF("Сервер получил Ваш ответ : " + entry);
                out_serv.flush();

            }
            System.out.println("Disconnected server");
            in_serv.close();
            out_serv.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
