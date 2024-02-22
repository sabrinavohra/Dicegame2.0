import java.util.Scanner;
import java.awt.Graphics;
public class Game
{
    private final int NUM_SIDES = 6;
    private Die d1;
    private int points1;
    private int points2;
    private String player1;
    private String player2;
    private boolean currentPlayer;
    private GameView window;
    private String currentState;
    private boolean theWinner;
    private int currentRoll;

    public Game()
    {
        d1 = new Die();
        points1 = 0;
        points2 = 0;
        currentPlayer = true;
        currentState = "Intro";
        window = new GameView(this);
    }

    public void rules() {
        currentState = "Intro";
        window.repaint();
        System.out.println("Here's how you play: \n");
        System.out.println("The computer will ask you to guess a number on a die with the\n" +
                "number of sides of your choosing. Then, it will roll the die. \nIf the " +
                "number you guessed is greater than the roll, you win \nthe number of " +
                "points of your guess. The goal is to get to \n30 points, but if " +
                "your guess is wrong, your score resets to \n0. Good luck! :) \n");
        Scanner input = new Scanner(System.in);
        System.out.println("What's Player 1's name? ");
        player1 = input.nextLine();
        System.out.println("What's Player 2's name?");
        player2 = input.nextLine();
    }

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