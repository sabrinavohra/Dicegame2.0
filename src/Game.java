import java.util.Scanner;
public class Game
{
    private Die d1;
    private Die d2;
    private int points;
    private int numSides;
    private boolean sixOrNot;

    public Game()
    {
        d1 = new Die();
        d2 = new Die(numSides);
        points = 0;
        numSides = 0;
        sixOrNot = true;
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

    public void basicGame()
    {
        while(points < 30)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("What is the lowest number this roll will be? ");
            //declares user's guess
            int guess = input.nextInt();
            invalid(guess);
            //rolls die
            int thisRoll = d2.roll(); // CALLS OUTSIDE METHOD
            System.out.println("You rolled a: " + thisRoll);
            //i++;
            //awards points for roll
            if (sixOrNot == true)
            {
                if(d1.lessThan(guess,thisRoll) == true)
                {
                    points += guess;
                }
                else
                {
                    points = 0;
                }
            }
            else if (sixOrNot == true)
            {
                if(d2.lessThan(guess, thisRoll) == true)
                {
                    points += guess;
                }
                else
                {
                    points = 0;
                }
            }

            //tells user how many points they have after each round
            printPoints(points);
            //tells user they've won!
            if (points >= 30)
            {
                win();
            }
        }
    }

    public void playGame()
    {
        Scanner input = new Scanner(System.in);

        rules();

        System.out.println("Do you want six sides on your die? Respond true or false.");
        boolean sixOrNot = input.nextBoolean();
        if (sixOrNot == true)
        {
            numSides = 6;
            basicGame();
        }
        else
        {
            System.out.println("How many sides do you want on your die?");
            numSides = input.nextInt();
            basicGame();
        }
    }

    public void printPoints(int points)
    {
        System.out.println("You have " + points + " points."); //CALLS OUTSIDE METHOD
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