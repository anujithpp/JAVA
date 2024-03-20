package src.LC3.TicTacToe.oneto3;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Player currentPlayer;
        Scanner obj = new Scanner(System.in);
        TicTacToe game1 = new TicTacToe();
        game1.initializeBoard();
        System.out.println("Initial condition");
        game1.displayBoard();
        boolean gameStatus = false;
        System.out.print("Start game?(y/n):");
        String choice = obj.next();
        HumanPlayer Human = new HumanPlayer();
        ComputerPlayer Computer = new ComputerPlayer();
        int player = 1;
        currentPlayer = Human;
        int count = 1;
        while (choice.equals("y") && !gameStatus && count <= 9) {
            System.out.println(currentPlayer.getClass().getSimpleName()+"\n-----------");
            int[] temp ;
            boolean move = false;
            while (!move) {
                temp = currentPlayer.play(game1.getBoard());
                move = game1.makeMove(temp[0],temp[1],player);
            }
            game1.displayBoard();
            boolean isWin = game1.checkWin();
            if (isWin) {
                gameStatus = game1.gameOver();
            }
            if (player == 1) {
                player = 2;
                currentPlayer = Computer;
            } else {
                player = 1;
                currentPlayer = Human;
            }
            count++;
            if(count ==10&&!gameStatus){
                System.out.println("It Is A Draw!");
                exit(0);
            }
        }
    }
}
