package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(2);
    }

    @Test
    public void shouldParkCar() throws Exception {
        Car car = new Car("1");
        parkingLot.park(car);
        List<Car> carList = parkingLot.getCarList();
        assertEquals(1, carList.size());
        assertSame(car, carList.get(0));
    }

    @Test(expected = FullException.class)
    public void shouldThrowExceptionIfParkingLotsAreFull() throws Exception {
        parkingLot.park(new Car("1"));
        parkingLot.park(new Car("2"));
        parkingLot.park(new Car("3"));
    }

    @Test
    public void shouldFetchCar() throws Exception {
        Car car1 = new Car("1");
        parkingLot.park(car1);
        parkingLot.fetch(car1);
        assertEquals(0, parkingLot.getCarList().size());
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldThrowNotFoundException() throws Exception {
        parkingLot.fetch(new Car("1"));
    }

    @Test
    public void shouldBeTrueIfContains() throws Exception {
        Car car2 = new Car("2");
        parkingLot.park(car2);
        assertTrue(parkingLot.contains(car2));
    }

    @Test
    public void shouldBeFalseIfNotContains() throws Exception {
        assertFalse(parkingLot.contains(new Car("")));
    }

    @Test
    public void shouldReturnFreeCount() throws Exception {
        assertEquals(parkingLot.getFreeCount(), 2);
    }

    @Test
    public void shouldReturnReport() throws Exception {
        assertEquals("ParkingLot Size: 2, Free Count: 2", parkingLot.getReport());
    }
}
