package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Board board = new Board();
        Enemy enemy = new Enemy();
        Player player = new Player();
        Scanner scan = new Scanner(System.in);
        InputHandlers iHandler = new InputHandlers();
        String choice;
        boolean gameOver = false;
        boolean playerMove;
        boolean enemyMove;


        System.out.println("Welcome to the match four game!\n");
        System.out.println("Your task is to arrange four or more disks vertically, horizontally or diagonally.\n");
        System.out.println("Do you want to choose your color? (Default"  + ConsoleColors.RED + " red" + ConsoleColors.RESET + ", [y/n])\n");

        choice = scan.next();

        if(choice.equals("y") || choice.equals("Y")){
            player.color = iHandler.getColor();
            enemy.setColor(player.color);
        }

        System.out.println(ConsoleColors.RESET + "Your color:" + player.color + " ###" + ConsoleColors.RESET);
        System.out.println("Your enemy's color:" + enemy.color + " ###" + ConsoleColors.RESET);
        System.out.println("Good luck!\n");

        do{
            do{
                board.printBoard(player.color, enemy.color);
                enemyMove = board.enemyMove(scan.nextInt());
            } while (!enemyMove);
            do{
                board.printBoard(player.color, enemy.color);
                playerMove = board.playerMove(scan.nextInt());
            } while(!playerMove);
        } while(gameOver != true);
    }
}
