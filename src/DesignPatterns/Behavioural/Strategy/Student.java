package DesignPatterns.Behavioural.Strategy;

public class Student {

    PROGRAMS_TYPES PROGRAMS_TYPES;
    ExamStrategy EXAM_STRATEGY;

    public Student(PROGRAMS_TYPES programsTypes) {
        this.PROGRAMS_TYPES = programsTypes;


        switch (programsTypes) {
            case LINGUISTIC -> EXAM_STRATEGY = new LinguisticStrategy();
            case SCIENCE_TRACK -> EXAM_STRATEGY = new ScienceTrackStrategy();
            case EQUAL_WEIGHTED -> EXAM_STRATEGY = new EqualWeightStrategy();
            default -> throw new IllegalArgumentException("Program Types cannot be null");
        }
    }

    public String getPriority(){
        System.out.println("Strategy for "+this.PROGRAMS_TYPES +":");
        String priortiy = "First, solve " + this.EXAM_STRATEGY.getFirstStrategy() + ". Then, solve " + this.EXAM_STRATEGY.getSecondStrategy() +
                ". After that, solve " + this.EXAM_STRATEGY.getThirdStrategy() +
                ". Finally, if you have time left, solve " + this.EXAM_STRATEGY.getFourthStrategy() + "."
                ;
        return priortiy;
    }
}
