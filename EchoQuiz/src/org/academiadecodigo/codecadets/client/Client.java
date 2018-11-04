package org.academiadecodigo.codecadets.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.codecadets.comms.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket socket;
    private Prompt prompt;
    private PrintWriter writer;
    private BufferedReader reader;
    private int questionNum = 1;

    public Client(String host, int portNumber) {
        try {
            this.socket = new Socket(host, portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.prompt = new Prompt(System.in, System.out);
    }

    public boolean init() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public void start() {
        while (!socket.isClosed()) {
            try {

                String question = readFromServer();

                if (question.isEmpty()) {
                    continue;
                }

                String[] questionArray = splitter(question);
                String[] answerIndex = {questionArray[1], questionArray[2], questionArray[3], questionArray[4]};
                buildQuestion(questionArray[0], answerIndex);

            } catch (IOException e) {
                System.err.println("Server Disconnected.");
                System.exit(0);
            }
        }
    }

    public String[] splitter(String question) {
        return question.split("&");
    }

    public void buildQuestion(String question, String[] answerArray) {

        MenuInputScanner scanner = new MenuInputScanner(answerArray);
        scanner.setMessage(question);

        int chosenAnswer = prompt.getUserInput(scanner);

        String[] query = {questionNum + "", chosenAnswer + ""};

        writer.println(Messages.sendResponse(Messages.RESP, query));

        try {
            String response = readFromServer();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        questionNum++;
    }

    private String readFromServer() throws IOException {
        String message = "";
        String result = "";

        while ((message = reader.readLine()) != null && !message.isEmpty()) {
            result += message;
        }

        if (message == null) {
            System.out.println("ByeBye");
            System.exit(0);
        }

        return result;
    }
}
