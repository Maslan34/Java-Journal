package DesignPatterns.Behavioural.Command;

import DesignPatterns.Behavioural.Command.BadExample.Calculator;



// Behavioural
// Command : Bu desen, bir işlemi (komutu) nesneye çevirerek,
// bu işlemi sıralama, kuyruklama, geri alma (undo) veya tekrar yapma (redo) gibi işlemleri gerçekleştirmeye olanak tanır.
// Bu desen özellikle isteklerin (komutların) nesneleştirilmesini ve bu komutların bağımsız şekilde taşınmasını, saklanmasını ve yürütülmesini sağlar.
// Gevşek bağlı (loose coupling) bir yapı sunar.Komutları dinamik olarak değiştirebilirsin.

public class Main {
    public static void main(String[] args) {
        System.out.println("Bad Example");
        int result;
        result = Calculator.calculate(OperatorKind.SUM, 2, 2);
        System.out.println(result);
        result = Calculator.calculate(OperatorKind.SUBSTRCUTION, 12, 2);
        System.out.println(result);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Best Practice");
        Calculator2 calc = new Calculator2();
        result = calc.calc(new SumCommand(),2,2);
        System.out.println(result);
        result = calc.calc(new SubstractionCommand(),12,2);
        System.out.println(result);
    }
}
