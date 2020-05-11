/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import model.Event;
import model.Monster;
import model.Player;

/**
 *
 * @author Henrik
 */
public class Main {

    public static void main(String[] args) throws IOException{

        int limit = 1;
        int counter = 0;

        ArrayBlockingQueue<Event> events = new ArrayBlockingQueue<>(5);

        Player player = new Player("Kurt");
        Monster monster = new Monster("Troll");

        Controller controller = new Controller(events);
        controller.runGame();
    }
}
