package org.academiadecodigo.codecadets.server;

import org.academiadecodigo.codecadets.prompt.GameHandler;
import org.academiadecodigo.codecadets.server.client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final String DEFAULT_NAME = "";
    private static final int MAXIMUM_CLIENTS = 2;

    private final ServerSocket serverSocket;
    private final ExecutorService service;
    private final List<ClientHandler> clients;
    private GameHandler gameHandler;
    private ClientHandler clientHandler;
    private ClientHandler clientHandler2;


    public Server(int portNumber) throws IOException {
        this.serverSocket = new ServerSocket(portNumber);
        this.service = Executors.newFixedThreadPool(MAXIMUM_CLIENTS);
        this.clients = Collections.synchronizedList(new LinkedList<>());
        this.gameHandler = new GameHandler();

    }

    /**
     *
     */
    public void start() {
        waitingForClientConnections();

        clientHandler.run();
        clientHandler2.run();

        for (int questionNumber = 0; questionNumber < gameHandler.getGameLength(); questionNumber++) {
            serverBroadcast(gameHandler.getQuestion(questionNumber));
        }
    }


    /**
     * Has a blocking method - accept(); - it will wait until a client connects to
     * the corresponded port number.
     *
     *
     * @throws IOException
     */
    public void waitingForClientConnections() {

        try {
            System.out.println("Waiting for client connections");

            Socket clientSocket = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            clientHandler = new ClientHandler(clientSocket, DEFAULT_NAME + 1 + "has connected!");
            clientHandler2 = new ClientHandler(clientSocket2, DEFAULT_NAME + 2 + "has connected!");

            service.submit(clientHandler);
            service.submit(clientHandler2);

            addClient(clientHandler);
            addClient(clientHandler2);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * @param clientHandler
     * @return
     */
    private boolean addClient(ClientHandler clientHandler) {
        synchronized (clients) {
            if (clients.size() > MAXIMUM_CLIENTS) {
                return false;
            }

            clients.add(clientHandler);
            return true;
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
                client.sendServerQuestion(serverMessage);
                //question menu logic
            }
        }
    }
}