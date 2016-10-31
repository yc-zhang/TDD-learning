package lesson3;

import lesson3.exceptions.FullException;

import java.util.List;

public class SmartWaiter extends Waiter {

    public SmartWaiter(String name, List<ParkingLot> parkingLots) {
        super(name, parkingLots);
    }

    @Override
    public void park(Car car) throws FullException {
        parkingLots.stream().max((a, b) -> a.getFreeCount() - b.getFreeCount())
            .orElseThrow(FullException::new).park(car);
    }
}
