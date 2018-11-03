package org.academiadecodigo.codecadets.tester;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class GameHandler2 {

    private ClientHandler clientHandler1;
    private ClientHandler clientHandler2;

    public GameHandler2(ClientHandler clientHandler1, ClientHandler clientHandler2){
        this.clientHandler1 = clientHandler1;
        this.clientHandler2 = clientHandler2;
    }

    public void run(){
        clientHandler2.sendMessage(ClientResponse.START.toString());
        clientHandler1.sendMessage(ClientResponse.START.toString());


    }

    private void iniGame(){

        for (int i = 0; i < 15; i++) {
            clientHandler1.sendMessage("Qual é a cor?, vermelho, laranja, cor de rosa, azul");


            //while ()
        }
    }


    private void teste(){
        String teste = "Qual é a cor?,vermelho,laranja,cor de rosa,azul";

        String[] teste2 = teste.split(",");
        String[] teste4 = {teste2[1], teste2[2], teste2[3], teste2[4]};

        MenuInputScanner menu = new MenuInputScanner(teste4);
        menu.setMessage(teste2[0]);

    }
}
