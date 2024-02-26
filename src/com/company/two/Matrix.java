package src.com.company.two;
import java.util.Scanner;
public class Matrix {
    public int rows;
    public int columns;
    public int[] data;
    public String values;
    public int[][] mat;
    public void matrix_creation(int[] data) {
        int k = 2;
        mat = new int[data[0]][data[1]];
        for (int i = 0; i < data[0]; i++) {
            for (int j = 0; j < data[1]; j++) {
                mat[i][j] = data[k++];
            }
        }
    }
    public void getElements(){
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void conversion(String[] A){
        data = new int[A.length];
        for(int i=0;i<A.length;i++){
            data[i] = Integer.parseInt(A[i]);
        }
    }

    public static void main(String[] args){
        Matrix mat = new Matrix();
        mat.conversion(args);
        mat.rows = mat.data[0];
        mat.columns = mat.data[1];
        mat.matrix_creation(mat.data);
        mat.getElements();
    }
}
