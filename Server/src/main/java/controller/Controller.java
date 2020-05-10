/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import model.Event;
import model.Monster;
import model.Player;
import worker.Producer;
import worker.Consumer;

/**
 *
 * @author Henrik
 */
public class Controller {
    
    private Player player;
    private Monster monster;
    ArrayBlockingQueue<Event> events;
    ServerSocket ss;
    Socket socket;
    Scanner scan = new Scanner(System.in);

    /**
     *
     * @param player
     * @param monster
     * @param events
     */
    public Controller(Player player,Monster monster, ArrayBlockingQueue<Event> events) throws IOException {
        this.player = player;        
        this.monster = monster;
        this.events = events;
        this.ss = new ServerSocket(5555);
    }

    public void runGame() throws IOException {
        int choice = 0;
        boolean notempty = true;
        System.out.println("Waiting");
        socket = ss.accept();
        System.out.println("Socket from client");
        Consumer consumer = new Consumer(events);
        Producer producer = new Producer(events, socket);
        
        consumer.start();
        producer.start();
        
        while (notempty) {
                System.out.println("1 Fight monster");
                System.out.println("2 Quit game");
                int input = scan.nextInt();
                consumer.readFromQueue();
                switch(input){
                    case 1:
                        fightMonster();
                        break;
                    case 2:
                        notempty = false;
                        break;
                }
        }
    }
    public void fightMonster(){
        System.out.println("Fighting monster");
    }

}
