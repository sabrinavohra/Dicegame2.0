// Sabrina Vohra
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

// Creates front-end class for Game
public class GameView extends JFrame {
    // Initializes instance variables
    // Initializes width and height of window
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 768;
    // Creates an Array of Images for the background screens when rolling
    private Image[] diceBackgrounds;
    // Creates an Array of Images to store the intro, playing, and end screen backgrounds
    private Image[] backgrounds;
    // Creates instance of the Game to share information between back end and front end
    private Game theGame;

    // Constructor for GameView class
    public GameView(Game theGame) {
        // Sets instance variable to the current Game being played
        this.theGame = theGame;
        // Sets number of and adds backgrounds to Array
        backgrounds = new Image[2];
        backgrounds[0] = new ImageIcon("src/Resources/introBackground.png").getImage();
        backgrounds[1] = new ImageIcon("src/Resources/playingBackground.png").getImage();
        // Sets number of and adds dice backgrounds to Array
        diceBackgrounds = new Image[6];
        diceBackgrounds[0] = new ImageIcon("src/Resources/background1.png").getImage();
        diceBackgrounds[1] = new ImageIcon("src/Resources/background2.png").getImage();
        diceBackgrounds[2] = new ImageIcon("src/Resources/background3.png").getImage();
        diceBackgrounds[3] = new ImageIcon("src/Resources/background4.png").getImage();
        diceBackgrounds[4] = new ImageIcon("src/Resources/background5.png").getImage();
        diceBackgrounds[5] = new ImageIcon("src/Resources/background6.png").getImage();
        // Sets size of window
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Sets title of window
        this.setTitle("Dice Game!");
        // Makes Game exit when window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Allows user to see screen
        this.setVisible(true);
    }

    // Paints screen
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
            g.drawString(printPoints, 925, 60);
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
            g.drawString(printPoints, 925, 60);
        }
        else if(currentState.equals("It's over")) {
            g.setColor(Color.green);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.black);
            if(theGame.getTheWinner() == true) {
                g.drawString(theGame.getPlayer1() + "WINS!", 500, 400);
            }
            else {
                g.drawString(theGame.getPlayer2() + "WINS!", 500, 400);
            }
        }
    }
}
