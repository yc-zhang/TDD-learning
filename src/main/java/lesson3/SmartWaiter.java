package lesson3;

import lesson3.exceptions.FullException;

import java.util.List;
import java.util.Optional;

public class SmartWaiter extends Waiter implements ParkingService {

    public SmartWaiter(List<ParkingService> parkingServices) {
        super(parkingServices);
    }

    @Override
    public void park(Car car) throws FullException {
        Optional<ParkingService> park = parkingServices.stream().max((a, b) -> a.freeCount() - b.freeCount());
        if (park.isPresent()) {
            park.get().park(car);
        } else {
            throw new FullException();
        }
    }
}
