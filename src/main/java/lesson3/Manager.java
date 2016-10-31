package lesson3;

import lesson3.exceptions.FullException;
import lesson3.exceptions.WaiterNotFoundException;

import java.util.List;

public class Manager extends SmartWaiter {

    private List<Waiter> waiters;

    public Manager(String name, List<ParkingLot> parkingLots, List<Waiter> waiters) {
        super(name, parkingLots);
        this.waiters = waiters;
    }

    public void parkByWaiter(Car car, Waiter waiter) throws FullException, WaiterNotFoundException {
        if (waiters.contains(waiter)) {
            waiter.park(car);
        } else {
            throw new WaiterNotFoundException();
        }
    }

    public String getReport() {
        String parkingLotReports = parkingLots.stream().map(ParkingLot::getReport).reduce("", (a, b) -> a + "\n\t" + b);
        String waiterReports = waiters.stream().map(Waiter::getReport).reduce("", (a, b) -> a + "\n\t" + b);
        return "Embedded ParkingLot Reports: " + parkingLotReports + "\n" + "Embedded Waiter Reports: " + waiterReports;
    }
}
