import java.util.ArrayList;

public class AlpacaSheepGuards
{

    public static void main(String[] args)
    {
        // Display welcome message
        System.out.println("Welcome to the Alpaca Sheep Guards Simulation Program");
        System.out.println("This program evaluates the viability of using alpacas to protect sheep flocks.");
        System.out.println();

        // Read predator data from file
        ArrayList<State> states = FileIO.readPredatorsFromFile("predators.txt");
        if (states.isEmpty())
        {
            System.out.println("Error: Could not read predator data from file.");
            return;
        }

        // Get user input
        String farmName = "";
        while (farmName.length() < 6)
        {
            farmName = Input.acceptStringInput("Enter farm name (must be 6 characters or more):");
            if (farmName.length() < 6)
            {
                System.out.println("Farm name must be at least 6 characters long.");
            }
        }

        String stateName = "";
        State selectedState = null;
        while (selectedState == null)
        {
            stateName = Input.acceptStringInput("Enter state (NSW, VIC, SA, or WA):").toUpperCase();
            for (State state : states)
            {
                if (state.GetStateName().equals(stateName))
                {
                    selectedState = state;
                    break;
                }
            }
            if (selectedState == null)
            {
                System.out.println("Invalid state. Please enter NSW, VIC, SA, or WA.");
            }
        }

        int numSheep = 0;
        int numLambs = 0;
        int totalAnimals = 0;

        while (totalAnimals <= 0)
        {
            numSheep = Input.acceptIntegerInput("Enter number of sheep:");
            numLambs = Input.acceptIntegerInput("Enter number of lambs:");
            totalAnimals = numSheep + numLambs;

            if (totalAnimals <= 0)
            {
                System.out.println("Total number of animals must be greater than 0.");
            }
        }

        // Create farm
        Farm farm = new Farm(farmName, selectedState, numSheep, numLambs);

        // Run simulations
        System.out.println("\nRunning simulations...\n");

        // No protection
        System.out.println("=== No Alpaca Protection ===");
        SimulationManager.SimulationSummary noProtection = SimulationManager.runSimulation(farm, 0, 10);
        System.out.println(noProtection.toString());

        // Single alpaca protection
        System.out.println("=== Single Alpaca Protection ===");
        SimulationManager.SimulationSummary singleAlpaca = SimulationManager.runSimulation(farm, 1, 10);
        System.out.println(singleAlpaca.toString());

        // Pair of alpacas protection
        System.out.println("=== Pair of Alpacas Protection ===");
        SimulationManager.SimulationSummary pairAlpacas = SimulationManager.runSimulation(farm, 2, 10);
        System.out.println(pairAlpacas.toString());

        // Determine recommendations
        SimulationManager.SimulationSummary recommended = noProtection;
        String protectionLevel = "No Protection";

        if (singleAlpaca.averageTotalCost < recommended.averageTotalCost)
        {
            recommended = singleAlpaca;
            protectionLevel = "Single Alpaca";
        }

        if (pairAlpacas.averageTotalCost < recommended.averageTotalCost)
        {
            recommended = pairAlpacas;
            protectionLevel = "Pair of Alpacas";
        }

        // Find most troublesome predator
        String troublesomePredator = "";
        double maxKilled = 0;
        for (int i = 0; i < recommended.predatorNames.length; i++)
        {
            if (recommended.averageKilledByPredator[i] > maxKilled)
            {
                maxKilled = recommended.averageKilledByPredator[i];
                troublesomePredator = recommended.predatorNames[i];
            }
        }

        // Find predators that didn't kill any animals
        ArrayList<String> harmlessPredators = new ArrayList<String>();
        for (int i = 0; i < recommended.predatorNames.length; i++)
        {
            if (recommended.averageKilledByPredator[i] == 0)
            {
                harmlessPredators.add(recommended.predatorNames[i]);
            }
        }

        // Display final recommendations
        System.out.println("=== RECOMMENDATIONS ===");
        System.out.println("Recommended Protection Level: " + protectionLevel);
        System.out.println("Average Cost: $" + String.format("%.2f", recommended.averageTotalCost));
        System.out.println("Most Troublesome Predator: " + troublesomePredator);

        if (!harmlessPredators.isEmpty())
        {
            System.out.println("Predators that caused no losses: " + String.join(", ", harmlessPredators));
        }

        // Write summary to file
        int predictedAnimalsLost = (int) Math
                .round(recommended.averageSheepLost + recommended.averageLambsLost + recommended.averageAlpacasLost);
        FileIO.writeSummaryToFile("alpacaSheepGuardViability.txt", farmName, numSheep, numLambs,
                protectionLevel, (int) Math.round(recommended.averageTotalCost),
                predictedAnimalsLost, troublesomePredator);

        System.out.println("\nSummary written to alpacaSheepGuardViability.txt");
    }
}
