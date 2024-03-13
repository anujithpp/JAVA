package src.LC2.one;

public class Main {
    public static void main(String[] args) {
        // Testing SquareMatrix
        SquareMatrix squareMatrix = new SquareMatrix(3, 1.0); // Create a 3x3 square matrix filled with 1.0
        squareMatrix.setElement(0, 1, 2.0); // Set element at (0,1) to 2.0
        squareMatrix.setElement(1, 2, 3.0); // Set element at (1,2) to 3.0
        System.out.println("Square Matrix:");
        squareMatrix.displayMatrix(); // Display the square matrix
        System.out.println("Is symmetric? " + squareMatrix.isSymmetric()); // Check if the matrix is symmetric
        System.out.println("Is singular? " + squareMatrix.isSingular()); // Check if the matrix is singular
        System.out.println("Trace: " + squareMatrix.trace()); // Calculate and print the trace of the matrix
        System.out.println();

        // Testing DiagonalMatrix
        double[] diagonalElements = {1.0, 2.0, 3.0}; // Diagonal elements array
        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(3, diagonalElements); // Create a diagonal matrix
        System.out.println("Diagonal Matrix:");
        diagonalMatrix.displayMatrix(); // Display the diagonal matrix
        System.out.println("Diagonal elements: " + java.util.Arrays.toString(diagonalMatrix.getDiagonalElements())); // Print the diagonal elements
        System.out.println("Is symmetric? " + diagonalMatrix.isSymmetric()); // Check if the matrix is symmetric
        System.out.println("Is singular? " + diagonalMatrix.isSingular()); // Check if the matrix is singular
        System.out.println("Trace: " + diagonalMatrix.trace()); // Calculate and print the trace of the matrix
    }
}
