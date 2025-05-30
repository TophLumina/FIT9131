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

    public String GetFarmName()
    {
        return name;
    }
    
    public State GetFarmState()
    {
        return state;
    }

    public void SetFarmName(String _name)
    {
        name = _name;
    }

    public void SetFarmState(State _state)
    {
        state = _state;
    }

    public SimulationResult Simulation(int num_alpaca)
    {
        for (Sheep s : sheep)
            s.Reset();

        SimulationResult res = new SimulationResult(state.GetPredatorList());        for (int i = 0; i < num_alpaca; ++i)
        {
            for (int j = 0; j < state.GetPredatorList().size(); ++j)
            {
                if (new Random().nextFloat() < (state.GetPredatorList().get(j).getDangerFactor() / 100))
                {
                    res.numAlpacaLost += 1;
                    break;
                }
            }
        }        res.totalCost += num_alpaca > 0 ? alpacaHiringCost : 0;
        res.totalCost += res.numAlpacaLost > 0 ? res.numAlpacaLost * valuePerAlpaca : 0;
        res.totalCost += num_alpaca > 0 ? (res.numAlpacaLost > 0 ? (alpacaMaintenanceCost / 2) : alpacaMaintenanceCost) : 0;

        for (Sheep s : sheep)
        {
            for (int i = 0; i < state.GetPredatorList().size(); ++i)
            {
                if (s.PredatorAction(state.GetPredatorList().get(i), num_alpaca - res.numAlpacaLost))
                {
                    res.totalCost += s.IsLamb() ? valuePerLamb : valuePerSheep;
                    res.numSheepLost += s.IsLamb() ? 0 : 1;
                    res.numLambLost += s.IsLamb() ? 1 : 0;
                    res.numAnimalLostByPredator.set(i, res.numAnimalLostByPredator.get(i) + 1);
                    break;
                }
            }
        }

        return res;
    }
}