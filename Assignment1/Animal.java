public class Animal 
{
    private String name;
    private int score;

    public Animal() 
    {
        name = "NULL";
        score = 0;
    }

    /**
     * 
     * @param _name  name of the animal
     * @param _score score of the animal
     */
    public Animal(String _name, int _score) 
    {
        name = _name;
        score = _score;
    }

    public String getName() 
    {
        return name;
    }

    public int getScore() 
    {
        return score;
    }

    public String toString() 
    {
        return "Animal: name = " + name + " ,score = " + score;
    }
}