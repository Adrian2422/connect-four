package com.company;

import java.util.Scanner;

public class InputHandlers {

    public String getColor(){
        ConsoleColors consoleColors = new ConsoleColors();

        System.out.println("Choose color [1-6]:");
        System.out.println(consoleColors.backgroundBrightColors.get(1) + "1. Red");
        System.out.println(consoleColors.backgroundBrightColors.get(2) + "2. Blue");
        System.out.println(consoleColors.backgroundBrightColors.get(3) + "3. Green");
        System.out.println(consoleColors.backgroundBrightColors.get(4) + "4. Purple");
        System.out.println(consoleColors.backgroundBrightColors.get(5) + "5. White");
        System.out.println(consoleColors.backgroundBrightColors.get(6) + "6. Cyan");

        Scanner scan = new Scanner(System.in);

        return consoleColors.backgroundBrightColors.get(scan.nextInt());
    }
}
