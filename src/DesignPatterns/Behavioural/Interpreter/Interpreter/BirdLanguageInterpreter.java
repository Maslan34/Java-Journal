package DesignPatterns.Behavioural.Interpreter.Interpreter;

import DesignPatterns.Behavioural.Interpreter.Languages.BirdLanguage;

public class BirdLanguageInterpreter implements Interpreter{
    @Override
    public String interpret(String sentence) {
        BirdLanguage birdLanguage = new BirdLanguage();
        String conversion=birdLanguage.translate(sentence);
        return conversion;
    }
}
