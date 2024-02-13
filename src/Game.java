import java.util.Scanner;
public class Game
{
    private Die d1;
    private String player1;
    private String player2;
    private int points1 = 0;
    private int points2 = 0;
    private int numSides;
    private GameView window;
    private String currentState;
    private boolean currentPlayer;

    public Game()
    {
        d1 = new Die();
        numSides = 0;;
        window = new GameView(this);
        Scanner s = new Scanner(System.in);
        System.out.println("What is Player 1's name? ");
        player1 = s.nextLine();
        System.out.println("What is Player 2's name? ");
        player2  = s.nextLine();
        currentPlayer = true;
    }

    public void rules()
    {
        System.out.println("Here's how you play: \n");
        System.out.println("The computer will ask you to guess a number on a die with the\n" +
                "number of sides of your choosing. Then, it will roll the die. \nIf the " +
                "number you guessed is greater than the roll, you win \nthe number of " +
                "points of your guess. The goal is to get to \n30 points, but if " +
                "your guess is wrong, your score resets to \n0. Good luck! :) \n");
    }

    public void basicGame() {
        Scanner input = new Scanner(System.in);
        while(points1 < 30 && points2 < 30) {
            if(currentPlayer == true) {
                System.out.println("What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                int thisRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + thisRoll);
                if(d1.lessThan(guess,thisRoll) == true)
                {
                    points1 += guess;
                }
                else
                {
                    points1 = 0;
                }
                currentPlayer = false;
            }
            else if (currentPlayer == false) {
                System.out.println("What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                int thisRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + thisRoll);
                if(d1.lessThan(guess,thisRoll) == true)
                {
                    points2 += guess;
                }
                else
                {
                    points2 = 0;
                }
                currentPlayer = true;
            }
        }
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);
        currentState = "Intro";
        rules();
        basicGame();
    }

    public void printPoints(String player, int points)
    {
        System.out.println(player + " has " + points + " points."); //CALLS OUTSIDE METHOD
    }

    public void invalid(int guess)
    {
        if(guess > numSides)
        {
            System.out.println("Your guess is a " + numSides);
        }
        else if(guess < 1)
        {
            guess = 1;
            System.out.println("Your guess is a 1");
        }
        else
        {
            System.out.println("Your guess is a " + guess);
        }
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