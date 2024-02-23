public class Die
{
    /** Instance Variables **/
    private int numSides;

    /** Constructors **/

    public Die(int numSides) {
        if (this.numSides < 2) {
            this.numSides = 6;
        }
        else {
            this.numSides = numSides;
        }
        // NOTE: if the user enters an int less than 2
        // set numSides to 6.
    }

    public Die() {
        numSides = 6;
    }

    /** Methods **/

    /**
     * Returns the number of sides on the Die.
     */
    public int getSides() {
        return numSides;
    }

    /**
     * Returns a random int between 1 and
     * the number of sides on the Die
     */
    public int roll() {
        int randomRoll = (int)(Math.random() * numSides + 1);
        return randomRoll;
    }

    public boolean lessThan(int guess, int thisRoll) {
        if (guess <= thisRoll)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Rolls the dice the numRolls times
     * and returns the max value of the rolls
     */
    public int getMaxRoll(int numRolls) {
        int i = 0;
        int bigRoll = 0;
        while(i<numRolls)
        {
            int thisRoll = roll();
            if (thisRoll > bigRoll)
            {
                bigRoll = thisRoll;
            }
            i++;
        }
        return bigRoll;
    }

    public String toString() {
        String dice = "You rolled a: ";
        return dice;
    }
}