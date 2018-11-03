package org.academiadecodigo.codecadets.prompt.questions;

public enum Questions {

    QUESTION_ONE(3,"Who is the Supreme Lider?&Rodrigo&Nuno&Zé&Refs"),                              
    QUESTION_TWO(2,"In Java the simbols \"<\" and \">\" represent what?&Integers&Your Mom&Arrows&Operators"),   
    QUESTION_THREE(4,"MVC stands for?&Model View Computer&Modern Viewer Controller&Model View Controller&Model Vision Controller"),                                      
    QUESTION_FOUR(1, "In AC lore, what are Tomatoes?&Fruit&Vegetable&Tubérculo&A Male body part"),                        
    QUESTION_FIVE(2,"Question five?&answer1&answer2&answer3&answer4"),                                                                                  
    QUESTION_SIX(3,"Question six?&answer1&answer2&answer3&answer4"),                                          
    QUESTION_SEVEN(4,"Question seven?&answer1&answer2&answer3&answer4"),                                      
    QUESTION_EIGHT(2,"Question?&answer1&answer2&answer3&answer4"),                                         
    QUESTION_NINE(1,"Question?&answer1&answer2&answer3&answer4"),                                            
    QUESTION_TEN(3,"Question?&answer1&answer2&answer3&answer4"),
    QUESTION_ELEVEN(2, "Question?&answer1&answer2&answer3&answer4"),
    QUESTION_TWELVE(2, "Question?&answer1&answer2&answer3&answer4"),
    QUESTION_THIRTEEN(3,"Question?&answer1&answer2&answer3&answer4"),
    QUESTION_FOURTEEN(4, "Question?&answer1&answer2&answer3&answer4"),
    QUESTION_FIFTEEN(1, "Question?&answer1&answer2&answer3&answer4");


    private String message;
    private int correctAnswer;

    Questions(int correctAnswer,String question) {
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
