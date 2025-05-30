import java.util.ArrayList;

public class SimulationResult
{
    private int totalCost;
    private int numSheepLost;
    private int numLambLost;
    private int numAlpacaLost;
    private ArrayList<Integer> numAnimalLostByPredator;

    // Constructor
    public SimulationResult(ArrayList<Predator> predators)
    {
        totalCost = 0;
        numSheepLost = 0;
        numLambLost = 0;
        numAlpacaLost = 0;
        numAnimalLostByPredator = new ArrayList<Integer>(predators.size());

        for (int i = 0; i < predators.size(); ++i)
            numAnimalLostByPredator.add(0);
    }

    // Methods in alphabetical order
    public ArrayList<Integer> getNumAnimalLostByPredator()
    {
        return numAnimalLostByPredator;
    }

    public int getNumAlpacaLost()
    {
        return numAlpacaLost;
    }

    public int getNumLambLost()
    {
        return numLambLost;
    }

    public int getNumSheepLost()
    {
        return numSheepLost;
    }

    public int getTotalCost()
    {
        return totalCost;
    }

    public void setNumAlpacaLost(int numAlpacaLost)
    {
        this.numAlpacaLost = numAlpacaLost;
    }

    public void setNumAnimalLostByPredator(ArrayList<Integer> numAnimalLostByPredator)
    {
        this.numAnimalLostByPredator = numAnimalLostByPredator;
    }

    public void setNumLambLost(int numLambLost)
    {
        this.numLambLost = numLambLost;
    }

    public void setNumSheepLost(int numSheepLost)
    {
        this.numSheepLost = numSheepLost;
    }

    public void setTotalCost(int totalCost)
    {
        this.totalCost = totalCost;
    }

    @Override
    public String toString()
    {
        return "SimulationResult{" +
               "totalCost=" + totalCost +
               ", numSheepLost=" + numSheepLost +
               ", numLambLost=" + numLambLost +
               ", numAlpacaLost=" + numAlpacaLost +
               ", numAnimalLostByPredator=" + numAnimalLostByPredator +
               '}';
    }
}
