package org.academiadecodigo.codecadets.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;


    public ClientHandler(Socket socket){
        this.socket = socket;
    }


    public void run(){
        openStreams();
    }

    public void sendMessage(String message){
        output.println(message);
    }

    private void openStreams(){
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
