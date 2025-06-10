package DesignPatterns.Behavioural.Iterator;

import java.util.Iterator;

public class QuestionIterator implements Iterator<Question> {

    private Question[] questions;
    private int index=0;


    public QuestionIterator(Question[] questions) {
        this.questions = questions;
    }

    @Override
    public boolean hasNext() {
        if(index<questions.length)
            return true;
        return false;
    }

    @Override
    public Question next() {
       Question question = questions[index];
       index++;
       return question;
    }
}
