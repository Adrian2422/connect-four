package com.company;

public class Board {

    public int[][] board = new int[8][9];

    public void printBoard(){
        System.out.print(ConsoleColors.YELLOW + "  1 2 3 4 5 6 7 8 9" + ConsoleColors.RESET + "\n");
        for (int i = 0; i < board.length; i++){
            System.out.print(ConsoleColors.YELLOW + (i+1) + ConsoleColors.RESET + " ");
            for (int j = 0; j < board[i].length; j++){
                System.out.printf("%1s ", board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
