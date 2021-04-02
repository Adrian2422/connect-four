package com.company;

public class Board {

    public int[][] board = new int[8][9];
    public int playerMark = Player.mark;
    public int enemyMark = Enemy.mark;
    public String fieldColor = ConsoleColors.RESET;

    public void printBoard(String playerColor, String enemyColor){
        System.out.print(ConsoleColors.YELLOW + "1 2 3 4 5 6 7 8 9" + ConsoleColors.RESET + "\n");
        for (int i = 0; i < board.length; i++){
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

    public boolean playerMove(int x){
        if(moveMarkDown(x, "player")){
            System.out.println("You cannot place it there!");
            return false;
        } else {
            Utils.cls();
            System.out.println("Enemy's turn");
            return true;
        }
    }

    public boolean enemyMove(int x){
        if(moveMarkDown(x, "enemy")){
            System.out.println("Enemy cannot place it there!");
            return false;
        } else {
            Utils.cls();
            System.out.println("Your turn");
            return true;
        }
    }
    private boolean moveMarkDown(int x, String player){
        int actualField;
        int nextField;
        int mark = player.equals("player") ? 1 : 2;
        --x;
        for (int i = 0; i < board.length; i++) {
            if(x >= board[i].length || x < 0){
                return true;
            }
            actualField = board[i][x];
            if(i+1 < board.length){
                nextField = board[i+1][x];
                if(actualField == 0 && nextField != 0){
                    board[i][x] = mark;
                    return false;
                }
            } else {
                if(actualField == 0){
                    board[i][x] = mark;
                    return false;
                }
            }
        }
        return true;
    }
}
