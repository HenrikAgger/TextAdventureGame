/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import controller.Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import model.Event;
import model.Player;

/**
 *
 * @author Henrik
 */
public class MonsterProducer extends Thread {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader br;
    private Controller controller;
    private Player player;

    public MonsterProducer(Controller controller) throws IOException {
        this.controller = controller;
        
        File file = new File("test.txt");
        this.printWriter = new PrintWriter(file);
//        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        while (true) {
            try {
                sleep(10000);
                String line = "Troll";
                player = controller.registerPlayer(line, printWriter);
                line = "FIGHTPLAYER";
                controller.processMessage(player, line);
                Event event = new Event(line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
