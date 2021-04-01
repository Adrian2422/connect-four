package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Board board = new Board();
        InputHandlers iHandler = new InputHandlers();
        Enemy enemy = new Enemy();
        Scanner scan = new Scanner(System.in);
        String choice;
        String playerColor = ConsoleColors.RED;

        System.out.println("Welcome to the match four game!\n");
        System.out.println("Your task is to arrange four or more disks vertically, horizontally or diagonally.\n");
        System.out.println("Do you want to choose your color? (Default"  + ConsoleColors.RED + " red" + ConsoleColors.RESET + ", [y/n])\n");

        choice = scan.next();

        if(choice.equals("y") || choice.equals("Y")){
            playerColor = iHandler.getColor();
            enemy.setColor(playerColor);
        }

        board.printBoard();
    }
}
