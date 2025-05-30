public class Predator extends Animal
{
    private String name;
    private float dangerFactor;

    // Constructor
    public Predator(String _name, float _danger_factor)
    {
        super();
        name = _name;
        dangerFactor = _danger_factor;
    }

    // Methods in alphabetical order
    public float getDangerFactor()
    {
        return dangerFactor;
    }

    public String getName()
    {
        return name;
    }

    public void setDangerFactor(float _danger_factor)
    {
        dangerFactor = _danger_factor;
    }

    public void setName(String _name)
    {
        name = _name;
    }

    @Override
    public String toString()
    {
        return "Predator{" +
               "name='" + name + '\'' +
               ", dangerFactor=" + dangerFactor +
               ", isAlive=" + isAlive +
               '}';
    }
}
