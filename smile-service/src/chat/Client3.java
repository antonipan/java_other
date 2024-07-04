package chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client3 {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 3210);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream out_clin = new DataOutputStream(socket.getOutputStream());
             DataInputStream in_clin = new DataInputStream(socket.getInputStream())) {
             System.out.println("Client connected to socket.");
             System.out.println();
             System.out.println("Client writing channel = oos & reading channel = ois initialized.");

// проверяем живой ли канал и работаем если живой
            while (!socket.isOutputShutdown()) {
// ждём консоли клиента на предмет появления в ней данных
                if (br.ready()) {
// данные появились - работаем
                    System.out.println("Client start writing in channel...");
                    String clientCommand = br.readLine();
// пишем данные с консоли в канал сокета для сервера
                    out_clin.writeUTF(clientCommand);
                    out_clin.flush();
                    System.out.println("Clien sent message " + clientCommand + " to server.");
// ждём чтобы сервер успел прочесть сообщение из сокета и ответить
// проверяем условие выхода из соединения
                    if (clientCommand.equals("quit")) {
// если условие выхода достигнуто разъединяемся
                        System.out.println("Client kill connections");
// смотрим что нам ответил сервер на последок перед закрытием ресурсов
//                        if (in_clin.read() > -1) {
//                            System.out.println("reading...");
//                            String in = in_clin.readUTF();
//                            System.out.println(in);
//                        }
// после предварительных приготовлений выходим из цикла записи чтения
                        break;
                    }

// если условие разъединения не достигнуто продолжаем работу
                    System.out.println("Client sent message & start waiting for data from server...");
// проверяем, что нам ответит сервер на сообщение(за предоставленное ему время в паузе он должен был успеть ответить)
//                    if (in_clin.read() > -1) {
//// если успел забираем ответ из канала сервера в сокете и сохраняем её в ois переменную,  печатаем на свою клиентскую консоль
//                        System.out.println("reading...");
//                        String in = in_clin.readUTF();
//                        System.out.println(in);
//                    }
                }
            }
// на выходе из цикла общения закрываем свои ресурсы
            System.out.println("Closing connections & channels on clentSide - DONE.");

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}