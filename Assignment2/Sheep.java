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

    boolean PredatorAction(Predator predator, int numAlpacaGuarded)
    {
        float probability = (isLamb ? 2 : 1) * predator.getDangerFactor();
        probability = numAlpacaGuarded <= 0 ? probability : (probability / (2 * numAlpacaGuarded));
        isAlive = !(random.nextFloat() < probability);
        killBy = !isAlive ? predator : null;
        return !isAlive;
    }

    boolean IsLamb()
    {
        return isLamb;
    }

    Predator KillBy()
    {
        return killBy;
    }

    void Reset()
    {
        isAlive = true;
        killBy = null;
    }
}