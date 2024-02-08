import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class GameView extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 1000;
    private Image[] diceImages;
    private Image[] backgrounds;
    private Game theGame;
    private String currentState;

    public GameView(Game theGame) {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Dice Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.currentState = "Intro";
        backgrounds[0] = new ImageIcon("Resources/Intro_SS.png").getImage();
    }

    public void paint(Graphics g) {
        if(currentState.equals("Intro")) {
            g.setColor(Color.white);
            g.fillRect(600, 1000, 600, 1000);
            g.drawImage(backgrounds[0], 600, 1000, this);
        }
        if(currentState.equals("We're playing!") {
        }
    }
}
