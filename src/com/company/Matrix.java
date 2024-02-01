package src.com.company;

public class Matrix {
    private int rows, columns;
    private double[][] data;
    private String name;

    public Matrix(int rows, int columns, double value) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];

        int i,j;
        for (i=0; i<rows; i++){
            for (j=0;j<columns;j++){
                data[i][j]=value;
            }
        }
    } //initializes the rows and columns of the matrix and sets each element as a value

    public void setElements(int rows , int columns , double value){
        data[rows][columns] = value;
    }  //set a specific value for an element

    public double getElements(int rows , int columns){
        return  data[rows][columns];
    }  //gets a value of a specific element


    public static void main(String[] args) {
        System.out.println("Test");
    }
}
