package src.com.company;

import java.util.Scanner;

public class Percentage {
    public static void main(String[] str) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*****BOARD EXAM PERCENTAGE CALCULATOR*****");

        System.out.print("Enter mark for Maths: ");
        int a = sc.nextInt();

        System.out.print("Enter mark for Biology: ");
        int b = sc.nextInt();

        System.out.print("Enter mark for Chemistry: ");
        int c = sc.nextInt();

        System.out.print("Enter mark for Physics: ");
        int d = sc.nextInt();

        System.out.print("Enter mark for English: ");
        int e = sc.nextInt();

        int sum = a + b + c + d + e;

        int x = sum * 100 / 500;

        if (x > 100 || a > 100 || b > 100 || c > 100 || d > 100 || e > 100) {
            System.out.println("The is something wrong in the data you entered! ");
            System.out.println("Check the marks you entered!");
        } else {
            System.out.println("Total percentage for board exam is: " + x + "%");
        }

        if (x >= 50) {
            System.out.println("You are Eligible for Higher Studies");
            System.out.println("Congratulations!");
        } else {
            System.out.println("You are failed!");
            System.out.println("Minimum 50% is required to pass.");
            System.out.println("Better luck next time");
        }
    }
}
