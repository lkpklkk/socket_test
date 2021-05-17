package com.company;
import java.net.*;
import java.io.*;
import java.util.Locale;

public class Client {
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address,port);
            System.out.println("connected");
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){
            System.out.println("Exception catched");
            System.out.println(e);
            e.printStackTrace();
        }
        String line = "";
        while (line.toLowerCase(Locale.ROOT).compareTo("over") != 0){
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
	// write your code here
        Client client = new Client("127.0.0.1",5000);
    }
}
