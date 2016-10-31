package lesson3;

import lesson3.exceptions.FullException;

import java.util.List;
import java.util.Optional;

public class SmartWaiter extends Waiter implements ParkingService {

    public SmartWaiter(String name, List<ParkingLot> parkingLots) {
        super(name, parkingLots);
    }

    @Override
    public void park(Car car) throws FullException {
        Optional<ParkingLot> park = parkingLots.stream().max((a, b) -> a.getFreeCount() - b.getFreeCount());
        if (park.isPresent()) {
            park.get().park(car);
        } else {
            throw new FullException();
        }
    }
}
