/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.MainController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import tobedeleted.Player;
import worker.ConnectionHandler;

/**
 *
 * @author Henrik
 */
public class Main {

    public static void main(String[] args) {
        int limit = 1;
        int counter = 0;
        ArrayList<ConnectionHandler> clientHandlers = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
//        try {
//            ServerSocket serverSocket = new ServerSocket(9091);
//            while (counter < limit) {
//                counter++;
//
//                try {
//                    System.out.println("Waiting .." + counter);
//                    Socket clientSocket = serverSocket.accept();
//                    ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket);
//                    clientHandlers.add(connectionHandler);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("All players ready ..");
            MainController mainController = new MainController(players);
            mainController.runGame();
//            serverSocket.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
        // write your code here
    }
}
