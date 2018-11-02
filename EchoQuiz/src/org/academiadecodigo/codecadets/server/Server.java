package org.academiadecodigo.codecadets.server;

import java.io.BufferedReader;
import java.io.IOException;
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
    private static final int MAXIMUM_CLIENT = 2;

    private final ServerSocket serverSocket;
    private final ExecutorService service;
    private final List<ClientHandler> clients;

    public Server(int portNumber) throws IOException {
        this.serverSocket = new ServerSocket(portNumber);
        this.service = Executors.newCachedThreadPool();
        this.clients = Collections.synchronizedList(new LinkedList<>());
    }

    /**
     *
     */
    public void start() {

        int openedConnections = 0;

        try {
            while (!serverSocket.isClosed()) {
                waitingForClientConnections(openedConnections);
                openedConnections++;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Has a blocking method - accept(); - it will wait until a client connects to
     * the corresponded port number.
     * @param connections
     * @throws IOException
     */
    public void waitingForClientConnections(int connections) throws IOException {

        try {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Waiting for client connections");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    /**
     * Inner class of Client Handler
     * handles and distributes sockets to a client/user each time they connect
     */
    public class ClientHandler implements Runnable {
        private Socket socket;
        private String name;
        private PrintWriter printWriter;
        private BufferedReader inputReader;

        ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }


        @Override
        public void run() {

        }
    }
}