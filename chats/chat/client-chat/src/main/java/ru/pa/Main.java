package ru.pa;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Client chat work!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scan.nextLine();

        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, 4444);
            Client client = new Client(socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            String remoteIP = inetAddress.getHostAddress();
            String port = String.valueOf(socket.getLocalPort());
            System.out.println("Вы подключились по адрессу: " + inetAddress
            + "\nIP: "+ remoteIP + "\nPort: "+ port);

            client.listenForMessage();
            client.sendForMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}