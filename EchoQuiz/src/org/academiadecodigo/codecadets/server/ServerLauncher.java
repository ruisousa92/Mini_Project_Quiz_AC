package org.academiadecodigo.codecadets.server;

import java.io.IOException;

public class ServerLauncher {

    private static final int DEFAULT_PORT = 9090;

    public static void main(String[] args) {

        try {
            Server server = new Server(DEFAULT_PORT);
            server.start();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
