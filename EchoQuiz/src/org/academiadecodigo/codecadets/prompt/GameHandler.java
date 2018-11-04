package org.academiadecodigo.codecadets.prompt;

import org.academiadecodigo.codecadets.quiz.Questions;

import java.util.Map;
import java.util.TreeMap;

public class GameHandler {

    private Map<String, Integer> stringMap;

    public void verifyAnswer() {

        System.out.println("Welcome to who wants to be programmater!!");

        for (int questionNumber = 0; questionNumber < Questions.values().length; questionNumber++) {
            mapComposition(questionNumber);

            /*if (userInput == stringMap.get(Questions.values()[questionNumber].getMessage())) {
                System.out.println("Your answer is Correct!");
                client.incrementScore();
                continue;

            }
            System.out.println("Wrong answer!");*/
        }
    }

    public int getGameLength() {
        return Questions.values().length;
    }

    public String getQuestion(int question) {
        return Questions.values()[question].getMessage();
    }


    private void mapComposition(int questionNumber) {

        stringMap = new TreeMap<>();

        for (int mapPosition = questionNumber; mapPosition < Questions.values().length; mapPosition++) {
            stringMap.put(Questions.values()[mapPosition].getMessage(), Questions.values()[mapPosition].getCorrectAnswer());
        }
    }

}
