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
public class Enemy {
    private int health = 50;
    private String enemyName;

   
    
    public Enemy(int health, String enemyName) {
        this.health = health;
        this.enemyName = enemyName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getEnemyName() {
        return enemyName;
    }
    
    
    
    
    
}
