package src.LC2.one;

import src.LC2.one.SquareMatrix;

public class DiagonalMatrix extends SquareMatrix {
    private double[] diagonalElements;

    public DiagonalMatrix(int size, double[] diagonalElements) {
        super(size, 0.0); // Initialize the matrix with zeros
        if (diagonalElements.length != size) {
            throw new IllegalArgumentException("Diagonal elements array size must match matrix size.");
        }
        this.diagonalElements = diagonalElements;
        for (int i = 0; i < size; i++) {
            setElement(i, i, diagonalElements[i]); // Set diagonal elements
        }
    }

    // Other methods...

    public double[] getDiagonalElements() {
        return diagonalElements;
    }
}
