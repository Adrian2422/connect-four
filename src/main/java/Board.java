public class Board {

    private final char[][] board = new char[8][9];
    private String fieldColor = ConsoleColors.RESET;

    public void printBoard(String playerOneColor, String playerTwoColor){
        System.out.print(ConsoleColors.YELLOW + "1 2 3 4 5 6 7 8 9" + ConsoleColors.RESET + "\n");
        for (char[] rows : board) {
            for (char mark : rows) {
                if (mark == '1') {
                    fieldColor = playerOneColor;
                } else if (mark == '2') {
                    fieldColor = playerTwoColor;
                }
                System.out.printf(fieldColor + "%1s" + ConsoleColors.RESET + " ", mark);
                fieldColor = ConsoleColors.RESET;
            }
            System.out.print("\n");
        }
    }

    public boolean playerMove(int x, char playerMark){
        if(moveMarkDown(x, playerMark)){
            System.out.println("You cannot place it there!");
            return false;
        } else {
            Utils.cls();
            System.out.println("Enemy's turn");
            return true;
        }
    }

    private boolean moveMarkDown(int x, char playerMark){
        int actualField;
        int nextField;
        --x;
        for (int i = 0; i < board.length; i++) {
            if(x >= board[i].length || x < 0){
                return true;
            }
            actualField = board[i][x];
            if(i+1 < board.length){
                nextField = board[i+1][x];
                if(actualField == 0 && nextField != 0){
                    board[i][x] = playerMark;
                    return false;
                }
            } else {
                if(actualField == 0){
                    board[i][x] = playerMark;
                    return false;
                }
            }
        }
        return true;
    }

    public boolean areFourConnected(char mark){
        // horizontalCheck
        for (int i = 0; i < board.length-3; i++){
            for (int j = 0; j < board[i].length - 1; j++){
                if (this.board[j][i] == mark && this.board[j][i+1] == mark && this.board[j][i+2] == mark && this.board[j][i+3] == mark){
                    return true;
                }
            }
        }
        // vertical check
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 4; j++){
                if (this.board[j][i] == mark && this.board[j+1][i] == mark && this.board[j+2][i] == mark && this.board[j+3][i] == mark){
                    return true;
                }
            }
        }
        // diagonal desc check
        for (int i = 3; i<board.length; i++){
            for (int j = 3; j<board[i].length; j++){
                if (this.board[i][j] == mark && this.board[i-1][j-1] == mark && this.board[i-2][j-2] == mark && this.board[i-3][j-3] == mark)
                    return true;
            }
        }
        // diagonal asc check
        for (int i = 3; i < board.length; i++){
            for (int j = 0; j< board[i].length - 3; j++){
                if (this.board[i][j] == mark && this.board[i-1][j+1] == mark && this.board[i-2][j+2] == mark && this.board[i-3][j+3] == mark)
                    return true;
            }
        }
        return false;
    }
}
