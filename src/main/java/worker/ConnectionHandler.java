/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import controller.MainController;
import model.Event;
import model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 *
 * @author Henrik
 */
public class ConnectionHandler extends Thread {
    private Socket client;

    public ConnectionHandler(Socket s) {
        this.client = s;
    }

    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(this.client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

        } catch (IOException e) {
            System.err.print("DungeonServer: failed getting client streams\n");
            return;
        }
        String name = null;
        try {
            /* Expect the first data sent from the client to be the name */
            name = in.readLine();

            System.out.printf("player '%s' connected (start of stream)\n", name);
            String login = name + " connected.";
            Event event = new Event("login");
            MainController.events.add(event);

            /* Try to access saved state in universe for this player */
            Player p = null;
            p = MainController.register(name, out);


            String toProtocol;
            /* Read lines from client and send to protocol */
            
            while ((toProtocol = in.readLine()) != null) {
                try {
                    System.out.println("reading .." + toProtocol);
                    MainController.process(p,toProtocol);
                } catch (Exception e) {
                    break;
                }
            }

            out.close();
            in.close();
            client.close();

        } catch (IOException e) {
            System.err.print("DungeonServer: failed reading or closing streams\n");
            System.out.printf("player '%s' disconnected (socket failure)\n", name);
            e.printStackTrace();
        }
    }    
}
