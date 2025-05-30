import java.util.ArrayList;

public class SimulationResult
{
    public int totalCost;
    public int numSheepLost;
    public int numLambLost;
    public int numAlpacaLost;
    public ArrayList<Integer> numAnimalLostByPredator;

    SimulationResult(ArrayList<Predator> predators)
    {
        totalCost = 0;
        numSheepLost = 0;
        numLambLost = 0;
        numAlpacaLost = 0;
        numAnimalLostByPredator = new ArrayList<Integer>(predators.size());

        for (int i = 0; i < predators.size(); ++i)
            numAnimalLostByPredator.add(0);
    }

    public String toString()
    {
        return "Total Cost: " + totalCost + "\n" +
                "Number of Sheep Lost: " + numSheepLost + "\n" +
                "Number of Lamb Lost: " + numLambLost + "\n" +
                "Number of Alpaca Lost: " + numAlpacaLost + "\n" +
                "Number of Animals Lost by Predator: " + numAnimalLostByPredator;
    }
}
