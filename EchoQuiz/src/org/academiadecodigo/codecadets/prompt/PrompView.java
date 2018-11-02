package org.academiadecodigo.codecadets.prompt;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.codecadets.prompt.questions.Answers;
import org.academiadecodigo.codecadets.prompt.questions.QuestionHandler;
import org.academiadecodigo.codecadets.prompt.questions.Questions;

import java.util.Map;

public class PrompView {

    private Prompt prompt = new Prompt(System.in, System.out);
    private Map<String, String[]> stringMap;
    private QuestionHandler questionHandler;

    public PrompView(QuestionHandler questionHandler) {
        this.questionHandler = questionHandler;
    }

    public void start() {

        System.out.println("Welcome to who wants to be programmater!!");

        buildQuestion(questionHandler.chooseQuestion());
    }


    public int buildQuestion(int questionNumber) {

        MenuInputScanner menuInputScanner = new MenuInputScanner(Answers.values()[questionNumber].getAnswer());
        menuInputScanner.setMessage(Questions.values()[questionNumber].getMessage());
        int userInput = prompt.getUserInput(menuInputScanner);
        return userInput;
    }
}
