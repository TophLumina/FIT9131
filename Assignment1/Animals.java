import java.util.ArrayList;

public class Animals 
{
    public static ArrayList<Animal> animals;    // ANY change made to animals MUST set the dice to corret sizeNum!
    public static Dice dice;

    static 
    {
        animals = new ArrayList<Animal>(5);
        animals.add(new Animal("Koala", 10));
        animals.add(new Animal("Emu", 7));
        animals.add(new Animal("Wombat", 5));
        animals.add(new Animal("Kangaroo", 2));
        animals.add(new Animal("Rabbit", -5));

        dice = new Dice(animals.size());
    }

    /**
     * 
     * @return  a random animal from animals
     */
    public static Animal randAnimal()
    {
        return animals.get(dice.roll() - 1);
    }
}
