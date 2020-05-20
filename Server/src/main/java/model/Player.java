/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.PrintWriter;

/**
 *
 * @author Henrik
 */
public class Player {
    private int d1; 
    private int d2;
    private int g;
    private int goldTotal;
    private String name;
    private PrintWriter out;
    private Room room;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, PrintWriter out) {
        this.name = name;
        this.out = out;
    }

    public void setWriter(PrintWriter out) {
        if (this.out != null) {
            throw new RuntimeException("Writer already set");
        }
        if (out == null) {
            throw new IllegalArgumentException("Writer must be not-null");
        }
        this.out = out;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public PrintWriter getWriter() {
        return this.out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrintWriter getOut() {
        return out;
    }

    public int playerFight(Dice dice) {
        d1 = dice.roll();
        d2 = dice.roll();
        return d1+d2;
    }
    
    public int playerGold(Gold gold){
        g = gold.rGold();
        return g;
    }     
    
    public int playerGoldTotal(Gold gold){
        goldTotal += g;
        return goldTotal;
    }
    
   

}
