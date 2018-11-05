package org.academiadecodigo.codecadets.server;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;

import java.io.IOException;

public class ServerLauncher {



    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in,System.out);
        IntegerInputScanner integerInputScanner = new IntegerInputScanner();
        integerInputScanner.setMessage("Please enter your port number: ");
        int port = prompt.getUserInput(integerInputScanner);


        try {
            Server server = new Server(port);
            server.start();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
