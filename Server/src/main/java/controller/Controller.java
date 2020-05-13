/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
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
    public Controller(Player player, Monster monster, ArrayBlockingQueue<Event> events) throws IOException {
        this.player = player;
        this.monster = monster;
        this.events = events;
        this.ss = new ServerSocket(5555);
    }

    public Controller(ArrayBlockingQueue<Event> events) throws IOException {
        this.events = events;
        this.ss = new ServerSocket(5555);
    }

    public Player registerPlayer(String name, PrintWriter printWriter) {
        Player player = new Player(name, printWriter);
        this.player = player;
        return player;
    }

    public void processMessage(Player player, String message) {
        String actionToken = "";
        String targetToken = "";
        System.out.println("Player ");
        player.getWriter().println("Hi you wrote " + message);
        String[] lineAr = message.split(" ");
        actionToken = lineAr[0];
        String[] targetTokenArray = Arrays.copyOfRange(lineAr, 1, lineAr.length);
               
        targetToken = String.join(" ", targetTokenArray);
        // process input fx "fight monster"
        // process input fx "leave room1"
        // process input fx "leave NORTH"
        // process input fx "pick up gun"
        // process input fx "inventory"
        // process input fx "fight monster"

        // process dvs tokenize string

        switch (actionToken) {
            case "fight":
                // creates message for fighting a monster
                fightMonster(targetToken, player);
                break;
            case "exit":
                // creates message for fighting a monster
                exitRoom(targetToken, player);
                break;
            case "NORTH":
                north(targetToken, player);
                break;
            case "EAST":
                east(targetToken, player);
                break;
            case "SOUTH":
                south(targetToken, player);
                break;
            case "WEST":
                west(targetToken, player);
                break;

        }

    }

    public void fightMonster(String targetToken, Player player) {
        player.getWriter().println("Hi into fight " + targetToken);
    }

    public void exitRoom(String targetToken, Player player) {
        player.getWriter().println("Hi exiting the room " + targetToken);
        System.out.println("You have exited a room");
    }

    public void north(String targetToken, Player player) {
        player.getWriter().println("Hi you are going north" + targetToken);
        System.out.println("You have mooved north");
    }
    
    public void east(String targetToken, Player player) {
        player.getWriter().println("Hi you are going east" + targetToken);
        System.out.println("You have mooved east");
    }    
    
    public void south(String targetToken, Player player) {
        player.getWriter().println("Hi you are going south" + targetToken);
        System.out.println("You have mooved south");
    }

    public void west(String targetToken, Player player) {
        player.getWriter().println("Hi you are going west" + targetToken);
        System.out.println("You have mooved west");
    }    
    

    public void runGame() throws IOException {
        // Now initializing clienthandler_producer
        System.out.println("Waiting");
        Socket s = ss.accept();
        Producer producer = new Producer(s, this);
        int choice = 0;
        boolean notempty = true;

        System.out.println("Socket from client");
        Consumer consumer = new Consumer(events);

        consumer.start();
        producer.start();

        while (notempty) {
            System.out.println("1 Fight monster");
            System.out.println("2 Quit game");
            int input = scan.nextInt();
            consumer.readFromQueue();
            switch (input) {
                case 1:
                    fightMonster();
                    break;
                case 2:
                    notempty = false;
                    break;
            }
        }
    }

    public void fightMonster() {
        System.out.println("Fighting monster");
    }

}
