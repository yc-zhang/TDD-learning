package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WaiterTest {

    private Waiter waiter;
    private ParkingLot p1;
    private ParkingLot p2;

    @Before
    public void setup() {
        p1 = new ParkingLot(1);
        p2 = new ParkingLot(1);
        waiter = new Waiter("waiter", Arrays.asList(p1, p2));
    }

    @Test
    public void shouldParkCar() throws Exception {
        Car car = new Car("1");
        waiter.park(car);
        assertTrue(p1.contains(car));
    }

    @Test(expected = FullException.class)
    public void shouldThrowExceptionIfParkingLotsAreFull() throws Exception {
        Car car = new Car("my car");
        Car car1 = new Car("1");
        p1.park(car1);
        Car car2 = new Car("2");
        p2.park(car2);
        waiter.park(car);
    }

    @Test
    public void shouldFetchCar() throws Exception {
        Car car1 = new Car("1");
        p1.park(car1);
        waiter.fetch(car1);
        assertFalse(p1.contains(car1));
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldThrowNotFoundException() throws Exception {
        Car car1 = new Car("1");
        waiter.fetch(car1);
    }

    @Test
    public void shouldBeTrueIfContains() throws Exception {
        Car car2 = new Car("2");
        p2.park(car2);
        assertTrue(waiter.contains(car2));
    }

    @Test
    public void shouldBeFalseIfNotContains() throws Exception {
        assertFalse(waiter.contains(new Car("")));
    }

    @Test
    public void shouldReturnFreeCount() throws Exception {
        assertEquals(waiter.getFreeCount(), 2);
    }

    @Test
    public void shouldReturnReport() throws Exception {
        assertEquals(
                "Name: waiter, Count of ParkingLot: 2, Total FreeCount: 2\n" +
                "\tEmbedded ParkingLot Reports: \n" +
                "\t\tParkingLot Size: 1, Free Count: 1\n" +
                "\t\tParkingLot Size: 1, Free Count: 1", waiter.getReport());
    }
}
