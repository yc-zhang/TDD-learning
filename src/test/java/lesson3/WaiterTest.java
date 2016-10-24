package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WaiterTest {

    private Waiter waiter;
    private ParkingService p1;
    private ParkingService p2;

    @Before
    public void setup() {
        p1 = new ParkingLot(1);
        p2 = new ParkingLot(1);
        waiter = new Waiter(Arrays.asList(p1, p2));
    }

    @Test
    public void shouldParkCar() throws Exception {
        Car car = new Car("1");
        waiter.park(car);
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
}
