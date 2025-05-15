import java.util.ArrayList;

public class AlpacaSheepGuards {
    private Farm farm;
    private int loopSimulation;

    public static void main(String[] args) {
        ArrayList<Predator> predators = new ArrayList<Predator>();
        predators.add(new Predator("a", 0.01f));
        predators.add(new Predator("b", 0.02f));
        predators.add(new Predator("c", 0.03f));
        predators.add(new Predator("d", 0.06f));
        Farm f = new Farm(1000, 1000, predators);

        SimulationResult res = f.Simulation(0);
        for (Predator p : predators) {
            System.out.println(p.getName());
        }
        System.out.println(res.toString());
        res = f.Simulation(1);
        System.out.println(res.toString());
        res = f.Simulation(2);
        System.out.println(res.toString());
    }
}
