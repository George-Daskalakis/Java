

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CarParkTest.
 *
 * @author  David J. Barnes
 * @version 2018.10.16
 */
public class CarParkTest
{
    // The car park used for all the tests.
    private CarPark carPark1;

    /**
     * Default constructor for test class CarParkTest
     */
    public CarParkTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        carPark1 = new CarPark("Station Road, Canterbury", 10);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    /**
     * Test that the location is set correctly.
     */
    public void testGetLocation()
    {
        assertEquals("Station Road, Canterbury", carPark1.getLocation());
    }

    @Test
    /**
     * Test that the capacity is set correctly.
     */
    public void testGetCapacity()
    {
        assertEquals(10, carPark1.getCapacity());
    }

    @Test
    /**
     * Test that the car park is initially empty.
     */
    public void testInitialOccupation()
    {
        assertEquals(0, carPark1.getOccupancy());
    }

    @Test
    /**
     * Test parking a single car.
     */
    public void testParkOne()
    {
        int capacity = carPark1.getCapacity();
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        assertEquals(capacity, carPark1.getCapacity());
    }

    @Test
    /**
     * Test completely filling the car park.
     */
    public void testFill()
    {
        assertEquals(10, carPark1.getCapacity());
        for(int i = 1; i <= 10; i++) {
            carPark1.park();
            assertEquals(i, carPark1.getOccupancy());
        }
    }

    @Test
    /**
     * Test trying to park too many cars.
     */
    public void testOverFill()
    {
        assertEquals(10, carPark1.getCapacity());
        for(int i = 1; i <= 10; i++) {
            carPark1.park();
            assertEquals(i, carPark1.getOccupancy());
        }
        // This should generate an error message, which is fine.
        System.out.println("This should be followed by a message saying the car park is full.");
        carPark1.park();
        assertEquals(10, carPark1.getOccupancy());
    }

    @Test
    public void testLeave()
    {
        int capacity = carPark1.getCapacity();
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        carPark1.leave();
        assertEquals(0, carPark1.getOccupancy());
        assertEquals(capacity, carPark1.getCapacity());
    }

    @Test
    public void testFillAndClear()
    {
        assertEquals(10, carPark1.getCapacity());
        for(int i = 1; i <= 10; i++) {
            carPark1.park();
            assertEquals(i, carPark1.getOccupancy());
        }
        for(int i = 9; i >= 0; i--) {
            carPark1.leave();
            assertEquals(i, carPark1.getOccupancy());
        }
        assertEquals(10, carPark1.getCapacity());
    }

    @Test
    /**
     * Test trying to leave an empty car park.
     */
    public void testLeaveEmpty()
    {
        // This should generate an error message, which is fine.
        System.out.println("This should be followed by a message saying the car park is empty.");
        carPark1.leave();
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        carPark1.leave();
        assertEquals(0, carPark1.getOccupancy());
        // This should generate an error message, which is fine.
        System.out.println("This should be followed by a message saying the car park is empty.");
        carPark1.leave();
        assertEquals(0, carPark1.getOccupancy());
    }
    
    @Test
    /**
     * Test trying to change the capacity of an
     * empty car park.
     */
    public void testChangeCapacityOk1()
    {
        assertEquals(10, carPark1.getCapacity());
        carPark1.changeCapacity(5);
        assertEquals(15, carPark1.getCapacity());
        carPark1.changeCapacity(-10);
        assertEquals(5, carPark1.getCapacity());
    }

    @Test
    /**
     * Test trying to change the capacity of an
     * non-empty car park.
     */
    public void testChangeCapacityOk2()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        carPark1.changeCapacity(5);
        assertEquals(15, carPark1.getCapacity());
        carPark1.changeCapacity(-10);
        assertEquals(5, carPark1.getCapacity());
        assertEquals(1, carPark1.getOccupancy());
    }

    @Test
    /**
     * Test trying to change the capacity of an
     * non-empty car park to leave just enough
     * room for the current cars.
     */
    public void testChangeCapacityOk3()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        carPark1.changeCapacity(-9);
        assertEquals(1, carPark1.getCapacity());
        assertEquals(1, carPark1.getOccupancy());
    }

    @Test
    /**
     * Test trying to change the capacity of an
     * non-empty car park to leave just enough
     * room for the current cars.
     */
    public void testChangeCapacityOk4()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        carPark1.leave();
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        carPark1.changeCapacity(-9);
        assertEquals(1, carPark1.getCapacity());
        assertEquals(1, carPark1.getOccupancy());
    }
    


    @Test
    /**
     * Test trying to change the capacity of an
     * empty car park.
     */
    public void testChangeCapacityOk5()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        System.out.println("A message should be printed saying the car park is closed.");
        carPark1.changeCapacity(-11);
        assertEquals(0, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
    }
    
    @Test
    /**
     * Test trying to change the capacity so
     * that there isn't room for the current
     * cars.
     */
    public void testChangeCapacityFail1()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        // This should generate an error message, which is fine.
        System.out.println("This should be followed by an error message.");
        carPark1.changeCapacity(-10);
        assertEquals(10, carPark1.getCapacity());
        assertEquals(1, carPark1.getOccupancy());
    }
    
    @Test
    /**
     * Test trying to change the capacity so
     * that there isn't room for the current
     * cars.
     */
    public void testChangeCapacityFail2()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        carPark1.park();
        assertEquals(1, carPark1.getOccupancy());
        // This should generate an error message, which is fine.
        System.out.println("This should be followed by an error message.");
        carPark1.changeCapacity(-20);
        assertEquals(10, carPark1.getCapacity());
        assertEquals(1, carPark1.getOccupancy());
    }
    
    @Test
    /**
     * Test the output from printDetails.
     */
    public void testPrintDetails1()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        System.out.println("This should print:");
        System.out.println("\tStation Road, Canterbury car park has 10 spaces.");
        carPark1.printDetails();
        carPark1.park();
        System.out.println("This should print:");
        System.out.println("\tStation Road, Canterbury car park has 9 spaces.");
        carPark1.printDetails();
    }
    
    @Test
    /**
     * Test the output from printDetails.
     */
    public void testPrintDetails2()
    {
        assertEquals(10, carPark1.getCapacity());
        assertEquals(0, carPark1.getOccupancy());
        for(int i = 0; i < 10; i++) {
            carPark1.park();
        }
        System.out.println("This should print:");
        System.out.println("\tStation Road, Canterbury car park has 0 spaces.");
        carPark1.printDetails();
    }
}





