package org.academiadecodigo.codecadets.communication;

public enum Welcome {

    WELCOME_MENU("WELCOME TO ECHO QUIZ GAME!!");

    private String message;

    Welcome(String message) {
        this.message =message;
    }

    public String getMessage() {
        return message;
    }
}
