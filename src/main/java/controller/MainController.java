/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;
import model.Door;
import model.Event;
import model.Key;
import model.Player;
import model.Room;
import worker.ConnectionHandler;

/**
 *
 * @author Henrik
 */
public class MainController {

    public static LinkedBlockingDeque<Event> events = new LinkedBlockingDeque<>();
    public static ArrayList<Event> testEvents = new ArrayList<>();
    public static Room spawnPoint;
    public ArrayList<Player> connectionHandlers;

    public MainController(ArrayList<Player> connectionHandlers) {
        this.connectionHandlers = connectionHandlers;
    }

    public void runGame() {
        Room room1 = new Room("Entrence to the dungeon");
        Room room2 = new Room("You are in a room with a lot of old skeletons ");
        Room room3 = new Room("There is a huge spiderweb in this room");
        Room room4 = new Room("You walk a few steps and suddenly you see an sacrifice alter");
        Room room5 = new Room("You can see a chest, you open it take all the gold with you."
                + " you see light, you have found the exit");
        Room exit = new Room("YOU WON");
        this.spawnPoint = room1;
        Key k = new Key("Universal", "Key for all");
        Door door = new Door(k, "Exit", "Get out");
        // 1st room
        room1.addDoor(door, Door.Direction.NORTH, room3);
        room1.addDoor(door, Door.Direction.EAST, room2);
        // 2nd room
        room2.addDoor(door, Door.Direction.NORTH, room4);
        room2.addDoor(door, Door.Direction.WEST, room1);
        // 3rd room
        room3.addDoor(door, Door.Direction.EAST, room4);
        room3.addDoor(door, Door.Direction.SOUTH, room1);
        // 4th room
        room4.addDoor(door, Door.Direction.EAST, room5);
        room4.addDoor(door, Door.Direction.SOUTH, room2);
        room4.addDoor(door, Door.Direction.WEST, room3);
        // 5th room
        room5.addDoor(door, Door.Direction.NORTH, exit);

        int choice = 0;
        Player p = connectionHandlers.get(0);
        boolean notempty = true;
        // Tag næste event fra eventkøen
        while (notempty) //while (choice!=9){
        {
            process(p, "MOVE room2");
            
        }




        //  choice = p.move(room);
        //}
//        while (true) {
//            for (Player c : connectionHandlers) {
//                c.start();
//            }
//        }
    }

    public static void process(Player p, String input) {
        String[] tmpArr = input.split(" ");
        String action = tmpArr[0];
        String[] tokensArr = Arrays.copyOf(tmpArr, tmpArr.length - 1);
        String tokens = String.join(" ", tokensArr);

        switch (action) {
            case "MOVE":
                processMove(p, tokens);
                break;
            case "SAY":
                processSay(p, tokens);
                break;
            case "WHO":
                processWho(p);
                break;
            default:
                processHelp(p);
                break;
        }
    }

    public static void processSay(Player p, String tokens) {
        System.out.println("Hi says " + p.getName());
        PrintWriter pw = p.getWriter();
        pw.println("And this is good for you");
    }

    public static void processMove(Player p, String tokens) {
        System.out.println("Hi " + p.getName());
        Room r = p.getHere();
        PrintWriter pw = p.getWriter();
        System.out.println("You are in room " + r.getName());
        pw.println("You are in room " + r.getName());
        pw.println(" and want to move to " + tokens);
        r.removePlayer(p);


        /*
        p.move(dest);
        dest.addPlayer(p);
         */
    }

    public static void processWho(Player p) {
        System.out.println("Hi");
    }

    public static void processHelp(Player p) {
        System.out.println("Hi");
    }

    public static synchronized Player register(String name, PrintWriter w) {
        Player p = new Player(name, spawnPoint, w);
        System.out.println("player " + name + " registered");
        return p;
    }

    private synchronized void addEvent(Event event) {
        try {
            this.events.put(event);
        } catch (InterruptedException e) {
            return;
        }
    }
}
