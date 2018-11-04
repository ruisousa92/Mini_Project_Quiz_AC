package org.academiadecodigo.codecadets.client;

import java.io.IOException;

public class ClientLauncher {

    public static void main(String[] args) {


        try {
            Client client = new Client("localhost", 9090);
            client.init();
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
