public class Animal
{
    protected boolean isAlive;

    // Constructors
    Animal()
    {
        isAlive = true;
    }

    Animal(boolean _isAlive)
    {
        isAlive = _isAlive;
    }

    // Methods in alphabetical order
    public boolean getIsAlive()
    {
        return isAlive;
    }

    public Boolean IsAlive()
    {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    @Override
    public String toString()
    {
        return "Animal{" +
               "isAlive=" + isAlive +
               '}';
    }
}
