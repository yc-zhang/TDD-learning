package lesson3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class SmartWaiterTest {

    private SmartWaiter smartWaiter;
    private ParkingLot park1;
    private ParkingLot park2;

    @Before
    public void setup() throws Exception {
        park1 = new ParkingLot(3);
        park1.park(new Car("1"));
        park1.park(new Car("2"));
        park2 = new ParkingLot(3);
        park2.park(new Car("3"));
        smartWaiter = new SmartWaiter(Arrays.asList(park1, park2));
    }

    @Test
    public void shouldParkCarInMostFreePark() throws Exception {
        Car car = new Car("new car");
        smartWaiter.park(car);
        assertTrue(park2.contains(car));
    }
}
