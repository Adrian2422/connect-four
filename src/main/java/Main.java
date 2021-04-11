import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Player playerOne = new Player(ConsoleColors.RED_BACKGROUND_BRIGHT, '1');
        Player playerTwo = new Player(ConsoleColors.BLUE_BACKGROUND_BRIGHT, '2');
        String playerOneColor = playerOne.getColor();
        String playerTwoColor = playerTwo.getColor();
        char playerOneMark = playerOne.getMark();
        char playerTwoMark = playerTwo.getMark();
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        char choice;
        int position;
        String winner;
        boolean gameOver = false;
        boolean playerOneMove = false;
        boolean playerMove = false;

        System.out.println("Welcome to the match four game!\n");
        System.out.println("Your task is to arrange four or more disks vertically, horizontally or diagonally.\n");
        System.out.println("Do you want to customize players? (Default:\n Player One - " + playerOneColor + playerOneMark + ConsoleColors.RESET + "\n Player Two - " + playerTwoColor + playerTwoMark + ConsoleColors.RESET + "\n [y/n])\n");

        choice = scan.next().charAt(0);

        switch (choice){
            case 'y':
            case 'Y':
                playerOne.setColor();
                playerTwo.setColor();
                break;
            default:
                break;
        }

        System.out.println(ConsoleColors.RESET + "Your color:" + playerOneColor + " ###" + ConsoleColors.RESET);
        System.out.println("Your enemy's color:" + playerTwoColor + " ###" + ConsoleColors.RESET);
        System.out.println("Good luck!\n");

        board.printBoard(playerOneColor, playerTwoColor);

        while(true){
            gameOver = isGameOver(playerOne, board, scan, false, playerOneColor, playerTwoColor);
            if(gameOver){
                winner = "Player One";
                break;
            }
            gameOver = isGameOver(playerTwo, board, scan, false, playerOneColor, playerTwoColor);
            if(gameOver){
                winner = "Player Two";
                break;
            }
        }
        System.out.printf("%1s wins!", winner);
    }

    private static boolean isGameOver(Player player, Board board, Scanner scan, boolean playerMove, String firstPlayerColor, String secondPlayerColor) {
        int position;
        boolean gameOver;
        while (!playerMove){
            while(!scan.hasNextInt()){
                System.out.println("That's not a number!");
                scan.next();
            }
            position = scan.nextInt();
            playerMove = board.playerMove(position, player.getMark());
        }
        board.printBoard(firstPlayerColor, secondPlayerColor);
        gameOver = board.areFourConnected(player.getMark());
        return gameOver;
    }
}
