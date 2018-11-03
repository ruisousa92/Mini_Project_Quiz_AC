package org.academiadecodigo.codecadets.server;

import org.academiadecodigo.codecadets.prompt.GameHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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


    public Server(int portNumber) throws IOException {
        this.serverSocket = new ServerSocket(portNumber);
        this.service = Executors.newFixedThreadPool(MAXIMUM_CLIENTS);
        this.clients = Collections.synchronizedList(new LinkedList<>());
        this.gameHandler = new GameHandler(serverSocket);

    }

    /**
     *
     */
    public void start() {

        int openedConnections = 0;

        while (openedConnections < 2) {
            waitingForClientConnections(openedConnections);
            openedConnections++;
        }

        gameHandler.start();

    }


    /**
     * Has a blocking method - accept(); - it will wait until a client connects to
     * the corresponded port number.
     *
     * @param connections
     * @throws IOException
     */
    public void waitingForClientConnections(int connections) {

        try {
            System.out.println("Waiting for client connections");
            Socket clientSocket = serverSocket.accept();

            ClientHandler connection = new ClientHandler(clientSocket, DEFAULT_NAME + connections + "has connected!");
            service.submit(connection);

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

            //serverBroadcast();
            //questionServerBroadcast(); --> buildQuestion
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
                client.sendServerMessage(serverMessage);
                //question menu logic
            }
        }
    }


    /**
     * Inner class of Client Handler
     * handles and distributes sockets to a client/user each time they connect
     */
    public class ClientHandler implements Runnable {
        private Socket socket;
        private String name;
        private PrintWriter outputWriter;
        private BufferedReader inputReader;

        ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }


        @Override
        public void run() {

            openIOStreams();
            sendServerMessage(Messages.WELCOME);


            if (!Server.this.addClient(this)) {
                sendServerMessage(Messages.WELCOME);
                closeSocket();
            }
            while (!socket.isClosed()) {
                listenForInput();
            }
        }

        public void listenForInput() {
            String message;
            try {
                message = inputReader.readLine();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        private void openIOStreams() {

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

        private void sendServerMessage(String message) {

            outputWriter.println(message);
        }
    }
}