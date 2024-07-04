package ru.anton.homework02;

import ru.anton.homework02.view.ClientUI;
import ru.anton.homework02.view.ServerUI;

public class Main {
    public static void main(String[] args) {
        ServerUI serverView = new ServerUI();
        new ClientUI(serverView);
        new ClientUI(serverView);
        new ClientUI(serverView);
    }
}
