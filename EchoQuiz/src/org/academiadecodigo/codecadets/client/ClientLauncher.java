package org.academiadecodigo.codecadets.client;

public class ClientLauncher {

    public static void main(String[] args) {

        Client client = new Client("localhost", 9090);
        client.init();
        client.start();
    }
}
