package org.academiadecodigo.codecadets.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class ClientLauncher {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in,System.out);

        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Please enter your server address: ");
        String address = prompt.getUserInput(stringInputScanner);

        IntegerInputScanner integerInputScanner = new IntegerInputScanner();
        integerInputScanner.setMessage("Please enter your port number: ");
        int portNumber = prompt.getUserInput(integerInputScanner);

        Client client = new Client(address, portNumber);
        client.init();
        client.start();
    }
}
