package DesignPatterns.Behavioural.Strategy;

public interface ExamStrategy {

    LESSONS_TYPES getFirstStrategy();
    LESSONS_TYPES getSecondStrategy();
    LESSONS_TYPES getThirdStrategy();
    LESSONS_TYPES getFourthStrategy();
}
