package src.com.company.tictactoe;

import java.util.Scanner;
public class TicTacToe{
    private String board[][];
    public TicTacToe(){
        board=new String[3][3];
    }
    public void initializeBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]="_";
            }
        }
    }
    public boolean makeMove(int r,int c,int player){
        boolean move=false;
        if(player==1 && board[r][c]=="_"){
            board[r][c]="X";
            move=true;
        }
        else if(player==2 && board[r][c]=="_"){
            board[r][c]="O";
            move=false;
        }
        else{
            System.out.println("Invalid move");
        }
        return move;
    }
    public boolean isGameOver(){

        return true;
    }
    public boolean checkWin(int row,int col,int player){
        boolean win=false;
        String val1="XXX";
        String val2="OOO";
        String win1="";
        String win2="";
        String win3="";
        String win4="";
        int p=player;
        for(int i=0;i<3;i++){
            win1+=board[i][col];
        }
        for(int j=0;j<3;j++){
            win2+=board[row][j];
        }
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(k==l){
                    win3+=board[k][k];
                }
                else if(k+l==2){
                    win4+=board[k][l];
                }
            }
        }
        if(win1.equals(val1) || win2.equals(val1) ||  win3.equals(val1) || win4.equals(val1) ){
            System.out.print("Player 1 wins");
            win= true;
        }
        else if(win1.equals(val2) || win2.equals(val2) || win3.equals(val2) || win4.equals(val2) ){
            System.out.print("Player 2 wins");
            System.out.println();
            win=true;
        }
        return win;
    }
    public void dispBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner obj=new Scanner(System.in);
        TicTacToe game1=new TicTacToe();
        game1.initializeBoard();
        System.out.print("Initial Condition");
        System.out.println();
        game1.dispBoard();
        int player=1;
        boolean gameSt=false;
        System.out.print("Start game?(y/n):");
        String ch=obj.next();
        int count=1;
        while(ch.equals("y") && gameSt==false && count<=9){
            System.out.print("Enter the row:");
            int row=obj.nextInt()-1;
            System.out.print("Enter the columns:");
            int column=obj.nextInt()-1;
            boolean move=game1.makeMove(row,column,player);
            if(move==false){
                System.out.print("Enter the row:");
                row=obj.nextInt()-1;
                System.out.print("Enter the column:");
                column=obj.nextInt()-1;

                game1.makeMove(row,column,player);
            }
            game1.dispBoard();
            boolean iswin=game1.checkWin(row,column,player);
            if(iswin==true){
                gameSt=game1.isGameOver();
            }
            if(player==1){
                player=2;
            }
            else{
                player=1;
            }
            count++;
        }

    }
}





