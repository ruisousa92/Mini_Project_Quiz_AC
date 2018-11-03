package org.academiadecodigo.codecadets.server.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private Socket socket;
    private int score;
    private BufferedReader reader;
    private MenuInputScanner scanner;
    private Prompt prompt;


    public Client(String host, int portNumber) throws IOException {
        this.socket = new Socket(host, portNumber);
        this.prompt = new Prompt(System.in, System.out);
        this.score = 0;

    }

    public void start() {

        synchronized (this) {
            while (!socket.isClosed()) {

                try {
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String question = reader.readLine();
                    String[] questionArray = splitter(question);
                    String[] answerIndex = {questionArray[1], questionArray[2], questionArray[3], questionArray[4]};
                    buildQuestion(questionArray[0], answerIndex);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public String[] splitter(String question) {
        return question.split("&");
    }

    public void buildQuestion(String question, String[] answerArray) {

        scanner = new MenuInputScanner(answerArray);
        scanner.setMessage(question);
        prompt.getUserInput(scanner);

    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
