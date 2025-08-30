package DesignPatterns.Behavioural.Interpreter.Languages;

public enum ENUM_LANGUAGE {
    BIRD("BIRD","ca"),
    CROW("CROW","ga");


    String language;
    String adjunct;

    ENUM_LANGUAGE(String language, String adjunct) {
        this.language = language;
        this.adjunct = adjunct;
    }

    public String getAdjunct() {
        return adjunct;
    }

    public String getLanguage() {
        return language;
    }
}
