package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;

import java.util.List;

public class Waiter implements ParkingService {
    protected List<ParkingLot> parkingLots;
    protected String name;
    public Waiter(String name, List<ParkingLot> parkingLots) {
        this.name = name;
        this.parkingLots = parkingLots;
    }

    @Override
    public void park(Car car) throws FullException {
        parkingLots.stream().filter(x -> x.getFreeCount() > 0)
                .findFirst().orElseThrow(FullException::new).park(car);
    }

    @Override
    public void fetch(Car car) throws CarNotFoundException {
        parkingLots.stream().filter(x -> x.contains(car))
                .findFirst()
                .orElseThrow(CarNotFoundException::new).fetch(car);
    }

    @Override
    public boolean contains(Car car) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.contains(car));
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
