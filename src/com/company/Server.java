package com.company;

import java.io.*;
import java.net.*;
import java.util.Locale;

/**
 * @author lekeping
 */
public class Server {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream reader = null;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("connected and waiting for a client");

            socket = serverSocket.accept();
            System.out.println("socket accpeted");

            reader = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        while (line.toLowerCase(Locale.ROOT).compareTo("over") != 0){
            try {
                line = reader.readUTF();
                System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // write your code here
        Server server = new Server(5000);
    }
}

