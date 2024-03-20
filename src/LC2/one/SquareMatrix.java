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

    public double determinant(double[][] data) {
        double det = 0;
        if (data.length == 1) {
            return data[0][0];
        } else if (data.length == 2) {
            return (data[0][0] * data[1][1]) - (data[0][1] * data[1][0]);
        } else {
            for (int i = 0; i < data.length; i++) {
                det += Math.pow(-1, i) * data[0][i] * determinant(sub_matrix(data, 0, i));
            }
        }
        return det;
    }
    public double[][] sub_matrix(double[][] dataSquare, int ex_row, int ex_col) {
        int sub_order = dataSquare.length - 1;
        double[][] subMatrix = new double[sub_order][sub_order];
        for (int i = 1; i < dataSquare.length; i++) {
            for (int j = 0, col = 0; j < dataSquare.length; j++) {
                if (j == ex_col) {
                    continue;
                }
                subMatrix[i - 1][col++] = dataSquare[i][j];
            }
        }
        return subMatrix;
    }

    public boolean isSingular() {
        if (getRows() != getColumns()) {
            return false; // Not a square matrix, hence not singular
        }

        double determinant = determinant(this.getData());
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


