package src.LC2.one;

import src.LC1.Matrix.Matrix;

public class SquareMatrix extends Matrix {
    private int order;

    public SquareMatrix(int order, double value) {
        super(order, order, value);
        this.order = order;
    }

    public boolean isSymmetric() {
        if (getColumns() != getRows()) {
            return false;
        } else {
            for (int i = 0; i < order; i++) {
                for (int j = 0; j < order; j++) {
                    if (getElements(i, j) != getElements(j, i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private SquareMatrix createMinorMatrix(SquareMatrix matrix, int rowToRemove, int colToRemove) {
        SquareMatrix minor = new SquareMatrix(order - 1, 0.0);
        int minorRow = 0, minorCol = 0;
        for (int i = 0; i < order; i++) {
            if (i == rowToRemove) {
                continue;
            }
            minorCol = 0;
            for (int j = 0; j < order; j++) {
                if (j == colToRemove) {
                    minor.setElement(minorRow, minorCol, matrix.getElements(i, j));
                    minorCol++;
                }
            }
            minorRow++;
        }
        return minor;
    }

    private double calculateDeterminant(SquareMatrix matrix) {
        if (order == 1) {
            return matrix.getElements(0, 0); // Base case: determinant of a 1x1 matrix is its only element
        }

        double determinant = 0;
        for (int i = 0; i < order; i++) {
            // Calculate cofactor of matrix[0][i]
            double sign = (i % 2 == 0) ? 1 : -1;
            SquareMatrix minor = createMinorMatrix(matrix, 0, i);
            determinant += sign * matrix.getElements(0, i) * calculateDeterminant(minor);
        }
        return determinant;
    }

    public boolean isSingular() {
        if (getRows() != getColumns()) {
            return false; // Not a square matrix, hence not singular
        }

        double determinant = calculateDeterminant(this);
        return determinant == 0; // Matrix is singular if its determinant is zero
    }

    public double trace() {
        double trace = 0;
        for (int i = 0; i < order; i++) {
            trace += getElements(i, i); // Sum of elements on the main diagonal
        }
        return trace;
    }

    public void displayMatrix() {
        System.out.println("Square Matrix:");
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(getElements(i, j) + "\t");
            }
            System.out.println();
        }
    }
}
