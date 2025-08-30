package DesignPatterns.Behavioural.Interpreter.Interpreter;

import DesignPatterns.Behavioural.Interpreter.Languages.CrowLanguage;

public class CrowLanguageInterpreter implements Interpreter{
    @Override
    public String interpret(String sentence) {
        CrowLanguage crowLanguage = new CrowLanguage();
        String turkish = crowLanguage.translate(sentence);
        return turkish;
    }
}
