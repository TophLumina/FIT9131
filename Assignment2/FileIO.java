import java.io.*;
import java.util.ArrayList;

public class FileIO
{
    // Methods in alphabetical order
    public static ArrayList<State> readPredatorsFromFile(String filename)
    {
        ArrayList<State> states = new ArrayList<State>();

        try (FileReader fr = new FileReader(filename))
        {
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1)
            {
                content.append((char) ch);
            }

            String[] lines = content.toString().split("\n");
            for (String line : lines)
            {
                line = line.trim();
                if (!line.isEmpty())
                {
                    String[] parts = line.split(",");
                    if (parts.length >= 5)
                    {
                        String stateName = parts[0];
                        ArrayList<Predator> predators = new ArrayList<Predator>();

                        predators.add(new Predator("Fox", Float.parseFloat(parts[1])));
                        predators.add(new Predator("Dingo", Float.parseFloat(parts[2])));
                        predators.add(new Predator("Feral Pig", Float.parseFloat(parts[3])));
                        predators.add(new Predator("Wedge-tailed Eagle", Float.parseFloat(parts[4])));

                        states.add(new State(stateName, predators));
                    }
                }
            }
        } catch (IOException e)
        {
            System.out.println("Error reading predators file: " + e.getMessage());
        }

        return states;
    }

    public static void writeSummaryToFile(String filename, String farmName, int numSheep, int numLambs,
            String recommendedProtection, int recommendedCost,
            int predictedLoss, String troublesomePredator)
            {
        try (FileWriter fw = new FileWriter(filename))
        {
            fw.write("Farm Name: " + farmName + "\n");
            fw.write("Number of Sheep: " + numSheep + "\n");
            fw.write("Number of Lambs: " + numLambs + "\n");
            fw.write("Recommended Protection Level: " + recommendedProtection + " (Cost: $" + recommendedCost + ")"
                    + "\n");
            fw.write("Predicted Animals Lost: " + predictedLoss + "\n");
            fw.write("Most Troublesome Predator: " + troublesomePredator + "\n");
        } catch (IOException e)
        {
            System.out.println("Error writing summary file: " + e.getMessage());
        }
    }
}
