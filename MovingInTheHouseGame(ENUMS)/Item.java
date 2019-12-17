
/**
 * Enumeration class Item
 * The items in the game.
 * 
 * @author Olaf Chitil
 * @version 4/2/2019
 */
public enum Item
{
    FLOUR("flour"), 

    SUGAR("sugar"), 

    EGG("egg");

    private String commandString;
    
    Item(String commandString)
    {
        this.commandString = commandString;
    }

    /**
     * Return the description of the item.
     * @return The description of an item.
     */
    public String toString()
    {
        return commandString;
    }

}
