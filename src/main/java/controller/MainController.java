/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import model.Enemy;
import model.Event;
import model.Player;
import model.Room;

/**
 *
 * @author Henrik
 */
public class MainController {

//    public static LinkedBlockingDeque<Event> events = new LinkedBlockingDeque<>();
//    public static ArrayList<Event> testEvents = new ArrayList<>();
//    public static ArrayList<Room> rooms = new ArrayList<>();
//    public static Room spawnPoint;
//    public ArrayList<Player> connectionHandlers;

//    public MainController(ArrayList<Player> connectionHandlers) {
//        this.connectionHandlers = connectionHandlers;
//    }
    // MVP fields
    private Enemy enemy;
    private Player player;
    public static ArrayList<Room> rooms = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    // MVP constructor
    public MainController(Player player, ArrayList<Room> rooms, Enemy enemy  ){
        this.player = player;
        this.rooms = rooms;
        this.enemy = enemy;
    }
    

    
    
    public void runGame() {
        int choice = 0;
        player.setHere(rooms.get(0));
        boolean notempty = true;
        // Tag næste event fra eventkøen
        while (notempty) //while (choice!=9){
        {
            System.out.println(player.getHere());
            System.out.println("1 Leave room");
            System.out.println("2 Fight monster");
            System.out.println("3 Quit game");
            int input = scan.nextInt();
            switch(input){
                case 1:
                    moveToNextRoom();
                    break;
                case 2:
                    figthEnemy();
                    break;
                case 3:
                    notempty = false;
                    break;
            }
        }
    }
    public void moveToNextRoom(){
        System.out.println("Hi " + player.getName());
        Room r = player.getHere();
//        PrintWriter pw = p.getWriter();
        System.out.println("You are in room " + r.getName());
        System.out.println("You are in room " + r.getName());
        r.removePlayer(player);
        Room targetRoom = rooms.get(1);
        player.setHere(targetRoom);
        System.out.println("Player is now in " + player.getHere());

        /*
        p.move(dest);
        dest.addPlayer(p);
         */
    }
    
    public void figthEnemy(){
        System.out.println("fighting");
    
    }
    
    
}
