import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class GameView extends JFrame {
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_WIDTH = 1000;
    private Image[] diceImages;
    private Image[] backgrounds;
    private Game theGame;

    public GameView(Game theGame) {
        this.theGame = theGame;
        backgrounds = new Image[2];
        backgrounds[0] = new ImageIcon("src/Resources/Intro_SS.png").getImage();
        backgrounds[1] = new ImageIcon("src/Resources/playingBackground.png").getImage();
        diceImages = new Image[6];
        diceImages[0] = new ImageIcon("src/Resources/Dice1.png").getImage();
        diceImages[1] = new ImageIcon("src/Resources/Dice2.png").getImage();
        diceImages[2] = new ImageIcon("src/Resources/Dice3.png").getImage();
        diceImages[3] = new ImageIcon("src/Resources/Dice4.png").getImage();
        diceImages[4] = new ImageIcon("src/Resources/Dice5.png").getImage();
        diceImages[5] = new ImageIcon("src/Resources/Dice6.png").getImage();
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Dice Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        String currentState = theGame.getCurrentState();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 1000, 800);
        if(currentState.equals("Intro")) {
            g.setColor(Color.black);
            g.drawImage(backgrounds[0], 0, 0, 1000, 800,this);
        }
        if(currentState.equals("We're playing!")) {
            g.drawImage(backgrounds[1], 0, 0, 1000, 800,this);
            String printPoints = "" + theGame.getPoints();
            g.drawString(printPoints, 800, 10);
            if(theGame.getCurrentRoll() == 1) {
                g.setColor(Color.white);
                // Print image of screen
            }
            g.drawString(printPoints, 800, 10);
//            if(theGame.getCurrentRoll() == 1) {
//                theGame.printPoints(theGame.points1);
//            }
        }
        else if(currentState.equals("It's over")) {
            g.drawString("THANKS FOR PLAYING!", 500, 400);
        }
    }
}
