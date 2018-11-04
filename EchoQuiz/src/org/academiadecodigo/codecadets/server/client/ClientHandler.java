package org.academiadecodigo.codecadets.server.client;

import org.academiadecodigo.codecadets.client.Client;
import org.academiadecodigo.codecadets.comms.Messages;
import org.academiadecodigo.codecadets.quiz.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    //Socket
    private Socket socket;

    //Streams
    private PrintWriter outputWriter;
    private BufferedReader inputReader;

    //Others
    private String name;
    private int score;
    private boolean played;

    public ClientHandler(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        this.score = 0;
        this.played = false;
    }

    @Override
    public void run() {
        try {

            for (int i = 0; i < Questions.values().length; i++) {
                messageHandle(inputReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void messageHandle(String message) {
        String[] messageParts = message.split(" ");

        if (messageParts.length != 3) {
            return;
        }

        int questionNumber = Integer.parseInt(messageParts[1]);
        int chosenAnswer = Integer.parseInt(messageParts[2]);
        played = true;

        Questions question = Questions.values()[questionNumber-1];

        if (question.getCorrectAnswer() == chosenAnswer) {
            incrementScore();

            outputWriter.println(Messages.sendResponse(Messages.CORRECT, null));
            return;
        }

        outputWriter.println(Messages.sendResponse(Messages.WRONG, null));

    }

    private void incrementScore() {
        this.score++;
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

    public int getScore() {
        return score;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public boolean isPlayed() {
        return played;
    }
}

