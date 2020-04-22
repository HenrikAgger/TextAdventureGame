/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author Henrik
 */
public class Room {
    Door door;
    String name;
    String description;
    private Hashtable<String, Item> items;
    private Hashtable<String, Player> players;
    private Hashtable<Door.Direction, Room> exits;
    private Enemy enemy;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new Hashtable<Door.Direction, Room>();
        players = new Hashtable<String, Player>();
    }
    
    
    
    public Room(String name) {
        exits = new Hashtable<Door.Direction, Room>();
        this.name = name;
        Random rand = new Random();
        
    }

    public void addDoor(Door door, Door.Direction direction, Room nextRoom) {
        
        this.door = door;
        this.exits.put(direction, nextRoom);
    }

    public String getName() {

        return this.name;
    }

    public Door getDoor() {
        return this.door;
    }
    public void removePlayer(Player p) {
        players.remove(p.getName());
    }
    public void addPlayer(Player p) {
        players.put(p.getName(),p);
    }
    public Room to(Door.Direction direction) {
        Room newRoom = this.exits.get(direction);
        return newRoom;
    }

    
    @Override
    public String toString() {
        String message = "name: " + this.name;
        return message;
    }
       
    
}
