package DesignPatterns.Behavioural.Strategy;

public enum LESSONS_TYPES {
    TURKISH("TURKISH"),
    MATH("MATH"),
    SCIENCE("SCIENCE"),
    SOCIAL("SOCIAL");

    private String lessonName;

    LESSONS_TYPES(String lessonName) {
        this.lessonName = lessonName;
    }


    @Override
    public String toString() {
        return lessonName;
    }
}

