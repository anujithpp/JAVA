package src.com.company.one;

public class Matrix {
    //Question 1 variables and functions
    private int rows;
    private int columns;
    private double[][] data;
    private String name;

    public Matrix(int rows, int columns, double value) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];

        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                data[i][j] = value;
            }
        }
    } //initializes the rows and columns of the matrix and sets each element as a value

    public void setElement(int row, int col, double value) {
        data[row][col] = value;
    }

    public double getElements(int rows, int columns) {
        return data[rows][columns];
    }  //gets a value of a specific element

    public void add(Matrix mat2) {
        if (this.rows != mat2.rows || this.columns != mat2.columns) {
            System.out.println("Both matrices must have the same dimensions to add!");
        } else {
            Matrix sum = new Matrix(rows, columns, 0.0);
            for (int i = 0; i < sum.rows; i++) {
                for (int j = 0; j < sum.columns; j++) {
                    sum.data[i][j] = this.data[i][j] + mat2.data[i][j];
                }
            }
            System.out.println("Added matrix:");
            for (int i = 0; i < sum.rows; i++) {
                for (int j = 0; j < sum.columns; j++) {
                    System.out.print(sum.data[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void subtract(Matrix mat2) {
        if (this.rows != mat2.rows || this.columns != mat2.columns) {
            System.out.println("Both matrices must have the same dimensions to subtract!");
        } else {
            Matrix sub = new Matrix(rows, columns, 0.0);
            for (int i = 0; i < sub.rows; i++) {
                for (int j = 0; j < sub.columns; j++) {
                    sub.data[i][j] = this.data[i][j] - mat2.data[i][j];
                }
            }
            System.out.println("Subtracted matrix:");
            for (int i = 0; i < sub.rows; i++) {
                for (int j = 0; j < sub.columns; j++) {
                    System.out.print(sub.data[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void multiply(Matrix mat2) {
        if (this.columns != mat2.rows) {
            System.out.println("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return; // Exit the method if multiplication is not possible
        }

        Matrix product = new Matrix(this.rows, mat2.columns, 0.0);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < mat2.columns; j++) {
                double sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.data[i][k] * mat2.data[k][j];
                }
                product.data[i][j] = sum;
            }
        }

        System.out.println("Result of multiplication:");
        for (int i = 0; i < product.rows; i++) {
            for (int j = 0; j < product.columns; j++) {
                System.out.print(product.data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void transpose() {
        Matrix transposed = new Matrix(columns, rows, 0.0); // Create a new matrix with swapped dimensions

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed.data[j][i] = this.data[i][j]; // Swap rows and columns
            }
        }

        for (int i = 0; i < transposed.rows; i++) {
            for (int j = 0; j < transposed.columns; j++) {
                System.out.print(transposed.getElements(i, j) + " ");
            }
            System.out.println();
        }
    }

    public String tostring() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(data[i][j]);
            }
        }
        return sb.toString();
    }

    //Question 2 variables and functions

    public static int[] stringToArray(String str) {
        String[] numberString = str.split(" "); // Split the string into an array of strings
        int[] num = new int[numberString.length]; // Create an array to store integers

        for (int i = 0; i < numberString.length; i++) {
            num[i] = Integer.parseInt(numberString[i]); // Parse each string to an integer
        }

        return num; // Return the array of integers
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
