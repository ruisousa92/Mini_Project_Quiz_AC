package org.academiadecodigo.codecadets.prompt;

import org.academiadecodigo.codecadets.prompt.questions.QuestionHandler;

public class App {

    public static void main(String[] args) {
        QuestionHandler questionHandler = new QuestionHandler();
        PrompView prompView = new PrompView(questionHandler);

       prompView.start();
    }
}
