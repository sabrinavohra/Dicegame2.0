// Sabrina Vohra
import java.util.Scanner;
// Game class
public class Game
{
    // Initializes instance variables for Game class
    // Initializes number of sides on all die
    private final int NUM_SIDES = 6;
    // Initializes Die object
    private Die d1;
    // Initializes points for first user
    private int points1 = 0;
    // Initializes points for second user
    private int points2 = 0;
    // Initializes name for first user
    private String player1;
    // Initializes name for second user
    private String player2;
    // Initializes boolean to know which player is currently playing
    private boolean currentPlayer;
    // Initializes front end object
    private GameView window;
    // Initializes String to know which part of the game is being played
    private String currentState;
    // Initializes boolean to recognize which player won the game
    private boolean theWinner;
    // Initializes number that was rolled
    private int currentRoll;

    // Constructor for Game object
    public Game()
    {
        // Initializes dice object
        d1 = new Die();
        // Sets currentPlayer to player1
        currentPlayer = true;
        // Sets GameView object
        window = new GameView(this);
    }

    // Method to print the rules
    public void rules() {
        // Sets currentState to the introductory state
        currentState = "Intro";
        // Repaints window
        window.repaint();
        // Prints rules
        System.out.println("Here's how you play: \n");
        System.out.println("In this game, your goal is to win 30 points before your opponent. You will be prompted to " +
                "guess a number before you roll your die. The guess is the lowest number you think the roll will be. " +
                " If the number you guessed is greater than the roll, you win the number of points of your guess. If " +
                "the roll is less than your guess, your score resets to 0 points. Good luck :)!");
        // Creates Scanner object for input
        Scanner input = new Scanner(System.in);
        // Asks for users' names
        System.out.println("What's Player 1's name? ");
        player1 = input.nextLine();
        System.out.println("What's Player 2's name?");
        player2 = input.nextLine();
    }

    // Method for the Game
    public void basicGame() {
        while (points1 < 30 && points2 < 30) {
            currentState = "We're playing!";
            Scanner input = new Scanner(System.in);
            if(currentPlayer == true) {
                System.out.println("Hi " + player1 + "! What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                currentRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + currentRoll);
                if (d1.lessThan(guess, currentRoll) == true) {
                    points1 += guess;
                } else {
                    points1 = 0;
                }
                printPoints(points1);
                window.repaint();
                currentPlayer = false;
            }
            else if(!currentPlayer) {
                System.out.println("Hi " + player2 + " What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                currentRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + currentRoll);
                if (d1.lessThan(guess, currentRoll)) {
                    points2 += guess;
                } else {
                    points2 = 0;
                }
                printPoints(points2);
                window.repaint();
                currentPlayer = true;
            }
        }
        currentState = "It's over";
        if(points1 == 30) {
            theWinner = true;
        }
        theWinner = false;
        window.repaint();
    }

    public void playGame() {
        rules();
        window.repaint();
        basicGame();
        window.repaint();
    }

    public void printPoints(int points)
    {
        System.out.println("You have " + points + " points."); //CALLS OUTSIDE METHOD
    }

    public int getPoints() {
        if(currentPlayer) {
            return points2;
        }
        return points1;
    }

    public void invalid(int guess) {
        if(guess > NUM_SIDES)
        {
            System.out.println("Your guess is a " + NUM_SIDES);
        }
        else if(guess < 0)
        {
            guess = 0;
            System.out.println("Your guess is a 1");
        }
        else
        {
            System.out.println("Your guess is a " + guess);
        }
    }

    public String getCurrentState() {
        return this.currentState;
    }

    public int getCurrentRoll() {
        return this.currentRoll;
    }

    public boolean getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean getTheWinner() {
        return theWinner;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void win()
    {
        System.out.println("YOU WIN!!");
    }

    public static void main(String[] args)
    {
        Game one = new Game();
        one.playGame();
    }
}