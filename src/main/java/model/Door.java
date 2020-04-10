/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Henrik
 */
public class Door {
    public static enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    public static final String DEFAULT_NAME = "door";
    public static final String DEFAULT_DESCRIPTION = "A normal-looking door.";

    private Key key;
    private String description;
    private String name;
    private boolean locked;

    public Door(Key k, String name, String desc) {
        this.key = k;
        this.name = name;
        this.description = desc;
        this.locked = true;
    }

    public boolean unLockDoor(Key k) {
        if (k == this.key) {
            this.locked = false;
        }
        return this.locked;
    }

    public boolean lockDoor(Key k) {
        if (k == this.key) {
            this.locked = true;
        }
        return this.locked;
    }    
}
