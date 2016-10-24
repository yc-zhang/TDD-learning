package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;

import java.util.List;
import java.util.Optional;

public class Waiter implements ParkingService {
    protected List<ParkingService> parkingServices;

    public Waiter(List<ParkingService> parkingServices) {
        this.parkingServices = parkingServices;
    }

    @Override
    public void park(Car car) throws FullException {
        Optional<ParkingService> park = parkingServices.stream().filter(x -> x.freeCount() > 0)
                .findFirst();
        if (park.isPresent()) {
            park.get().park(car);
        } else {
            throw new FullException();
        }
    }

    @Override
    public void fetch(Car car) throws CarNotFoundException {
        Optional<ParkingService> park = parkingServices.stream().filter(x -> x.contains(car))
                .findFirst();
        if (park.isPresent()) {
            park.get().fetch(car);
        } else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public boolean contains(Car car) {
        return parkingServices.stream().anyMatch(parkingService -> parkingService.contains(car));
    }

    @Override
    public int freeCount() {
        parkingServices.stream().map(ParkingService::freeCount).reduce(0, (a, b) -> a + b);
        return parkingServices.stream().mapToInt(ParkingService::freeCount).sum();
    }

}
