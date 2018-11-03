package org.academiadecodigo.codecadets.tester;

import org.academiadecodigo.codecadets.prompt.GameHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService service;
    private Queue<ClientHandler> listOfclients;


    public void init() {
        try {
            System.out.print("PORT: ");
            serverSocket = new ServerSocket(scanner());
            service = Executors.newCachedThreadPool();
            listOfclients = new LinkedList<>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {

            try {

                clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                newClient(clientHandler);
                listOfclients.add(clientHandler);

                if(listOfclients.size() >= 2 ){
                    startGame(listOfclients.poll(), listOfclients.poll());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startGame(ClientHandler clientHandler1, ClientHandler clientHandler2){
        service.submit(new Runnable() {
            @Override
            public void run() {
                new GameHandler2(clientHandler1, clientHandler2).run();
            }
        });
    }


    public void newClient(ClientHandler clientHandler) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                clientHandler.run();
            }
        });
    }


    public int scanner() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
        server.run();
    }

}
