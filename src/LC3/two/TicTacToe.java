package src.LC3.two;

import java.util.Scanner;

class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}

public class TicTacToe {
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
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
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by space: ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            try {
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;

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
                } else {
                    throw new InvalidMoveException("Invalid move! Please enter row and column within range (1-3).");
                }
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
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
    }

    private boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
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
