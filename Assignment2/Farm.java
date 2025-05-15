import java.util.ArrayList;
import java.util.Random;

public class Farm {
    private Sheep[] sheep;
    private ArrayList<Predator> predators;

    private final int valuePerSheep = 150;
    private final int valuePerLamb = 250;
    private final int valuePerAlpaca = 1000;

    private final int alpacaHiringCost = 500;
    private final int alpacaMaintenanceCost = (int) (new Random().nextFloat() * 200 + 400);

    public Farm(int num_sheep, int num_lamb, ArrayList<Predator> _predators) {
        sheep = new Sheep[num_sheep + num_lamb];
        for (int i = 0; i < num_sheep; ++i)
            sheep[i] = new Sheep(false);

        for (int i = num_sheep; i < num_sheep + num_lamb; ++i)
            sheep[i] = new Sheep(true);

        predators = _predators;
    }

    public SimulationResult Simulation(int num_alpaca) {
        for (Sheep s : sheep)
            s.Reset();

        SimulationResult res = new SimulationResult(predators);

        for (int i = 0; i < num_alpaca; ++i) {
            for (int j = 0; j < predators.size(); ++j) {
                if (new Random().nextFloat() < (predators.get(i).getDangerFactor() / 100)) {
                    res.numAlpacaLost += 1;
                    break;
                }
            }
        }

        res.totalCost += num_alpaca > 0 ? alpacaHiringCost : 0;
        res.totalCost += res.numAlpacaLost > 0 ? res.numAlpacaLost * valuePerAlpaca : 0;
        res.totalCost += res.numAlpacaLost > 0 ? (alpacaMaintenanceCost / 2) : alpacaMaintenanceCost;

        for (Sheep s : sheep) {
            for (int i = 0; i < predators.size(); ++i) {
                if (s.PredatorAction(predators.get(i), num_alpaca - res.numAlpacaLost)) {
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