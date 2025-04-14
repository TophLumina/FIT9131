import java.util.Random;

public class Dice
{
    private int numberOfSides;
    private Random random;

    public Dice()
    {
        random = new Random();
        numberOfSides = 0;
    }

    /**
     * 
     * @param _numSides sides of the dice (eg. 4 ,6, 12, 20, 100)
     */
    public Dice(int _numSides)
    {
        random = new Random();
        numberOfSides = _numSides;
    }
    
    public int getNumberOfSides()
    {
        return numberOfSides;
    }
    
    public void setNumberOfSides(int _numSides)
    {
        numberOfSides = _numSides;
    }
    
    /**
     * 
     * @return a rodom number ranging from 1 to numberOfSides
     */
    public int roll()
    {
        return random.nextInt(numberOfSides) + 1;
    }
    
    public String toString()
    {
        return "Dice: numberOfSides = " + numberOfSides;
    }
}