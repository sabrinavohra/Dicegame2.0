import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class GameView extends JFrame {
    private static final int WINDOW_HEIGHT = 700;
    private static final int WINDOW_WIDTH = 1000;
    private Image[] diceImages;
    private Image[] backgrounds;
    private Game theGame;

    public GameView(Game theGame) {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Dice Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        backgrounds = new Image[3];
        backgrounds[0] = new ImageIcon("Resources/Intro_SS.png").getImage();
        backgrounds[1] = new ImageIcon("Resources/playingBackground.png").getImage();
        diceImages = new Image[6];
        diceImages[0] = new ImageIcon("Resources/Dice1.png").getImage();
        diceImages[1] = new ImageIcon("Resources/Dice2.png").getImage();
        diceImages[2] = new ImageIcon("Resources/Dice3.png").getImage();
        diceImages[3] = new ImageIcon("Resources/Dice4.png").getImage();
        diceImages[4] = new ImageIcon("Resources/Dice5.png").getImage();
        diceImages[5] = new ImageIcon("Resources/Dice6.png").getImage();
    }

    public void paint(Graphics g, String currentState) {
        g.setColor(Color.white);
        g.fillRect(600, 1000, 600, 1000);
        if(currentState.equals("Intro")) {
            g.drawImage(backgrounds[0], 600, 1000, this);
        }
        if(currentState.equals("We're playing!")) {
            g.drawImage(backgrounds[1], 600, 1000, this);
        }
    }
}
