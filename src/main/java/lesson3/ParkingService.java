package lesson3;

import lesson3.exceptions.CarNotFoundException;
import lesson3.exceptions.FullException;

public interface ParkingService {
    void park(Car car) throws FullException;

    void fetch(Car car) throws CarNotFoundException;

    boolean contains(Car car);

    int freeCount();
}
