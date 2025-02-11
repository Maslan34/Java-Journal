package Pratices;

/**
 * @description This code is used to calculate the average grade for a student
 *              based on six different courses. It takes the individual scores
 *              for each course and computes the overall average.
 */


import  java.util.Scanner;
public class GradeAverage {
    public static void main(String[] args) {
        float physics,math,chemistry,turkish,history,music;
        Scanner input = new Scanner (System.in);
        System.out.println("Please Enter Your Physics Score: ");
        physics = input.nextFloat();
        System.out.println("Please Enter Your Math Score: ");
        math = input.nextFloat();
        System.out.println("Please Enter Your Chemistry Score: ");
        chemistry = input.nextFloat();
        System.out.println("Please Enter Your Turkish Score: ");
        turkish = input.nextFloat();
        System.out.println("Please Enter Your History Score: ");
        history = input.nextFloat();
        System.out.println("Please Enter Your Music Score: ");
        music = input.nextFloat();

        float total = physics+math+chemistry+turkish+history+music;
        float average = total/6.0f;

        String str = average>= 60.0 ? "You Passed\nYour Average is: "+average: "You Failed\nYour Average is: "+average;
        System.out.println(str);


    }
}
