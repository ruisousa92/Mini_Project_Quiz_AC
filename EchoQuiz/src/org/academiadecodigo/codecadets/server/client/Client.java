package org.academiadecodigo.codecadets.server.client;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private int score;



    public Client(String host, int portNumber) throws IOException {
        this.socket = new Socket(host, portNumber);
        this.score = 0;
    }


    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
