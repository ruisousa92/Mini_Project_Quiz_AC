package org.academiadecodigo.codecadets.prompt.questions;


public enum Answers {

    ANSWERS_QUESTION_ONE(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_TWO(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_THREE(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FOUR(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FIVE(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_SIX(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_SEVEN(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_EIGHT(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_NINE(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_TEN(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_ELEVEN(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_TWELVE(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_THIRTEEN(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FOURTEEN(new String[]{"answer1", "answer2", "answer3", "answer4"}),
    ANSWERS_QUESTION_FIFTHEEN(new String[]{"answer1", "answer2", "answer3", "answer4"});

    private String[] answer;

    Answers(String[] strings) {
        this.answer = strings;
    }

    public String[] getAnswer() {
        return answer;
    }
}
