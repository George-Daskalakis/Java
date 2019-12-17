/**
 * Write a description of class CarPark here.
 *
 * @author Georgios Daskalakis
 * @version 2018.10.22
 */
public class CarPark
{
    private String location;
    private int capacity;
    private int occupancy;
    
    /**
     * Inserts the capacity and location of the CarPark and sets occupancy to 0.
     */
    public CarPark(String carparklocation, int parkcapacity)
    {
        capacity = parkcapacity;
        location = carparklocation;
        occupancy = 0;
    }
    
    /**
     * Shows the location of the CarPark.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Shows the capacity of the CarPark.
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     * Shows the number of cars that are in the CarPark.
     */
    public int getOccupancy()
    {
        return occupancy;
    }
    
    /**
     * Adds a car.
     */
    public void park() 
    {
    if (occupancy<capacity){
        occupancy = occupancy + 1;
    }
    else{
        System.out.println("Car park is full.");
    }
    }
    
    /**
     * Removes a car.
     */
    public void leave() 
    {
     if (occupancy>0){
        occupancy = occupancy - 1;
        }
     else {
        System.out.print("Car park is empty.");
        }
    }
    
    
    /**
     * Changes the capacity of the CarPark.
     * Capacity is always greater or equal to the occupancy.
     */
    public void changeCapacity(int changecapacity)
    {
     if (occupancy > 0 && capacity + changecapacity < occupancy)
        {
            System.out.println ("Error");
        }
     else if (capacity + changecapacity < 0){
             capacity = 0;
             System.out.println ("The car park is now closed.");
     }
       else{
           capacity = capacity + changecapacity;
        }
    
    }

    /**
     * Prints the details of the CarPark.
     */
    public void printDetails ()
    {      
        System.out.println(location + " car park has " + (capacity - occupancy) + " spaces.");
    }
    
    
    
}
