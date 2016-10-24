package lesson3;

import lesson3.exceptions.FullException;
import lesson3.exceptions.WaiterNotFoundException;

import java.util.List;

public class Manager extends SmartWaiter implements ParkingService {

    private List<ParkingService> waiters;

    public Manager(List<ParkingService> parkingServices, List<ParkingService> waiters) {
        super(parkingServices);
        this.waiters = waiters;
    }

    public void parkByWaiter(Car car, Waiter waiter) throws FullException, WaiterNotFoundException {
        if (waiters.contains(waiter)) {
            waiter.park(car);
        } else {
            throw new WaiterNotFoundException();
        }
    }

    public List<ParkingService> getWaiters() {
        return waiters;
    }
}
