package src.com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {                                     //MAIN
        int a, b, c, d;
        double v;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the rows for first matrix: ");
        a = sc.nextInt();
        System.out.print("Enter the columns for first matrix: ");
        b = sc.nextInt();

        Matrix m1 = new Matrix(a, b, 0.0);                             //created matrix m1
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("Enter i = " + (i + 1) + " and j = " + (j + 1) + " th Elements: ");
                v = sc.nextDouble();
                m1.setElement(i, j, v);
            }
        }                                    //setting elements of m1

        System.out.print("Enter the rows for second matrix: ");
        c = sc.nextInt();
        System.out.print("Enter the columns for second matrix: ");
        d = sc.nextInt();

        Matrix m2 = new Matrix(c, d, 0.0);                             //created matrix m2
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print("Enter i = " + (i + 1) + " and j = " + (j + 1) + " th Elements: ");
                v = sc.nextDouble();
                m2.setElement(i, j, v);
            }
        }                                   //setting elements of m2

        System.out.println();

        m1.add(m2);                                                         //added matrix objects m1 and m2
        m1.subtract(m2);                                                    //subtracted m2 from m1
        m1.multiply(m2);                                                    //multiply m1 with m2

        System.out.println("Transpose of first matrix");
        m1.transpose();                                                     //Transpose of first matrix

        System.out.println();
        System.out.println("Transpose of second matrix");
        m2.transpose();                                                     //Transpose of second matrix

        System.out.println();
        System.out.println("First matrix as a string: ");
        System.out.println(m1.tostring());                                  //printing matrix m1 as a string
        System.out.println();
        System.out.println("Second matrix as a string: ");
        System.out.println(m2.tostring());                                  //printing matrix m2 as a string

    }
}
