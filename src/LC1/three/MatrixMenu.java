package src.LC1.three;

import src.LC1.Matrix.Matrix;

import java.util.Scanner;

public class MatrixMenu {
    private static Matrix matx;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create Matrix");
            System.out.println("2. Print Matrix");
            System.out.println("3. Print Column Sum");
            System.out.println("4. Print Row Sum");
            System.out.println("5. Print Average of Matrix");
            System.out.println("6. Check if Matrix is Diagonal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createMatrix();
                    break;
                case 2:
                    printMatrix();
                    break;
                case 3:
                    printColumnSum();
                    break;
                case 4:
                    printRowSum();
                    break;
                case 5:
                    printMatrixAverage();
                    break;
                case 6:
                    checkDiagonalMatrix();
                    break;
                case 7:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void createMatrix() {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        System.out.println("Enter the matrix elements row-wise:");
        matx = new Matrix(rows, columns, 0.0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                double value = scanner.nextDouble();
                matx.setElement(i, j, value);
            }
        }
    }

    private static void printMatrix() {
        if (matx == null) {
            System.out.println("Matrix is not created yet.");
        } else {
            System.out.println("Matrix:");
            for (int i = 0; i < matx.getRows(); i++) {
                for (int j = 0; j < matx.getColumns(); j++) {
                    System.out.print(matx.getElements(i, j) + "\t");
                }
                System.out.println();
            }
        }
    }

    private static void printColumnSum() {
        if (matx == null) {
            System.out.println("Matrix is not created yet.");
        } else {
            System.out.print("Enter the column number (0-based): ");
            int col = scanner.nextInt();
            double sum = 0;
            for (int i = 0; i < matx.getRows(); i++) {
                sum += matx.getElements(i, col);
            }
            System.out.println("Sum of column " + col + ": " + sum);
        }
    }

    private static void printRowSum() {
        if (matx == null) {
            System.out.println("Matrix is not created yet.");
        } else {
            System.out.print("Enter the row number (0-based): ");
            int row = scanner.nextInt();
            double sum = 0;
            for (int j = 0; j < matx.getColumns(); j++) {
                sum += matx.getElements(row, j);
            }
            System.out.println("Sum of row " + row + ": " + sum);
        }
    }

    private static void printMatrixAverage() {
        if (matx == null) {
            System.out.println("Matrix is not created yet.");
        } else {
            double sum = 0;
            int count = 0;
            for (int i = 0; i < matx.getRows(); i++) {
                for (int j = 0; j < matx.getColumns(); j++) {
                    sum += matx.getElements(i, j);
                    count++;
                }
            }
            double average = sum / count;
            System.out.println("Average of matrix: " + average);
        }
    }

    private static void checkDiagonalMatrix() {
        if (matx == null) {
            System.out.println("Matrix is not created yet.");
        } else {
            boolean isDiagonal = true;
            if (matx.getRows() != matx.getColumns()) {
                isDiagonal = false;
            } else {
                for (int i = 0; i < matx.getRows(); i++) {
                    for (int j = 0; j < matx.getColumns(); j++) {
                        if (i != j && matx.getElements(i, j) != 0) {
                            isDiagonal = false;
                            break;
                        }
                    }
                    if (!isDiagonal) {
                        break;
                    }
                }
            }
            if (isDiagonal) {
                System.out.println("YES, Matrix is diagonal.");
            } else {
                System.out.println("NO, Matrix is not diagonal.");
            }
        }
    }
}
