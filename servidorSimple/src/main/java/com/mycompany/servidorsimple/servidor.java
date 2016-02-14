/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidorsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author Megan
 */
public class servidor {
    //private static Simulador sim;
    
    public static void main(String[] args) throws IOException {
        
        //sim=new Simulador();
        //sim.start();
        
        int portNumber = 8001;
        int i,j=1;
        
        try        
        {
            ServerSocket serverSocket = new ServerSocket(8000);
            ArrayList<Socket> clientS=new ArrayList<Socket> ();
            ArrayList<Thread> threads=new ArrayList<Thread> ();
            
            for(i=0;i<j;i++){
                Socket clientSocket = serverSocket.accept();
                clientS.add(clientSocket);
            
                //Thread t1 = new Thread(new Mithread(clientSocket, sim));
                Thread t1 = new Thread(new Mithread(clientSocket));
                threads.add(t1);
                t1.start();
                j++;
                
                //Enrutamiento
                System.out.println(t1.toString());
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
