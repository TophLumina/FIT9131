import java.util.ArrayList;

public class SimulationManager
{
    // Nested class
    public static class SimulationSummary
    {
        public double averageTotalCost;
        public int lowestTotalCost;
        public int highestTotalCost;
        public double averageSheepLost;
        public double averageLambsLost;
        public double averageAlpacasLost;
        public double[] averageKilledByPredator;
        public String[] predatorNames;

        // Constructor
        public SimulationSummary(int numPredators)
        {
            averageKilledByPredator = new double[numPredators];
            predatorNames = new String[numPredators];
        }

        // Methods in alphabetical order
        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Average Total Cost: $" + String.format("%.2f", averageTotalCost) + "\n");
            sb.append("Lowest Total Cost: $" + lowestTotalCost + "\n");
            sb.append("Highest Total Cost: $" + highestTotalCost + "\n");
            sb.append("Average Sheep Lost: " + String.format("%.1f", averageSheepLost) + "\n");
            sb.append("Average Lambs Lost: " + String.format("%.1f", averageLambsLost) + "\n");
            sb.append("Average Alpacas Lost: " + String.format("%.1f", averageAlpacasLost) + "\n");
            sb.append("Average Animals Killed by Predator:\n");
            for (int i = 0; i < predatorNames.length; i++)
            {
                sb.append("  " + predatorNames[i] + ": " + String.format("%.1f", averageKilledByPredator[i]) + "\n");
            }
            return sb.toString();
        }
    }

    // Methods in alphabetical order
    public static SimulationSummary runSimulation(Farm farm, int numAlpacas, int numRuns)
    {
        ArrayList<SimulationResult> results = new ArrayList<SimulationResult>();

        for (int i = 0; i < numRuns; i++)
        {
            results.add(farm.Simulation(numAlpacas));
        }

        SimulationSummary summary = new SimulationSummary(farm.GetFarmState().GetPredatorList().size());

        // Initialize predator names
        for (int i = 0; i < farm.GetFarmState().GetPredatorList().size(); i++)
        {
            summary.predatorNames[i] = farm.GetFarmState().GetPredatorList().get(i).getName();
        }

        // Calculate statistics
        int totalCostSum = 0;
        int totalSheepLost = 0;
        int totalLambsLost = 0;
        int totalAlpacasLost = 0;
        int[] totalKilledByPredator = new int[summary.averageKilledByPredator.length];

        summary.lowestTotalCost = Integer.MAX_VALUE;
        summary.highestTotalCost = Integer.MIN_VALUE;        for (SimulationResult result : results)
        {
            totalCostSum += result.getTotalCost();
            totalSheepLost += result.getNumSheepLost();
            totalLambsLost += result.getNumLambLost();
            totalAlpacasLost += result.getNumAlpacaLost();

            if (result.getTotalCost() < summary.lowestTotalCost)
            {
                summary.lowestTotalCost = result.getTotalCost();
            }
            if (result.getTotalCost() > summary.highestTotalCost)
            {
                summary.highestTotalCost = result.getTotalCost();
            }

            for (int i = 0; i < totalKilledByPredator.length; i++)
            {
                totalKilledByPredator[i] += result.getNumAnimalLostByPredator().get(i);
            }
        }

        summary.averageTotalCost = (double) totalCostSum / numRuns;
        summary.averageSheepLost = (double) totalSheepLost / numRuns;
        summary.averageLambsLost = (double) totalLambsLost / numRuns;
        summary.averageAlpacasLost = (double) totalAlpacasLost / numRuns;

        for (int i = 0; i < summary.averageKilledByPredator.length; i++)
        {
            summary.averageKilledByPredator[i] = (double) totalKilledByPredator[i] / numRuns;
        }

        return summary;
    }
}
