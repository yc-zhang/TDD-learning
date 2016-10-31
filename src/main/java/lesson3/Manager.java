package lesson3;

import lesson3.exceptions.FullException;
import lesson3.exceptions.WaiterNotFoundException;

import java.util.List;

public class Manager extends SmartWaiter implements ParkingService {

    private List<Waiter> waiters;

    public Manager(String name, List<ParkingLot> parkingLots, List<Waiter> waiters) {
        super(name, parkingLots);
        this.waiters = waiters;
    }

    public void parkByWaiter(Car car, ParkingService waiter) throws FullException, WaiterNotFoundException {
        if (waiters.contains(waiter)) {
            waiter.park(car);
        } else {
            throw new WaiterNotFoundException();
        }
    }

    public String report() {
        String parkingLotReports = parkingLots.stream().map(ParkingLot::report).reduce("", (a, b) -> a + "\n\t" + b);
        String waiterReports = waiters.stream().map(Waiter::report).reduce("", (a, b) -> a + "\n\t" + b);
        return "Embedded ParkingLot Reports: " + parkingLotReports + "\n" + "Embedded Waiter Reports: " + waiterReports;
    }
}
