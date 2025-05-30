import java.util.Random;

class Sheep extends Animal
{
    private boolean isLamb;
    private Predator killBy;
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
        killBy = null;
    }

    public Sheep(boolean _isLamb)
    {
        super();
        isLamb = _isLamb;
        killBy = null;
    }

    // Methods in alphabetical order
    public boolean getIsLamb()
    {
        return isLamb;
    }

    public Predator getKillBy()
    {
        return killBy;
    }

    boolean PredatorAction(Predator predator, int numAlpacaGuarded)
    {
        float probability = (isLamb ? 2 : 1) * predator.getDangerFactor();
        probability = numAlpacaGuarded <= 0 ? probability : (probability / (2 * numAlpacaGuarded));
        isAlive = !(random.nextFloat() < probability);
        killBy = !isAlive ? predator : null;
        return !isAlive;
    }

    public void Reset()
    {
        isAlive = true;
        killBy = null;
    }

    public void setIsLamb(boolean isLamb)
    {
        this.isLamb = isLamb;
    }

    public void setKillBy(Predator killBy)
    {
        this.killBy = killBy;
    }

    @Override
    public String toString()
    {
        return "Sheep{" +
               "isLamb=" + isLamb +
               ", killBy=" + (killBy != null ? killBy.getName() : "null") +
               ", isAlive=" + isAlive +
               '}';
    }
}