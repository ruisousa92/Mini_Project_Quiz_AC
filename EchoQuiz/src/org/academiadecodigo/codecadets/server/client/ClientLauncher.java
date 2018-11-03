package org.academiadecodigo.codecadets.server.client;

import java.io.IOException;

public class ClientLauncher {

    public static void main(String[] args) {


        try {
            Client client = new Client("localhost", 9090);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
