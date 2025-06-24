package DesignPatterns.Behavioural.Strategy;

public enum PROGRAMS_TYPES {


    LINGUISTIC("LINGUISTIC"),
    EQUAL_WEIGHTED("EQUAL WEIGHTED"),
    SCIENCE_TRACK("SCIENCE TRACK");


    private String programName;
    PROGRAMS_TYPES(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return programName;
    }
}
