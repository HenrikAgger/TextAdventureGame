/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import model.Event;

/**
 *
 * @author Henrik
 */
public class Producer extends Thread {

    Scanner scan = new Scanner(System.in);
    private ArrayBlockingQueue<Event> queue;
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader br;

    public Producer(ArrayBlockingQueue<Event> queue) {
        this.queue = queue;
    }

    public Producer(ArrayBlockingQueue<Event> queue, Socket socket) throws IOException {
        this.queue = queue;
        this.socket = socket;
        this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void Write(Event event) {
        try {
            queue.add(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run(){
        while(true){
            String line = "";
            printWriter.println("Insert a few words");
            try{
                line = br.readLine();
            } catch(IOException e){
                e.getStackTrace();
            }
            Event event = new Event(line);
            Write(event);
            printWriter.println("Du har valgt at indsætte følgende: "+line);
        }
    }
    
}
