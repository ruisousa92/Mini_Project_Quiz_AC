package org.academiadecodigo.codecadets.server.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private String name;
    private PrintWriter outputWriter;
    private BufferedReader inputReader;

    public ClientHandler(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }


    @Override
    public void run() {

        openIOStreams();
    }

    public void openIOStreams() {

        try {
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void sendServerQuestion(String message) {
        outputWriter.println(message);
    }
}

