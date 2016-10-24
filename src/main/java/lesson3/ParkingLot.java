package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkingService {
    private List<Car> cars;
    private final int size;

    public ParkingLot(int size) {
        this.size = size;
        this.cars = new ArrayList<>();
    }

    @Override
    public void park(Car car) throws FullException {
        if (freeCount() > 0)  {
            this.cars.add(car);
        } else {
            throw new FullException();
        }
    }

    @Override
    public void fetch(Car car) throws CarNotFoundException {
        if (cars.contains(car)) {
            cars.remove(car);
        }  else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public boolean contains(Car car) {
        return cars.contains(car);
    }

    @Override
    public int freeCount() {
        return this.size - cars.size();
    }
}
