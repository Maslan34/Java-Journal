package DesignPatterns.Behavioural.Iterator;

import java.util.Iterator;



// Behavioural
// Iterator : bir koleksiyonun (dizi, liste vb.) elemanları üzerinde koleksiyonun
// iç yapısını bilmeden gezinmeyi (iterate etmeyi) sağlayan bir davranışsal (behavioral) tasarım desenidir.
// Birden fazla farklı veri yapısını aynı şekilde gezebilmek için (örneğin List, Array, Set).
// Örneğin Mesala bir liste türünde car objelerin var ve int tipinde bir array türünde verilerin var
// bu iki birbirinden alakasız veri tipinde tek seferde dolaşmak için kullanılabilir.
// Veya iterate etme yöntemini değiştirmek için Örneğin sadece Baş harfi M ile başlayan stringler arasında dolaşmak için.


public class Main {
    public static void main(String[] args) {
        /* Before Iterator
        Book mathBook = new Book("Math Book");

        List<Question> mathBookQuesiton = mathBook.getQuestionList();

        for (Question question : mathBookQuesiton) {
            System.out.println("Question No: "+question.getQuestionNo());
        }

        Fascicule chemistryFascicule = new Fascicule("Chemistry Fascicule");
        Question[] fasciculeQuestions = chemistryFascicule.getQuestions();

        for (Question question : fasciculeQuestions) {
            System.out.println("Question No: "+question.getQuestionNo());
        }

         */

        Book mathBook = new Book("Math Book");

        Iterator<Question> mathBookQuesiton = mathBook.getQuestionList();


        Fascicule chemistryFascicule = new Fascicule("Chemistry Fascicule");
        QuestionIterator fasciculeQuestions = chemistryFascicule.getQuestions();

        /* These two methods that doing same thing extracted as printQuestions Function
        while (mathBookQuesiton.hasNext()) {
            Question question = (Question) mathBookQuesiton.next();
            System.out.println("Question No: "+question.getQuestionNo());
        }

        while (fasciculeQuestions.hasNext()) {
            Question question = (Question) fasciculeQuestions.next();
            System.out.println("Question No: "+question.getQuestionNo());
        }

        */
        System.out.println("\n\n--------------------------------");

        printQuestions(mathBookQuesiton);
        printQuestions(fasciculeQuestions);


    }

    public static void printQuestions(Iterator<Question> iterator) {
        while (iterator.hasNext()) {
            Question question = iterator.next();
            System.out.println("Question No: " + question.getQuestionNo());
        }
    }
}
