package org.academiadecodigo.codecadets.prompt.questions;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractQuestion implements Question {

    private Prompt prompt;

    public AbstractQuestion(Prompt prompt) {
        this.prompt = new Prompt(System.in, System.out);
    }




}
