package Generics;

import CapstoneProjects.SalaryCalculator.Employee;

public class Main {
    public static void main(String[] args) {

        String value1 = "value1";
        int value2 = 0;
        double value3 = 0.0;
        Generic generic = new Generic(value1);
        Generic generic2 = new Generic(value2);
        Generic generic3 = new Generic(value3);
        Employee employee =new Employee("muharrem",10.0f,5,2000);

        // X  Generic<Integer> generic4 = new Generic<Integer>(value1);

        Generic<Integer> generic4 = new Generic(value1);

        System.out.println(generic.getValue());
        System.out.println(generic2.getValue());
        System.out.println(generic3.getValue());
        System.out.println(generic4.getValue());


        MultipleGeneric<Employee, Double, Integer> multipleGeneric = new MultipleGeneric<Employee, Double, Integer>(employee, value3, value2);
        System.out.println();
        multipleGeneric.ShowInfo();
        MultipleGeneric<String, Double, Integer> multipleGeneric2 = new MultipleGeneric<String, Double, Integer>(value1, value3, value2);
        multipleGeneric2.ShowInfo();

        String [] strArr = {"Muharrem","Aslan","Türkiye"};
        Integer [] intArr = {1,2,3};
        Character [] charArr = {'J','A','V','A'};

        MultipleGeneric<String[], Integer[], Character[]> multipleGeneric3 = new MultipleGeneric<String[], Integer[], Character[]>(strArr, intArr, charArr);

        MultipleGeneric.iterateGenerics(multipleGeneric3);


        MultipleGeneric<String[], Integer[], Character[]> multipleGeneric4 = new MultipleGeneric<String[], Integer[], Character[]>(strArr, intArr, charArr);

        multipleGeneric4.iterateGenericsWithoutClassObject(strArr, intArr, charArr);

    }
}
