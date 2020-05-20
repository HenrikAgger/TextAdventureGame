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
public class Gold {

    private int gold;
        
    public Gold() {
        this.gold = rGold();
    }

    public int getGold() {
        return gold;
    }

    public int rGold() {
        gold = (int) (Math.random() * 10) + 1;
        return gold;
    }

}
