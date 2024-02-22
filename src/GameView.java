import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class GameView extends JFrame {
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 768;
    private Image[] diceImages;
    private Image[] diceBackgrounds;
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
        diceBackgrounds = new Image[6];
        diceBackgrounds[0] = new ImageIcon("src/Resources/background1.png").getImage();
        diceBackgrounds[1] = new ImageIcon("src/Resources/background2.png").getImage();
        diceBackgrounds[2] = new ImageIcon("src/Resources/background3.png").getImage();
        diceBackgrounds[3] = new ImageIcon("src/Resources/background4.png").getImage();
        diceBackgrounds[4] = new ImageIcon("src/Resources/background5.png").getImage();
        diceBackgrounds[5] = new ImageIcon("src/Resources/background6.png").getImage();
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
            g.drawImage(backgrounds[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
        }
        if(currentState.equals("We're playing!")) {
            g.drawImage(backgrounds[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
            String printPoints = "" + theGame.getPoints();
            g.setColor(Color.red);
            Font newFont = new Font("TimesRoman Bold", Font.BOLD, 25);
            g.setFont(newFont);
            g.drawString(printPoints + "( " + theGame.getCurrentPlayer() + ") ", 925, 60);
            if(theGame.getCurrentRoll() == 1) {
                g.drawImage(diceBackgrounds[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            else if(theGame.getCurrentRoll() == 2) {
                g.drawImage(diceBackgrounds[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            else if(theGame.getCurrentRoll() == 3) {
                g.drawImage(diceBackgrounds[2], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            else if(theGame.getCurrentRoll() == 4) {
                g.drawImage(diceBackgrounds[3], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            else if(theGame.getCurrentRoll() == 5) {
                g.drawImage(diceBackgrounds[4], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            else if(theGame.getCurrentRoll() == 6) {
                g.drawImage(diceBackgrounds[5], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            }
            g.drawString(printPoints + "( " + theGame.getCurrentPlayer() + ") ", 925, 60);
//            if(theGame.getCurrentRoll() == 1) {
//                theGame.printPoints(theGame.points1);
//            }
        }
        else if(currentState.equals("It's over")) {
            g.drawString("THANKS FOR PLAYING!", 500, 400);
        }
    }
}
