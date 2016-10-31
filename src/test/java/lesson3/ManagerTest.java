package lesson3;

import lesson3.exceptions.WaiterNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerTest {
    private Manager manager;
    private Waiter waiter;
    private ParkingLot parkingLot;

    @Before
    public void setup() {
        parkingLot = new ParkingLot(3);
        waiter = new Waiter("waiter", Arrays.asList(parkingLot));
        manager = new Manager("manager", Arrays.asList(parkingLot), Arrays.asList(waiter));
    }

    @Test
    public void shouldParkCarByWaiter() throws Exception {
        Car car = new Car("1");
        manager.parkByWaiter(car, waiter);
        assertTrue(parkingLot.contains(car));
    }

    @Test(expected = WaiterNotFoundException.class)
    public void shouldThrowWaiterNoFound() throws Exception {
        manager.parkByWaiter(new Car("3"), new SmartWaiter(null, null));
    }

    @Test
    public void shouldReport() throws Exception {
        assertEquals(
                "Embedded ParkingLot Reports: \n" +
                "\tParkingLot Size: 3, Free Count: 3\n" +
                "Embedded Waiter Reports: \n" +
                "\tName: waiter, Count of ParkingLot: 1, Total FreeCount: 3\n" +
                "\tEmbedded ParkingLot Reports: \n" +
                "\t\tParkingLot Size: 3, Free Count: 3", manager.report());
    }
}
