package DesignPatterns.Behavioural.Strategy;

public class EqualWeightStrategy implements ExamStrategy {
    @Override
    public LESSONS_TYPES getFirstStrategy() {
        return LESSONS_TYPES.TURKISH;
    }

    @Override
    public LESSONS_TYPES getSecondStrategy() {
        return LESSONS_TYPES.MATH;
    }

    @Override
    public LESSONS_TYPES getThirdStrategy() {
        return LESSONS_TYPES.SOCIAL;
    }

    @Override
    public LESSONS_TYPES getFourthStrategy() {
        return LESSONS_TYPES.SCIENCE;
    }
}
