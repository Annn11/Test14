package org.example;
import java.util.Optional;
import java.util.List;
public class DriverService {
    private Repository<Driver> drivers = new Repository<>();
    public Driver createDriver(String id, String name, String car) {
        if (id == null || id.isBlank()) {
            throw new RideException("id cannot be blank");
        }
        if (name == null || name.isBlank()) {
            throw new RideException("name cannot be blank");
        }
        if (car == null || car.isBlank()) {
            throw new RideException("car cannot be blank");
        }
        Driver driver = new Driver(id, name, car);
        drivers.add(driver);
        return driver;
    }
    public Optional<Driver> getDriverById(String id) {
        return drivers.findById(id);
    }
    public List<Driver> getAllDriver() {
        return drivers.findAll();
    }
}
