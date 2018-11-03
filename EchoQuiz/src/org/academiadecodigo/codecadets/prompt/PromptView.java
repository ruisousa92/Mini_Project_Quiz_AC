package org.academiadecodigo.codecadets.prompt;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.codecadets.prompt.questions.Answers;
import org.academiadecodigo.codecadets.prompt.questions.Questions;
import org.academiadecodigo.codecadets.server.client.Client;

import java.util.Map;
import java.util.TreeMap;

public class PromptView {

    private Prompt prompt = new Prompt(System.in, System.out);
    private Map<String, Integer> stringMap;
    private Client client;


    public void start() {

        System.out.println("Welcome to who wants to be programmater!!");

        for (int questionNumber = 0; questionNumber < Questions.values().length; questionNumber++) {
            int userInput = buildQuestion(questionNumber);

            if (userInput == stringMap.get(Questions.values()[questionNumber].getMessage())) {
                System.out.println("acertei");
                client.incrementScore();
                continue;

            }
            System.out.println("you stupid!");
        }
    }


    public int buildQuestion(int questionNumber) {

        MenuInputScanner menuInputScanner = new MenuInputScanner(Answers.values()[questionNumber].getAnswer());
        menuInputScanner.setMessage(Questions.values()[questionNumber].getMessage());
        int userInput = prompt.getUserInput(menuInputScanner);
        mapComposition(questionNumber);
        return userInput;
    }

    private void mapComposition(int questionNumber) {

        stringMap = new TreeMap<>();

        for (int mapPosition = questionNumber; mapPosition < Questions.values().length; mapPosition++) {
            stringMap.put(Questions.values()[mapPosition].getMessage(), Answers.values()[mapPosition].getCorrectAnswer());
        }
    }
}
