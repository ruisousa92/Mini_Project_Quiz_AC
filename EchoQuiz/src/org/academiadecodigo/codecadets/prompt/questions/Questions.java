package org.academiadecodigo.codecadets.prompt.questions;

public enum Questions {

    QUESTION_ONE("Who is the Supreme Lider?"),
    QUESTION_TWO("In Java the simbols \"<\" and \">\" represent what? "),
    QUESTION_THREE("MVC stands for?"),
    QUESTION_FOUR("In AC lore, what are Tomatoes?"),
    QUESTION_FIVE("Question five?"),
    QUESTION_SIX("Question six?"),
    QUESTION_SEVEN("Question seven?"),
    QUESTION_EIGHT("Question?"),
    QUESTION_NINE("Question?"),
    QUESTION_TEN("Question?"),
    QUESTION_ELEVEN("Question?"),
    QUESTION_TWELVE("Question?"),
    QUESTION_THIRTEEN("Question?"),
    QUESTION_FOURTEEN("Question?"),
    QUESTION_FIFTEEN("Question?");


    private String message;

    Questions(String question) {
        this.message = question;
    }


    public String getMessage() {
        return message;
    }

}
