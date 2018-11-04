package org.academiadecodigo.codecadets.questions;

public enum Questions {

    QUESTION_ONE(4, "Who is the Supreme Leader?&Rodrigo&Nuno&Zé&Refs"),
    QUESTION_TWO(4, "In Java the symbols \"<\" and \">\" represent what?&Integers&Your Mom&Arrows&Operators"),
    QUESTION_THREE(3, "MVC stands for?&Model View Computer&Modern Viewer Controller&Model View Controller&Model Vision Controller"),
    QUESTION_FOUR(3, "In AC lore, what are Tomatoes?&Fruit&Vegetable&Tubérculo&A Male body part"),
    QUESTION_FIVE(2, "Who created Java?&Rui Ferrão&James Gosling&Roberto Pires&Jon Postel"),
    QUESTION_SIX(1, "What was Java's first name?&Oak&Oracle&Apple&Windows"),
    QUESTION_SEVEN(3, "Primitive variables are stored where?&Constructor&Stack&Cache&CPU"),
    QUESTION_EIGHT(1, "Which team is the best?&ECHO&is&the&best"),
    QUESTION_NINE(4, "What is the only way to skip a lecture?&Losing an arm&Blow a tire in your car&Getting shot&Runny nose"),
    QUESTION_TEN(1, "What is an immutable object?&An object that can not be changed once its created&A Mutant Object&A non-Mutant Object&A Normal person"),
    QUESTION_ELEVEN(2, "Who is the jumpy drunk of AC?&Strings&João Enes&Jesus&Rudy"),
    QUESTION_TWELVE(2, "Which member of AC received \"Pé de ladrão\" from a police officer?&Ruben Maia&Brigas Pantufas&Rudy&Jorge"),
    QUESTION_THIRTEEN(4, "Which Master coder is the best one?&Praise&Master&Coder&Jorge"),
    QUESTION_FOURTEEN(2, "What is the best place to check Documentation?&JavaDocs&StackOverFlow&Roberto&Master Coders"),
    QUESTION_FIFTEEN(3, "What is the ?&Garbage && 13 & 5 6");

    private String message;
    private int correctAnswer;

    Questions(int correctAnswer, String question) {
        this.message = question;
        this.correctAnswer = correctAnswer;
    }

    public String getMessage() {
        return message;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
