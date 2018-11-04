package org.academiadecodigo.codecadets.server;

import org.academiadecodigo.codecadets.questions.Questions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final String DEFAULT_NAME = "Code Cadet";
    private static final int MAXIMUM_CLIENTS = 2;
    private final ServerSocket serverSocket;
    private final ExecutorService service;
    private final List<ClientHandler> clients;
    private ClientHandler clientHandler;
    private ClientHandler clientHandler2;

    public Server(int portNumber) throws IOException {
        this.serverSocket = new ServerSocket(portNumber);
        this.service = Executors.newFixedThreadPool(MAXIMUM_CLIENTS);
        this.clients = Collections.synchronizedList(new LinkedList<>());
    }

    public void start() {

        waitingForClientConnections();

        for (int questionNumber = 0; questionNumber < getGameLength(); questionNumber++) {
            playRound(questionNumber);
        }
        clientHandler.sendScore(clientHandler, clientHandler2);
    }

    /**
     * Method to play one question at a time.
     *
     * @param questionNumber number of the question
     */
    public void playRound(int questionNumber) {

        serverBroadcast(getQuestion(questionNumber));

        while (!clientHandler.isPlayed() || !clientHandler2.isPlayed()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        clientHandler2.setPlayed(false);
        clientHandler.setPlayed(false);
    }

    /**
     * Has a blocking method - accept(); - it will wait until a client connects to
     * the corresponded port number.
     *
     * @throws IOException
     */
    public void waitingForClientConnections() {

        try {
            System.out.println("Waiting for client connections");


            Socket clientSocket = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            clientHandler = new ClientHandler(clientSocket);
            clientHandler2 = new ClientHandler(clientSocket2);

            clientHandler.openIOStreams();
            clientHandler2.openIOStreams();

            addClient(clientHandler);
            addClient(clientHandler2);

            service.submit(clientHandler);
            service.submit(clientHandler2);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * @param clientHandler
     * @return
     */
    private void addClient(ClientHandler clientHandler) {
        synchronized (clients) {
            if (clients.size() > MAXIMUM_CLIENTS) {
                return;
            }
            clients.add(clientHandler);
        }
    }

    /**
     * Method to send questions-menu for the Clients
     *
     * @param serverMessage
     */
    public void serverBroadcast(String serverMessage) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                client.sendToClient(serverMessage + "\n");
            }
        }
    }

    /**
     * @return
     */
    public int getGameLength() {
        return Questions.values().length;
    }

    public String getQuestion(int question) {
        return Questions.values()[question].getMessage();
    }
}