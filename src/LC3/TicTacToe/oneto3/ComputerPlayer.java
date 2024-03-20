package src.LC3.TicTacToe.oneto3;

import java.util.Random;

public class ComputerPlayer extends TicTacToe implements Player {

    Random rnd = new Random();
    @Override
    public int[] play(String[][] board) {
        int[] temp = new int[2];
        do {
            temp[0] = rnd.nextInt(3);
            temp[1] = rnd.nextInt(3);
        }while(!getBoardElement(temp[0],temp[1],board).equals("-"));

        return temp;
    }
}
