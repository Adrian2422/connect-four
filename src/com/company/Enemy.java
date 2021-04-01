package com.company;

import java.util.Collections;
import java.util.Random;

public class Enemy {
    public String color = ConsoleColors.BLUE;
    ConsoleColors consoleColors = new ConsoleColors();

    public void setColor(String playerColor) {
        if(color.equals(playerColor)){
            consoleColors.regularColors.values().removeAll(Collections.singleton(playerColor));
            Random generator = new Random();
            Object[] colors = consoleColors.regularColors.values().toArray();
            Object randomColor = colors[generator.nextInt(colors.length)];
            this.color = (String) randomColor;
        }
    }
}
