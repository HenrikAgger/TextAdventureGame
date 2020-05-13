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
public class Dice {
    private int value;
    
    public int getValue(){
        return value;
    }
    
    public void roll(){
        value = (int) (Math.random()*6)+1;
    }
            
}
