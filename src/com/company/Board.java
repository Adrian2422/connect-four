package com.company;

public class Board {

    public int[][] board = new int[8][9];
    public int playerMark = Player.mark;
    public int enemyMark = Enemy.mark;
    public String fieldColor = ConsoleColors.RESET;

    public void printBoard(String playerColor, String enemyColor){
        System.out.print(ConsoleColors.YELLOW + "  1 2 3 4 5 6 7 8 9" + ConsoleColors.RESET + "\n");
        for (int i = 0; i < board.length; i++){
            System.out.print(ConsoleColors.YELLOW + (i+1) + ConsoleColors.RESET + " ");
            for (int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    fieldColor = playerColor;
                } else if (board[i][j] == 2) {
                    fieldColor = enemyColor;
                }
                System.out.printf(fieldColor + "%1s " + ConsoleColors.RESET, board[i][j]);
                fieldColor = ConsoleColors.RESET;
            }
            System.out.print("\n");
        }
    }

    public boolean playerMove(int x, int y){
        if(board[x-1][y-1] == 0){
            board[x-1][y-1] = playerMark;
            System.out.println("Enemy's turn");
            return true;
        } else {
            System.out.println("You cannot place it there!");
            return false;
        }
    }

    public boolean enemyMove(int x, int y){
        if(board[x-1][y-1] == 0){
            board[x-1][y-1] = enemyMark;
            System.out.println("Your turn");
            return true;
        } else {
            System.out.println("Enemy cannot place it there!");
            return false;
        }
    }
}
