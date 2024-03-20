package src.LC3.TicTacToe.oneto3;

public class TicTacToe {
    private  String[][] board;
    TicTacToe(){
        board = new String[3][3];
    }
    public void initializeBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                board[i][j] = "-";
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public String getBoardElement(int i, int j,String[][] board) {
        return board[i][j];
    }
    public boolean makeMove(int r, int c, int player){
        try {
            if(r>=3 || c>=3){
                throw new InvalidMoveException("Invalid Move : Out of Bound");
            }
            else {
                if(r<0 || c<0) {
                    throw new InvalidMoveException("Invalid Move : Out of Bound");
                }else {
                    if (!board[r][c].equals("-")) {
                        throw new InvalidMoveException("Invalid Move : Cell Occupied");
                    }
                    if (player == 1) {
                        board[r][c] = "X";
                        return true;
                    } else if (player == 2) {
                        board[r][c] = "O";
                        return true;
                    }
                }
            }

        }catch (InvalidMoveException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void displayBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+' ');
            }
            System.out.println();
        }
    }
    public boolean checkWin() {
        boolean win = false;
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("-")) {
                System.out.println("Player " + (board[i][0].equals("X") ? "Human" : "Computer") + " wins");
                win = true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]) && !board[0][j].equals("-")) {
                System.out.println("Player " + (board[0][j].equals("X") ? "Human" : "Computer") + " wins");
                win = true;
            }
        }
        // Check diagonals
        if(!win) {
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("-")) {
                System.out.println("Player " + (board[0][0].equals("X") ? "Human" : "Computer") + " wins");
                win = true;
            }
            if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("-")) {
                System.out.println("Player " + (board[0][2].equals("X") ? "Human" : "Computer") + " wins");
                win = true;
            }
        }
        return win;
    }

    public boolean gameOver() {
        return true;
    }
}
