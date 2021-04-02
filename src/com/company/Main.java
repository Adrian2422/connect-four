package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Board board = new Board();
        Enemy enemy = new Enemy();
        Player player = new Player();
        Scanner scan = new Scanner(System.in);
        InputHandlers iHandler = new InputHandlers();
        char choice;
        int position;
        String winner;
        boolean gameOver = false;
        boolean playerMove = false;
        boolean enemyMove = false;


        System.out.println("Welcome to the match four game!\n");
        System.out.println("Your task is to arrange four or more disks vertically, horizontally or diagonally.\n");
        System.out.println("Do you want to choose your color? (Default"  + ConsoleColors.RED + " red" + ConsoleColors.RESET + ", [y/n])\n");

        choice = scan.next().charAt(0);

        switch (choice){
            case 'y':
            case 'Y':
                player.color = iHandler.getColor();
                enemy.setColor(player.color);
                break;
            default:
                break;
        }

        System.out.println(ConsoleColors.RESET + "Your color:" + player.color + " ###" + ConsoleColors.RESET);
        System.out.println("Your enemy's color:" + enemy.color + " ###" + ConsoleColors.RESET);
        System.out.println("Good luck!\n");

        board.printBoard(player.color, enemy.color);

        while(true){
            while (!enemyMove){
                while(!scan.hasNextInt()){
                    System.out.println("That's not a number!");
                    scan.next();
                }
                position = scan.nextInt();
                enemyMove = board.enemyMove(position);
            }
            board.printBoard(player.color, enemy.color);
            gameOver = board.areFourConnected(Enemy.mark);
            if(gameOver){
                winner = "Enemy";
                break;
            }
            while(!playerMove){
                while(!scan.hasNextInt()){
                    System.out.println("That's not a number!");
                    scan.next();
                }
                position = scan.nextInt();
                playerMove = board.playerMove(position);
            }
            board.printBoard(player.color, enemy.color);
            gameOver = board.areFourConnected(Player.mark);
            enemyMove = false;
            playerMove = false;
            if(gameOver){
                winner = "Player";
                break;
            }
        }
        System.out.printf("%1s wins!", winner);

    }
}
