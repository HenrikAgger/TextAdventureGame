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

    private Room here;
    private String name;
    private PrintWriter out;

    public Player(String name, Room spawn, PrintWriter out) {
        this.name = name;
        this.here = spawn;
        this.setWriter(out);
    }

    public void setWriter(PrintWriter out) {
        if (this.out != null) {
            throw new RuntimeException("writer already set");
        }

        if (out == null) {
            throw new IllegalArgumentException("writer must be non-null");
        }

        this.out = out;
    }

    public PrintWriter getWriter() {
        return this.out;
    }

    public Room getHere() {
        return here;
    }

    public void setHere(Room here) {
        this.here = here;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(Room room) {
        this.here = room;
    }

    public PrintWriter getOut() {
        return out;
    }

}
