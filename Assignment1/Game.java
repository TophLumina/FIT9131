public class Game
{
    private Player humanPlayer;
    private Player computerPlayer;
    private Trail natureTrail;
    private Dice dice;

    public Game()
    {
        humanPlayer = new Player();
        computerPlayer = new Player();
        natureTrail = new Trail();
        dice = new Dice();
    }

    /**
     * 
     * @param _P1    Player no.1
     * @param _P2    Player no.2
     * @param _trail Trail used in the game
     * @param _dice  Dice used in the game
     */
    public Game(Player _P1, Player _P2, Trail _trail, Dice _dice)
    {
        humanPlayer = _P1;
        computerPlayer = _P2;
        natureTrail = _trail;
        dice = _dice;
    }
    
    private void displayPlayerStatus()
    {
        System.out.println(humanPlayer.toString());
        System.out.println(computerPlayer.toString());
        System.out.println();
    }
    
    private void displayTrailWithPlayers() 
    {
        System.out.println(trailPlayersStatus() + '\n');
    }

    public Player getComputerPlayer() 
    {
        return computerPlayer;
    }

    public Dice getDice() 
    {
        return dice;
    }
    
    public Player getHumanPlayer()
    {
        return humanPlayer;
    }
    
    public Trail getNatureTrail()
    {
        return natureTrail;
    }

    private void playerAction(Player player) {
        System.out.println("--------------------< " + player.getName() + "'s Turn >--------------------");
        Input.acceptStringInput("Please press enter to roll the dice.");
        int dice_point = dice.roll();
        System.out.println("Player: " + player.getName() + " Rolling Dice: " + dice_point);
        playerMovedBy(player, dice_point);
        displayTrailWithPlayers();

        if (player.getPosition() == natureTrail.getNatureTrail().length - 1) 
        {
            System.out.println("Player: " + player.getName() + " has reached the finish point and get 10 points as a reward!");
            playerScoredBy(player, 10);
            return;
        }

        Animal animalSpotted = Animals.randAnimal();
        System.out.println(animalSpotted.getName() + " spotted!" + ", Got " + animalSpotted.getScore() + " points!\n");
        playerScoredBy(player, animalSpotted.getScore());

        NatureFeature feature = natureTrail.getNatureTrail()[player.getPosition()];
        int penalty = feature.getSpacePenalty();
        if (penalty != 0) 
        {
            System.out.println("Player: " + player.getName() + " encountered " + feature.getFeatureName() + " now moving by " + penalty);
            playerMovedBy(player, penalty);
            displayTrailWithPlayers();
        }
    }
    
    private void playerMovedBy(Player player, int step) 
    {
        int next = player.getPosition() + step;
        next = next < 0 ? 0 : next;
        next = next < natureTrail.getNatureTrail().length ? next : natureTrail.getNatureTrail().length - 1;

        player.setPosition(next);
    }

    private void playerScoredBy(Player player, int points)
    {
        player.setScore(player.getScore() + points);
    }

    private void requestComplexTrail()
    {
        natureTrail = new Trail(Landscape.getComplexTrail());
    }

    private void requestEasyTrail()
    {
        natureTrail = new Trail(Landscape.getEasyTrail());
    }

    private void requestPlayerName(Player player)
    {
        String user_name = "";
        while (user_name.isBlank())
            user_name = Input.acceptStringInput("Please enter player name for player: " + player.getName()).trim();

        player.setName(user_name);
    }
    
    public void run()
    {
        welcome();
        requestPlayerName(humanPlayer);
        requestComplexTrail();
        displayTrailWithPlayers();

        while (true) {
            playerAction(humanPlayer);
            if (humanPlayer.getPosition() == natureTrail.getNatureTrail().length - 1)
                break;

            playerAction(computerPlayer);
            if (computerPlayer.getPosition() == natureTrail.getNatureTrail().length - 1)
                break;

            displayPlayerStatus();
        }
        System.out.println("\n--------------------< Game Set! >--------------------\n");
        System.out.println("Score Board:");
        System.out.println(humanPlayer.getName() + "\t:\t" + humanPlayer.getScore());
        System.out.println(computerPlayer.getName() + "\t:\t" + computerPlayer.getScore());
        System.out.println(humanPlayer.getScore() == computerPlayer.getScore() ? "Draw!" : (humanPlayer.getScore() > computerPlayer.getScore() ? humanPlayer.getName() : computerPlayer.getName()) + " wins!");
    }
    
    public void setComputerPlayer(Player _player) 
    {
        computerPlayer = _player;
    }

    public void setDice(Dice _dice) 
    {
        dice = _dice;
    }

    public void setHumanPlayer(Player _player) 
    {
        humanPlayer = _player;
    }

    public void setNatureTrail(Trail _trail) 
    {
        natureTrail = _trail;
    }
    
    private String trailPlayersStatus()
    {
        StringBuffer buf = new StringBuffer();
        buf.append('S');
        for (int i = 0; i < natureTrail.getNatureTrail().length; ++i) 
        {
            if (humanPlayer.getPosition() == i && computerPlayer.getPosition() == i) 
            {
                buf.append(" HC");
                continue;
            } 
            else 
            {
                if (humanPlayer.getPosition() == i) 
                {
                    buf.append(" H");
                    continue;
                }
                if (computerPlayer.getPosition() == i) 
                {
                    buf.append(" C");
                    continue;
                }
                buf.append(" _");
            }
        }
        buf.append(" F");
        return buf.toString();
    }
    
    public String toString()
    {
        return "Game: humanPlayer = " + humanPlayer.toString() + " ,computerPlayer = " + computerPlayer.toString() + " ,natureTrail = " + natureTrail.toString() + " ,dice = " + dice.toString();
    }
    
    private void welcome()
    {
        System.out.println("Welcome to the game!");
    }

    public static void main(String[] args)
    {
        Game gameobj = new Game(
            new Player("P1",0,0),
            new Player("AI",0,0),
            new Trail(),
            new Dice(6)
        );

        gameobj.run();
    }
}