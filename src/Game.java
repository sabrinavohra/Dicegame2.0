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
        // Sets currentState to introductory state
        currentState = "Intro";
        // Sets currentPlayer to player1
        currentPlayer = true;
        // Sets GameView object
        window = new GameView(this);
    }

    // Method to print the rules
    public void rules() {
        // Repaints window
        window.repaint();
        // Prints rules
        System.out.println("Here's how you play: \n");
        System.out.println("In this game, your goal is to win 30 points before your opponent. You will be prompted to " +
                "\nguess a number before you roll your die. The guess is the lowest number you think the roll will be. " +
                " \nIf the number you guessed is greater than the roll, you win the number of points of your guess. If " +
                "\nthe roll is less than your guess, your score resets to 0 points. Good luck :)!");
        // Creates Scanner object for input
        Scanner input = new Scanner(System.in);
        // Asks for users' names
        System.out.println("What's Player 1's name? ");
        player1 = input.nextLine();
        System.out.println("What's Player 2's name?");
        player2 = input.nextLine();
    }

    // Method to play the Game
    public void basicGame() {
        // Runs game while both users haven't yet won
        while (points1 < 30 && points2 < 30) {
            // Sets current state to the playing state
            currentState = "We're playing!";
            // Declares Scanner for input
            Scanner input = new Scanner(System.in);
            // Runs game for first player
            if(currentPlayer == true) {
                // Asks player to guess
                System.out.println("Hi " + player1 + "! What is the lowest number this roll will be? ");
                // Saves guess
                int guess = input.nextInt();
                // Makes sure that guess is a valid number
                invalid(guess);
                // Rolls die
                currentRoll = d1.roll(); // CALLS OUTSIDE METHOD
                // Tells user what number they rolled
                System.out.println("You rolled a: " + currentRoll);
                // Awards points depending on guess and roll
                if (d1.lessThan(guess, currentRoll) == true) {
                    points1 += guess;
                }
                else {
                    points1 = 0;
                }
                // Prints points for player 1
                printPoints(points1);
                // Repaints window for other player
                window.repaint();
                // Changes to second player
                currentPlayer = false;
            }
            // Runs turn for second player
            else if(!currentPlayer) {
                // Runs similar system for second player
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
                // Changes back to player 1
                currentPlayer = true;
            }
        }
        // After a user has won, sets state to ending state
        currentState = "It's over";
        // Saves which user won
        if(points1 == 30) {
            theWinner = true;
        }
        theWinner = false;
        // Repaints window for ending state
        window.repaint();
    }

    // Runs game
    public void playGame() {
        // Prints rules
        rules();
        // Paints window
        window.repaint();
        // Plays game
        basicGame();
        // Paints window again
        window.repaint();
    }

    // Method prints points
    public void printPoints(int points)
    {
        System.out.println("You have " + points + " points."); //CALLS OUTSIDE METHOD
    }

    // Method gets points for given player
    public int getPoints() {
        // Retrieves points for player depending on which player is currently playing
        if(currentPlayer) {
            return points2;
        }
        return points1;
    }

    // Method checks to make sure guesses are valid and corrects them if not
    public void invalid(int guess) {
        // Makes guess equal to 6 if user inputs a guess that's greater
        if(guess > NUM_SIDES) {
            System.out.println("Your guess is a " + NUM_SIDES);
        }
        // Makes guess equal to 0 if user inputs a guess less than 0
        else if(guess < 0) {
            guess = 0;
            System.out.println("Your guess is a 1");
        }
        // Otherwise will print the user's guess
        System.out.println("Your guess is a " + guess);
    }

    // Method returns current state in Game
    public String getCurrentState() {
        return this.currentState;
    }

    // Method returns current roll in Game
    public int getCurrentRoll() {
        return this.currentRoll;
    }

    //Method returns boolean for which player is playing
    public boolean getCurrentPlayer() {
        return this.currentPlayer;
    }

    // Method returns the winner of the Game
    public boolean getTheWinner() {
        return theWinner;
    }

    // Method returns Player 1's name
    public String getPlayer1() {
        return player1;
    }

    // Method returns Player 2's name
    public String getPlayer2() {
        return player2;
    }

    // Method creates and runs game
    public static void main(String[] args)
    {
        // Creates and plays Game
        Game one = new Game();
        one.playGame();
    }
}