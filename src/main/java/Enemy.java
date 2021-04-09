import java.util.Collections;
import java.util.Random;

public class Enemy {
    public String color = ConsoleColors.BLUE_BACKGROUND_BRIGHT;
    public static int mark = 2;
    ConsoleColors consoleColors = new ConsoleColors();

    public void setColor(String playerColor) {
        if(color.equals(playerColor)){
            consoleColors.backgroundBrightColors.values().removeAll(Collections.singleton(playerColor));
            Random generator = new Random();
            Object[] colors = consoleColors.backgroundBrightColors.values().toArray();
            Object randomColor = colors[generator.nextInt(colors.length)];
            this.color = (String) randomColor;
        }
    }
}
