package src.LC3.TicTacToe.oneto3;

import java.util.Scanner;

public class HumanPlayer extends TicTacToe implements Player {
    Scanner obj = new Scanner(System.in);
    @Override
    public int[] play(String[][] board) {
        int[] temp = new int[2];
        System.out.print("Enter the row:");
        temp[0] = obj.nextInt() - 1;
        System.out.print("Enter the column:");
        temp[1] = obj.nextInt() - 1;
        return temp;
    }
}
