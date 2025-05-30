import java.util.ArrayList;

public class State
{
    private String name;
    private ArrayList<Predator> predators;

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

    public String GetStateName()
    {
        return name;
    }

    public ArrayList<Predator> GetPredatorList()
    {
        return predators;
    }

    public void SetStateName(String _name)
    {
        name = _name;
    }

    public void SetPredatorList(ArrayList<Predator> _predators)
    {
        predators = _predators;
    }
}
