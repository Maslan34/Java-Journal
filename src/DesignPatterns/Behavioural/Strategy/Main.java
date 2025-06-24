package DesignPatterns.Behavioural.Strategy;


// Bu örnekte bir öğrencinin ait olduğu bölüme göre önceliklendirmesi gereken sınavlar için
// strategy design pattern kullanılmıştır.


// Behavioural
// Strategy :Bir algoritmayı, işlemi ya da davranışı çalışma zamanında (runtime)
// seçilebilir hale getirmek için kullanılır.

// Avantajları
// Kodun esnekliğini artırır.
// if-else ya da switch-case kullanımını azaltır.
// Open/Closed Principle (Açık/Kapalı Prensibi)’ne uygundur:


public class Main {
    public static void main(String[] args) {

        Student student = new Student(PROGRAMS_TYPES.LINGUISTIC);
        Student student2 = new Student(PROGRAMS_TYPES.EQUAL_WEIGHTED);
        Student student3 = new Student(PROGRAMS_TYPES.SCIENCE_TRACK);

        String stundetPriortiy = student.getPriority();
        System.out.println(stundetPriortiy);
        String stundetPriortiy2 = student2.getPriority();
        System.out.println(stundetPriortiy2);
        String stundetPriortiy3 = student3.getPriority();
        System.out.println(stundetPriortiy3);


    }
}
