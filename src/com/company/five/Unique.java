package src.com.company.five;

import java.util.Random;
import java.util.Scanner;

public class Unique {
    private final int[][] matrix;

    public Unique() {
        Random random = new Random();
        int rows = random.nextInt(10) + 1;
        int cols = random.nextInt(10) + 1;
        matrix = new int[rows][cols];

        Scanner sc = new Scanner(System.in);
        int n = 1000;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(n) + 1;
            }
        }
    }
    public void displayMatrix() {
        System.out.println("Matix with ");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Unique matrix1 = new Unique();
        Unique matrix2 = new Unique();
        Unique matrix3 = new Unique();

        matrix1.displayMatrix();
        matrix2.displayMatrix();
        matrix3.displayMatrix();
    }
}