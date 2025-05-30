import java.util.ArrayList;
import java.util.Random;

public class Farm
{
    private Sheep[] sheep;

    private String name;
    private State state;

    private final int valuePerSheep = 150;
    private final int valuePerLamb = 250;
    private final int valuePerAlpaca = 1000;

    private final int alpacaHiringCost = 500;
    private final int alpacaMaintenanceCost = (int) (new Random().nextFloat() * 200 + 400);

    // Constructors
    public Farm()
    {
        name = null;
        state = new State(null, new ArrayList<Predator>());
        sheep = null;
    }

    public Farm(String _name, State _state, int num_sheep, int num_lamb)
    {
        name = _name;
        state = _state;

        sheep = new Sheep[num_sheep + num_lamb];
        for (int i = 0; i < num_sheep; ++i)
            sheep[i] = new Sheep(false);

        for (int i = num_sheep; i < num_sheep + num_lamb; ++i)
            sheep[i] = new Sheep(true);
    }

    // Methods in alphabetical order
    public int getAlpacaHiringCost()
    {
        return alpacaHiringCost;
    }

    public int getAlpacaMaintenanceCost()
    {
        return alpacaMaintenanceCost;
    }

    public String GetFarmName()
    {
        return name;
    }
    
    public State GetFarmState()
    {
        return state;
    }

    public String getName()
    {
        return name;
    }

    public Sheep[] getSheep()
    {
        return sheep;
    }

    public State getState()
    {
        return state;
    }

    public int getValuePerAlpaca()
    {
        return valuePerAlpaca;
    }

    public int getValuePerLamb()
    {
        return valuePerLamb;
    }

    public int getValuePerSheep()
    {
        return valuePerSheep;
    }

    public void SetFarmName(String _name)
    {
        name = _name;
    }

    public void SetFarmState(State _state)
    {
        state = _state;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSheep(Sheep[] sheep)
    {
        this.sheep = sheep;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public SimulationManager.SimulationResult Simulation(int num_alpaca)
    {
        for (Sheep s : sheep)
            s.Reset();

        SimulationManager.SimulationResult res = new SimulationManager.SimulationResult(state.GetPredatorList());
        
        // Calculate alpaca losses
        int alpacaLost = 0;
        for (int i = 0; i < num_alpaca; ++i)
        {
            for (int j = 0; j < state.GetPredatorList().size(); ++j)
            {
                if (new Random().nextFloat() < (state.GetPredatorList().get(j).getDangerFactor() / 100))
                {
                    alpacaLost += 1;
                    break;
                }
            }
        }
        res.setNumAlpacaLost(alpacaLost);
        
        // Calculate costs
        int totalCost = 0;
        totalCost += num_alpaca > 0 ? alpacaHiringCost : 0;
        totalCost += alpacaLost > 0 ? alpacaLost * valuePerAlpaca : 0;
        totalCost += num_alpaca > 0 ? (alpacaLost > 0 ? (alpacaMaintenanceCost / 2) : alpacaMaintenanceCost) : 0;

        int sheepLost = 0;
        int lambLost = 0;
        ArrayList<Integer> predatorKills = new ArrayList<Integer>();
        for (int i = 0; i < state.GetPredatorList().size(); i++) {
            predatorKills.add(0);
        }

        for (Sheep s : sheep)
        {
            for (int i = 0; i < state.GetPredatorList().size(); ++i)
            {
                if (s.PredatorAction(state.GetPredatorList().get(i), num_alpaca - alpacaLost))
                {
                    totalCost += s.getIsLamb() ? valuePerLamb : valuePerSheep;
                    if (s.getIsLamb()) {
                        lambLost += 1;
                    } else {
                        sheepLost += 1;
                    }
                    predatorKills.set(i, predatorKills.get(i) + 1);
                    break;
                }
            }
        }
        
        res.setTotalCost(totalCost);
        res.setNumSheepLost(sheepLost);
        res.setNumLambLost(lambLost);
        res.setNumAnimalLostByPredator(predatorKills);        return res;
    }

    @Override
    public String toString()
    {
        return "Farm{" +
               "name='" + name + '\'' +
               ", state=" + state.GetStateName() +
               ", numSheep=" + (sheep != null ? sheep.length : 0) +
               ", valuePerSheep=" + valuePerSheep +
               ", valuePerLamb=" + valuePerLamb +
               ", valuePerAlpaca=" + valuePerAlpaca +
               ", alpacaHiringCost=" + alpacaHiringCost +
               ", alpacaMaintenanceCost=" + alpacaMaintenanceCost +
               '}';
    }
}