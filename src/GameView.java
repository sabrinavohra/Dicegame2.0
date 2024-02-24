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
        // Uses back end's info to recognize which screen to print
        String currentState = theGame.getCurrentState();
        // Creates new fonts to use
        Font a = new Font("TimesRoman Bold", Font.BOLD, 25);
        Font b = new Font("TimesRoman Bold", Font.BOLD, 50);
        // Prints introductory screen
        if(currentState.equals("Intro")) {
            // Prints introductory background image
            g.drawImage(backgrounds[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
        }
        // Prints playing screen
        if(currentState.equals("We're playing!")) {
            // Prints background image
            g.drawImage(backgrounds[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
            // Prints user's points
            String printPoints = "" + theGame.getPoints();
            // Sets color for points
            g.setColor(Color.black);
            // Creates new font to use for point values
            g.setFont(a);
            // Prints points for given user
            g.drawString(printPoints, 925, 60);
            // Prints corresponding screen for die's roll
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
            // Prints points
            g.drawString(printPoints, 925, 60);
            currentState = "Home Screen";
        }
        // Prints ending screen
        else if(currentState.equals("It's over")) {
            // Changes window's background to green
            g.setColor(Color.green);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            // Sets color to black to print winning message
            g.setColor(Color.black);
            // Sets font size to be large
            g.setFont(b);
            // Sets coordinate values to print winning message in middle (ish) of screen
            int middleX = 500;
            int middleY = 400;
            // Prints winner's name and message
            if(theGame.getTheWinner()) {
                g.drawString(theGame.getPlayer1() + " WINS!", middleX, middleY);
            }
            else {
                g.drawString(theGame.getPlayer2() + " WINS!", middleX, middleY);
            }
        }
    }
}