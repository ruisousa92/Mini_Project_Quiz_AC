package org.academiadecodigo.codecadets.prompt.questions;

public enum Questions {

    QUESTION_ONE("Question one ?"),
    QUESTION_TWO("Question two?"),
    QUESTION_THREE("Question three?"),
    QUESTION_FOUR("Question four?"),
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
    QUESTION_FIFTHEEN("Question?");

    private String message;

    Questions(String question) {
        this.message = question;
    }


    public String getMessage() {
        return message;
    }

}
