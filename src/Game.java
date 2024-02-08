import java.util.Scanner;
public class Game
{
    private final int NUM_SIDES = 6;
    private Die d1;
    private int points1;
    private int points2;
    private String player1;
    private String player2;
    private boolean currentPlayer;

    public Game()
    {
        d1 = new Die();
        points1 = 0;
        points2 = 0;
        currentPlayer = true;
    }

    public void rules() {
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
            Scanner input = new Scanner(System.in);
            if(currentPlayer == true) {
                System.out.println("Hi " + player1 + "! What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                int thisRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + thisRoll);
                if (d1.lessThan(guess, thisRoll) == true) {
                    points1 += guess;
                } else {
                    points1 = 0;
                }
                printPoints(points1);
                currentPlayer = false;
            }
            else if(currentPlayer == false) {
                System.out.println("Hi " + player2 + " What is the lowest number this roll will be? ");
                int guess = input.nextInt();
                invalid(guess);
                int thisRoll = d1.roll(); // CALLS OUTSIDE METHOD
                System.out.println("You rolled a: " + thisRoll);
                if (d1.lessThan(guess, thisRoll) == true) {
                    points2 += guess;
                } else {
                    points2 = 0;
                }
                printPoints(points2);
                currentPlayer = true;
            }
        }
    }

    public void playGame() {
        rules();
        basicGame();
    }

    public void printPoints(int points)
    {
        System.out.println("You have " + points + " points."); //CALLS OUTSIDE METHOD
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

    public void win()
    {
        System.out.println("YOU WIN!!");
    }

    public static void main(String[] args)
    {
        Game one = new Game();
        one.playGame();
    }
    // // Declares scanner for user input
    // Scanner input = new Scanner(System.in);
    // //gives user the rules
    // System.out.println(rules()); // USES METHOD INSIDE DIETESTER CLASS
    // System.out.println("Do you want six sides on your die? Respond true or false.");
    // boolean sixOrNot = input.nextBoolean();
    // if(sixOrNot == true)
    // {
    //     Die d1 = new Die();
    //     int numSides = d1.getSides(); //USES OUTSIDE METHOD
    //     int points = 0;
    //     //creates a loop to run program until the user wins the game
    //     while(points < 30)
    //     {
    //         //asks user for input and a guess
    //         System.out.println("What is the lowest number this roll will be? ");
    //         //declares user's guess
    //         int guess = input.nextInt();
    //         int i = 0;
    //         //changes user's guess if it is invalid
    //         System.out.println(invalid(guess, numSides));
    //         //rolls die
    //         System.out.println(d1);
    //         int thisRoll = d1.roll(); // CALLS OUTSIDE METHOD
    //         i++;
    //         System.out.println(thisRoll);
    //         //awards points for roll
    //         if(d1.lessThan(guess, thisRoll) == true)
    //         {
    //             points += guess;
    //         }
    //         else
    //         {
    //             points = 0;
    //         }
    //         //tells user how many points they have after each round
    //         System.out.println(printPoints(points));
    //         //tells user they've won!
    //         if (points >=30)
    //         {
    //             System.out.println(win());
    //         }
    //     }
    // }
    // else
    // {
    //     System.out.println("How many sides do you want on your die?");
    //     int numSides = input.nextInt();
    //     Die d2 = new Die(numOfSides);
    //     int points = 0;
    //     while(points < 30)
    //     {
    //         System.out.println("What is the lowest number this roll will be? ");
    //         //declares user's guess
    //         int guess = input.nextInt();
    //         int i = 0;
    //         System.out.println (invalid(guess, numOfSides));
    //         //rolls die
    //         int thisRoll = d2.roll(); // CALLS OUTSIDE METHOD
    //         System.out.println("You rolled a: " + thisRoll);
    //         i++;
    //         //awards points for roll
    //         if(d2.lessThan(guess, thisRoll) == true)
    //         {
    //             points += guess;
    //         }
    //         else
    //         {
    //             points = 0;
    //         }
    //         //tells user how many points they have after each round
    //         System.out.println(printPoints(points));
    //         //tells user they've won!
    //         if (points >= 30)
    //         {
    //             System.out.println(win());
    //         }
    //     }
}