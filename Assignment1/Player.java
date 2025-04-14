public class Player 
{
    private String name;
    private int position;
    private int score;

    public Player() 
    {
        name = "UNKOWN";
        position = -1;
        score = -1;
    }

    /**
     * 
     * @param _name     name of the player
     * @param _position position of the player (on trail)
     * @param _srore    score of the player
     */
    public Player(String _name, int _position, int _srore) 
    {
        name = _name;
        position = _position;
        score = _srore;
    }

    public String getName() 
    {
        return name;
    }

    public int getPosition() 
    {
        return position;
    }

    public int getScore() 
    {
        return score;
    }

    public void setName(String _name) 
    {
        name = _name;
    }

    public void setPosition(int _position) 
    {
        position = _position;
    }

    public void setScore(int _score) 
    {
        score = _score;
    }

    public String toString() 
    {
        return "Player:" + " name = " + name + ", position = " + position + ", score = " + score;
    }
}