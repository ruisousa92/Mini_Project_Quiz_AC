package org.academiadecodigo.codecadets.prompt.questions;


public enum Answers {

    ANSWERS_QUESTION_ONE(4, new String[]{"Rodrigo", "Nuno", "Zé", "Refs"}),
    ANSWERS_QUESTION_TWO(2, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_THREE(3, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FOUR(2, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FIVE(1, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_SIX(4, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_SEVEN(2, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_EIGHT(4, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_NINE(1, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_TEN(2, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_ELEVEN(3, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_TWELVE(2, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_THIRTEEN(4, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FOURTEEN(1, new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FIFTEEN(2, new String[]{"answer1", "answer2", "answer3", "answer4"});

    private String[] answer;
    private int correctAnswer;

    Answers(int correctAnswer, String[] strings) {
        this.answer = strings;
        this.correctAnswer = correctAnswer;
    }

    public String[] getAnswer() {
        return answer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
