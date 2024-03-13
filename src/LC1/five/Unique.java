package src.LC1.five;

import java.util.Random;
import java.util.Scanner;

public class Unique {
    private final int[][] matrix;
    private static int totalMatrices = 0;
    private final long creationTime;
    private final String matrixID;

    public Unique() {
        Random random = new Random();
        int rows = random.nextInt(10) + 1;
        int cols = random.nextInt(10) + 1;
        matrix = new int[rows][cols];
        creationTime = System.currentTimeMillis();
        matrixID = "Matrix_" + ++totalMatrices + "_" + creationTime; // Unique ID with timestamp
        System.out.println("Matrix with ID " + matrixID + ":");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int n = 1000;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(n) + 1;
            }
        }
    }
    public void displayMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Unique matrix1 = new Unique();
        matrix1.displayMatrix();
        Unique matrix2 = new Unique();
        matrix2.displayMatrix();
        Unique matrix3 = new Unique();
        matrix3.displayMatrix();
    }
}
