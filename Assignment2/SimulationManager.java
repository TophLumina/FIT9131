import java.util.ArrayList;

public class SimulationManager
{
    // Nested class
    public static class SimulationResult
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
