import java.util.Collections;
import java.util.Scanner;

public class Player {
    public String getColor() {
        return color;
    }

    private String color;

    public char getMark() {
        return mark;
    }

    private char mark;
    ConsoleColors consoleColors = new ConsoleColors();

    public Player(String color, char mark){
        this.color = color;
        this.mark = mark;
    }

    public void getPossibleColors(String secondPlayerColor) {
        consoleColors.backgroundBrightColors.values().removeAll(Collections.singleton(secondPlayerColor));
    }

    public void setColor(){
        ConsoleColors consoleColors = new ConsoleColors();

        System.out.println("Choose color [1-6]:");
        System.out.println(consoleColors.backgroundBrightColors.get(1) + "1. Red");
        System.out.println(consoleColors.backgroundBrightColors.get(2) + "2. Blue");
        System.out.println(consoleColors.backgroundBrightColors.get(3) + "3. Green");
        System.out.println(consoleColors.backgroundBrightColors.get(4) + "4. Purple");
        System.out.println(consoleColors.backgroundBrightColors.get(5) + "5. White");
        System.out.println(consoleColors.backgroundBrightColors.get(6) + "6. Cyan");

        Scanner scan = new Scanner(System.in);

        color = consoleColors.backgroundBrightColors.get(scan.nextInt());
    }

    public void setMark(){
        System.out.println(ConsoleColors.RESET + "Insert your mark:");

        Scanner scan = new Scanner(System.in);
        mark = scan.next().charAt(0);
    }
}
