package Practices;

import java.util.Scanner;

public class RecursivePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number to get recursive pattern: ");
        int n = scanner.nextInt();

        recursivePattern(n);
    }

    public static void recursivePattern(int n) {
        // Sayı 0 veya negatif olana kadar 5 çıkar
        if (n <= 0) {
            // Sayı 0 veya negatif olursa, 5 ekle
            System.out.print(n+" ");
            return;
        } else {
            // 5 çıkar ve sonucu yazdır
            System.out.print(n+" ");
            recursivePattern(n - 5);
        }

            System.out.print(n+" ");

    }
}