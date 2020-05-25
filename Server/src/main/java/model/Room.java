/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Henrik
 */
public class Room {

    String name;
    String description;
    private Hashtable<String, Player> players;
    private Hashtable<Direction, Room> go;
    private Monster monster;
    Random r = new Random();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        go = new Hashtable<Direction, Room>();
        players = new Hashtable<String, Player>();
    }

    public Room to(Direction direction) {
        Room go = this.go.get(direction);
        return go;
    }

    public void addRoomToExit(Direction direction, Room room){
        go.put(direction, room);
    }
    
    public String getName() {
        return this.name;
    }

    public void removePlayer(Player p) {
        players.remove(p.getName());
    }

    public void addPlayer(Player p) {
        players.put(p.getName(), p);
    }
   
    public Player getRandomPlayer(){
        Set<String> keys = players.keySet();
        ArrayList<String> lists = new ArrayList<String>();
        for (String list : keys) {
            lists.add(list);
        }
        Player player = null;
        if (players.size()>0){
            int idx = r.nextInt(players.size());
            String key = lists.get(idx);
            player = players.get(key);
            
        } 
        return player;
    }

    @Override
    public String toString() {
        String message = "name: " + this.name;
        return message;
    }
}
