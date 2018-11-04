package org.academiadecodigo.codecadets.server;

import org.academiadecodigo.codecadets.communication.Messages;
import org.academiadecodigo.codecadets.questions.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter outputWriter;
    private BufferedReader inputReader;
    private int score;
    private boolean played;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.score = 0;
        this.played = false;
    }

    @Override
    public void run() {

        try {
            //TODO: fix this "*2"
            for (int i = 0; i < Questions.values().length * 2; i++) {
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
        Questions question = Questions.values()[questionNumber - 1];

        if (question.getCorrectAnswer() == chosenAnswer) {
            incrementScore();
            outputWriter.println("Your score is: " + getScore() + " and the answer is: ");
            outputWriter.println(Messages.sendResponse(Messages.CORRECT, null));

            return;
        }
        outputWriter.println("Your score is: " + getScore() + " and the answer is: ");
        outputWriter.println(Messages.sendResponse(Messages.WRONG, null));
    }

    public void sendScore(ClientHandler clientHandler, ClientHandler clientHandler2) {

        if (clientHandler.getScore() == clientHandler2.getScore()) {
            clientHandler.outputWriter.println("It's a TIE!");
            clientHandler2.outputWriter.println("It's a TIE!");
            return;
        }

        if (clientHandler.getScore() > clientHandler2.getScore()) {
            clientHandler.outputWriter.println("You WIN with the score of: " + clientHandler.getScore());
            clientHandler2.outputWriter.println("You LOSE with the score of: " + clientHandler.getScore());
            return;
        }
        clientHandler.outputWriter.println("You LOSE with the score of: " + clientHandler.getScore());
        clientHandler2.outputWriter.println("You WIN with the score of: " + clientHandler2.getScore());
    }

    public void openIOStreams() {

        try {
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void sendToClient(String message) {
        outputWriter.println(message);
    }

    private void incrementScore() {
        this.score++;
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

