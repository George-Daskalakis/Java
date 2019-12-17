
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String title;
    /**
     * Set the name and the title of the person,
     * @param name The name of the person.
     * @param title The title of the person.
     */
    public Person(String name, String title)
    {
        this.name = name;
        this.title = title; 
    }
    
    /**
     * Change the title of the person.
     * @param newtitle The new title of the person.
     */
    protected void changeTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * returns the name of the person. 
     * @return The name of the person.
     */
    protected String getName()
    {
        return name;
    }
    
    /**
     * retuns the title of the person. 
     * @return The title of the person.
     */
    protected String getTitle()
    {
        return title;
    }
    
    /**
     * return the title and name of the person.
     * @return The title and name of the person.
     */
    public String toString()
    {
        return getTitle() + " " + getName();
    }
}
