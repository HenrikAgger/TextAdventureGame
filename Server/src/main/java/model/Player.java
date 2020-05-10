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

    private String name;
    private PrintWriter out;

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

}
