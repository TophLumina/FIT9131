import java.util.Random;

class Sheep extends Animal
{
    private boolean isLamb;
    private static Random random;

    static
    {
        random = new Random();
    }

    // Constructors
    public Sheep()
    {
        super();
        isLamb = false;
    }

    public Sheep(boolean _isLamb)
    {
        super();
        isLamb = _isLamb;
    }

    // Methods in alphabetical order
    public boolean getIsLamb()
    {
        return isLamb;
    }

    boolean PredatorAction(Predator predator, int numAlpacaGuarded)
    {
        float probability = (isLamb ? 2 : 1) * predator.getDangerFactor();
        probability = numAlpacaGuarded <= 0 ? probability : (probability / (2 * numAlpacaGuarded));
        isAlive = !(random.nextFloat() < probability);
        return !isAlive;
    }

    public void Reset()
    {
        isAlive = true;
    }

    public void setIsLamb(boolean isLamb)
    {
        this.isLamb = isLamb;
    }

    @Override
    public String toString()
    {
        return "Sheep{" +
               "isLamb=" + isLamb +
               ", isAlive=" + isAlive +
               '}';
    }
}