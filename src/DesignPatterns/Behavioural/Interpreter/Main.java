package DesignPatterns.Behavioural.Interpreter;

import DesignPatterns.Behavioural.Interpreter.Interpreter.BirdLanguageInterpreter;
import DesignPatterns.Behavioural.Interpreter.Interpreter.CrowLanguageInterpreter;

public class Main {
    public static void main(String[] args) {
        String birdLanguage = "mucuhacarrecem acaslacan tücürkiciyece";  // --> Muharrem Aslan Türkiye
        BirdLanguageInterpreter birdLanguageInterpreter = new BirdLanguageInterpreter();
        String turkish = birdLanguageInterpreter.interpret(birdLanguage);
        System.out.println("Result Bird: "+turkish);

        /*

        String crowLanguage = "muguhagarregem agaslagan tügürkigiyege";  // --> Muharrem Aslan Türkiye
        CrowLanguageInterpreter crowLanguageInterpreter = new CrowLanguageInterpreter();
        String turkishCrow = crowLanguageInterpreter.interpret(crowLanguage);
        System.out.println("Result Crow: "+turkishCrow);


         */

    }
}
