import java.util.ArrayList;

public class State
{
    private String name;
    private ArrayList<Predator> predators;

    // Constructors
    public State()
    {
        name = null;
        predators = new ArrayList<Predator>();
    }

    public State(String _name, ArrayList<Predator> _predators)
    {
        name = _name;
        predators = _predators;
    }

    // Methods in alphabetical order
    public ArrayList<Predator> GetPredatorList()
    {
        return predators;
    }

    public String GetStateName()
    {
        return name;
    }

    public void SetPredatorList(ArrayList<Predator> _predators)
    {
        predators = _predators;
    }

    public void SetStateName(String _name)
    {
        name = _name;
    }

    @Override
    public String toString()
    {
        return "State{" +
               "name='" + name + '\'' +
               ", predators=" + predators +
               '}';
    }
}
