package DesignPatterns.Structural.Decorator;


// Structural
// Decorator : Bir nesnenin davranışını, alt sınıf oluşturmadan dinamik olarak değiştirmek veya genişletmek için kullanılır.
// Nesneye Dinamik olarak farklı sorumluluklar eklemeyi sağlar. Yani nesneyi çalışma zamanında değiştiririz.

public class Main {
    public static void main(String[] args) {

        String content = "\nWhat is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n" +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, \n" +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. \n" +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. \n" +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, \n" +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        DefaultReport defaultReport = new DefaultReport(content);

        String defaultText = defaultReport.getText();
        System.out.println("Default Text: "+defaultText);
        System.out.println();


        SmallReportDecorator smallReportDecorator = new SmallReportDecorator(defaultReport);

        String smallText = smallReportDecorator.getText();
        System.out.println("Small Text: "+smallText);
        System.out.println();


        SignedReportDecorator signedReportDecorator = new SignedReportDecorator(defaultReport);

        String signedText = signedReportDecorator.getText();
        System.out.println("Signed Text: "+signedText);
        System.out.println();

        LinedReportDecorator linedReportDecorator = new LinedReportDecorator(defaultReport);

        String linedText = linedReportDecorator.getText();
        System.out.println("Lined Text: "+linedText);
        System.out.println();

        signedReportDecorator = new SignedReportDecorator(linedReportDecorator);
        smallReportDecorator = new SmallReportDecorator(signedReportDecorator);

        String all = smallReportDecorator.getText();
        System.out.println("All Decorator Text: "+all);
        System.out.println();






    }
}
