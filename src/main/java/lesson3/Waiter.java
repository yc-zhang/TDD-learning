package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;

import java.util.List;
import java.util.Optional;

public class Waiter implements ParkingService {
    protected List<ParkingLot> parkingLots;
    protected String name;
    public Waiter(String name, List<ParkingLot> parkingLots) {
        this.name = name;
        this.parkingLots = parkingLots;
    }

    @Override
    public void park(Car car) throws FullException {
        Optional<ParkingLot> park = parkingLots.stream().filter(x -> x.getFreeCount() > 0)
                .findFirst();
        if (park.isPresent()) {
            park.get().park(car);
        } else {
            throw new FullException();
        }
    }

    @Override
    public void fetch(Car car) throws CarNotFoundException {
        Optional<ParkingLot> park = parkingLots.stream().filter(x -> x.contains(car))
                .findFirst();
        if (park.isPresent()) {
            park.get().fetch(car);
        } else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public boolean contains(Car car) {
        return parkingLots.stream().anyMatch(parkingService -> parkingService.contains(car));
    }

    @Override
    public int getFreeCount() {
        return parkingLots.stream().mapToInt(ParkingService::getFreeCount).sum();
    }

    @Override
    public String getReport() {
        String report = parkingLots.stream().map(ParkingLot::getReport).reduce("", (a, b) -> a + "\n\t\t" + b);
        return "Name: " + name + ", Count of ParkingLot: " + parkingLots.size() + ", Total FreeCount: " + getFreeCount()
                + "\n\t" + "Embedded ParkingLot Reports: " + report;
    }
}
