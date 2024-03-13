package src.LC3.three;

import java.util.Random;
import java.util.Scanner;

interface Player {
    void play(char[][] board, char currentPlayer);
}

class HumanPlayer implements Player {
    public void play(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by space: ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        while (!isValidMove(board, row, col)) {
            System.out.println("Invalid move! Try again.");
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by space: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        }

        board[row][col] = currentPlayer;
    }

    private boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }
}

class ComputerPlayer implements Player {
    public void play(char[][] board, char currentPlayer) {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(board, row, col));

        board[row][col] = currentPlayer;
    }

    private boolean isValidMove(char[][] board, int row, int col) {
        return (board[row][col] == '-');
    }
}

public class TicTacToe {
    private final char[][] board;
    private final Player humanPlayer;
    private final Player computerPlayer;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        humanPlayer = new HumanPlayer();
        computerPlayer = new ComputerPlayer();
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void makeMove() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();

            if (currentPlayer == 'X') {
                humanPlayer.play(board, currentPlayer);
            } else {
                computerPlayer.play(board, currentPlayer);
            }

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Check rows
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Check columns
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || // Check diagonals
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
