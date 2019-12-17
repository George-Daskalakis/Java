
/**
 * Details of a sports personality in a competition.
 * 
 * @author David J. Barnes 
 * @version 2018.11.07
 */
public class Personality
{
    // The name of the person and their sport.
    private String name, sport;
    // The number of votes they have.
    private int votes;

    /**
     * Constructor for objects of class Personality.
     * @param name The personality's name.
     * @param sport The personality's sport.
     */
    public Personality(String name, String sport)
    {
        this.name = name;
        this.sport = sport;
        votes = 0;
    }

    /**
     * Return the personality's name.
     * @return the name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the sport.
     * @return the sport.
     */
    public String getSport()
    {
        return sport;
    }
    
    /**
     * Return the number of votes.
     * @return the number of votes.
     */
    public int getVotes()
    {
        return votes;
    }
    
    /**
     * Increase the votes by the given amount.
     * @amount Number of votes. Must be greater than zero.
     */
    public void increaseVotes(int amount)
    {
        if(amount > 0) {
            votes += amount;
        }
    }
    
    /**
     * Return details of the person, their sport and
     * the number of votes.
     * @return details of the person.
     */
    public String getDetails()
    {
        StringBuilder details = new StringBuilder();
        details.append(name);
        details.append(" takes part in ");
        details.append(sport);
        details.append(" and has ");
        details.append(votes);
        if(votes == 1) {
            details.append(" vote.");
        }
        else {
            details.append(" votes.");
        }
        return details.toString();
    }
}
