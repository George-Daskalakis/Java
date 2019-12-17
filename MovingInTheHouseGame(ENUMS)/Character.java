;
/**
 * class Character
 * A character in the game.
 * 
 * @author Olaf Chitil
 * @version 4/2/2019
 */
public class Character
{
    private String desc;
    public Item it;
    /**
     * Constructor initialising description and item.
     */
    public Character(String desc, Item it)
    {
        this.desc = desc;
        this.it = it;
    }
       
    /**
     * Return the description and description of item if it exists.
     * @return The description of the character and the description of the item that it holds.
     */
    public String toString()
    {
        if (it != null)
        {
            return desc +" having the item "+ it.toString(); 
        } else{
            return desc;
        }
    }

    /**
     * Take the given item from the character if it has that item.
     * Return whether item was taken.
     * @param item The item to take.
     * @return Returns true if the item is taken and false otherwise.
     */
    public boolean take(Item item)
    {
        if (item == it)
        {
            this.it = null;
            return true;
        }else {
          return false;
        }
    }
}
