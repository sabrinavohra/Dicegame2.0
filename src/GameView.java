import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 1000;
    private Image[] diceImages;
    private Game g;
    private String currentState;

    public GameView(Game g) {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Dice Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.currentState = "Intro";
    }

    public void paint(Graphics g) {
        if(currentState.equals("Intro")) {
            g.setColor(Color.white);
            g.fillRect(600, 1000, 600, 1000);
        }
    }
}
