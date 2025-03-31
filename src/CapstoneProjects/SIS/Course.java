package CapstoneProjects.SIS;

public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int note;
    int verbalRate;

    public Course(String name, String code, String prefix,int verbalRate) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
        this.verbalRate = verbalRate;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("Operation Success!");
        } else {
            System.out.println(t.name + " academician cannot teach this course.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println("Academician of the course " + this.name + " : " + courseTeacher.name);
        } else {
            System.out.println("No academician has been assigned to the course " + this.name + ".");
        }
    }
}
