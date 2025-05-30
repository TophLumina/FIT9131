public class Predator extends Animal
{
    private String name;
    private float dangerFactor;

    Predator(String _name, float _danger_factor)
    {
        super();
        name = _name;
        dangerFactor = _danger_factor;
    }

    String getName()
    {
        return name;
    }

    float getDangerFactor()
    {
        return dangerFactor;
    }

    void setName(String _name)
    {
        name = _name;
    }

    void setDangerFactor(float _danger_factor)
    {
        dangerFactor = _danger_factor;
    }
}
