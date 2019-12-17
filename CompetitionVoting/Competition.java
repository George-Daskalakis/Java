import java.util.* ;
/**
 * Write a description of class Competition here.
 * 
 * @author (George Daskalakis) 
 * @version (18/11/2018)
 */
public class Competition
{
    //The list of all personalities in this competition.
    ArrayList<Personality> personalities = new ArrayList<Personality>();
    
    
    /**
     * Constructor for objects in class competition.
     */
    public Competition()
    {
    }
    
    /**
     * Adds a personality object to the ArrayList of this competition.
     * @param person The person that is added in the array list.
     */
    public void addPersonality(Personality person)
    {
        personalities.add(person);
    }
    
    /**
     * Returns the amount of objects that are in the ArrayList.
     * @param return the size.
     */
    public int getSize()
    {
        return personalities.size();
    }
    
    /**
     * Shows the full list of personalities in this competition.
     */
    public void list()
    {
          Iterator<Personality> it = personalities.iterator();
          while (it.hasNext())
          {
              Personality person = it.next();
              System.out.println(person.getDetails());
          }
    }
    
    /**
     * Vote for a personality. 
     * A message is printed out if the name was not valid. 
     * 
     * @param name The name of the personality that you vote for.
     */
    public void voteFor(String name)
    {
        boolean found = false;
        for (Personality person : personalities){
            if(person.getName().equals(name)) {
                //call the increaseVotes method
                person.increaseVotes(1);
                found = true;
            }   
        }
        
        if (!found)
        {
            System.out.println("Enter a valid name.");
        }
    }
    
    /**
     * Removes any personalities that have less votes than the number inserted.
     * 
     * @param minimumVotes The minimum amount of votes that a personality should have. 
     */
    public void shortlist(int minimumVotes)
    {
        Iterator<Personality> it = personalities.iterator();
        while(it.hasNext()){
            Personality person = it.next();
            int votes = person.getVotes();
            if (votes < minimumVotes){
                it.remove();
            }
        }
    }
    
    /**
     * Gives the personalities with the highest amount of votes. 
     * The number of personalities that it returns is determined by the user.
     * 
     * @param number The number that determines how many personalities with the highest votes it should return.
     * @return The personalities with the highest votes.
     */
    public ArrayList<Personality> getMost(int number)
    {
        ArrayList<Personality> highestvotes = new ArrayList<Personality> ();
        personalities.sort(Comparator.comparing(Personality::getVotes));
        Collections.reverse(personalities);
        
        for (int i=0; i < number && i < personalities.size(); i++)
        {
                highestvotes.add(personalities.get(i));
                if(i == number-1) {
                    while(i+1 < personalities.size() && personalities.get(i+1).getVotes() == personalities.get(i).getVotes())
                    {
                        highestvotes.add(personalities.get(i+1));
                        i++;
                    }
                }
        }
            
        if (personalities.size() <= number)
        {
            return personalities;
        }
        
        else if (personalities.size() > number)
        {
            return highestvotes;
        }
        else 
        {
            return null;
        }
    }
    
}
