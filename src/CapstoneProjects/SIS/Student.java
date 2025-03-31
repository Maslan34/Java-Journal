package CapstoneProjects.SIS;

public class Student {
    String name, stuNo;
    int classes;
    int mathVerbal;
    int physicsVerbal;
    int chemistryVerbal;
    Course math;
    Course physics;
    Course chemistry;
    double average;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course math, Course physics, Course chemistry) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calcAverage();
        this.isPass = false;
        this.mathVerbal = 0;
        this.physicsVerbal = 0;
        this.chemistryVerbal = 0;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya, int mathVerbal, int physicsVerbal, int chemistryVerbal) {

        if ((mat >= 0 && mat <= 100) && (mathVerbal >= 0 && mathVerbal <= 100)) {
            this.math.note = mat;
            this.mathVerbal = mathVerbal;
        }

        if ((fizik >= 0 && fizik <= 100) && (physicsVerbal >= 0 && physicsVerbal <= 100)) {
            this.physics.note = fizik;
            this.physicsVerbal = physicsVerbal;
        }

        if ((kimya >= 0 && kimya <= 100) && chemistryVerbal >= 0 && chemistryVerbal <= 100) {
            this.chemistry.note = kimya;
            this.chemistryVerbal = chemistryVerbal;
        }

    }

    public void isPass() {
        if ((this.math.note == 0 && this.mathVerbal == 0) ||
                (this.physics.note == 0 && this.physicsVerbal == 0) ||
                (this.chemistry.note == 0 && this.chemistryVerbal == 0)) {
            System.out.println("Grades have not been fully entered.");

        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average: " + this.average);
            if (this.isPass) {
                System.out.println("Passed the class.");
            } else {
                System.out.println("Failed the class.");
            }
        }
    }

    private double calculateWeightedAverage(double note, double verbalNote, double verbalRate) {
        return ((note * (100.0 - verbalRate)) + (verbalNote * verbalRate)) / 100.0;
    }

    public void calcAverage() {
        if (this.physics == null || this.chemistry == null || this.math == null) {
            System.out.println("There are some missing grades!");
            return;
        }
        this.average = (
                calculateWeightedAverage(this.physics.note, this.physicsVerbal, this.physics.verbalRate) +
                        calculateWeightedAverage(this.chemistry.note, this.chemistryVerbal, this.chemistry.verbalRate) +
                        calculateWeightedAverage(this.math.note, this.mathVerbal, this.math.verbalRate)
        ) / 3.0;

    }

    public boolean isCheckPass() {
        calcAverage();
        return this.average > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Student: " + this.name);
        System.out.println("Mathematics - Exam: " + this.math.note + " | Verbal: " + this.mathVerbal);
        System.out.println("Physics - Exam: " + this.physics.note + " | Verbal: " + this.physicsVerbal);
        System.out.println("Chemistry - Exam: " + this.chemistry.note + " | Verbal: " + this.chemistryVerbal);
    }


}
