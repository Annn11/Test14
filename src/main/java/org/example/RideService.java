package org.example;
import java.util.Optional;
import java.util.List;
import java.util.logging.Logger;
public class RideService {
    private static final Logger logger = Logger.getLogger(RideService.class.getName());
    private Repository<Ride> rides = new Repository<>();

    public Ride createRide(String id, Passenger passenger, Driver driver, Status status) {
        if (id == null || id.isBlank()) {
            logger.severe("Ride id is null or blank");
            throw new RideException("Ride id cannot be blank");
        }
        if (passenger == null) {
            logger.severe("Passenger is null or blank");
            throw new RideException("Ride passenger cannot be null");
        }
        if (driver == null) {
            logger.severe("Driver is null or blank");
            throw new RideException("Ride driver cannot be null");
        }
        Ride ride = new Ride(id, passenger, driver, status);
        rides.add(ride);
        return ride;
    }

    public void confirmRide(String id) {
        Ride ride = rides.findById(id)
                .orElseThrow(() -> {
                    logger.severe("Ride with id " + id + " not found");
                    throw new RideException("Ride with id " + id + " not found");
                });
        if (ride.getStatus() != Status.CREATED) {
            logger.severe("You can get status CORNFIRMED only in status CREATED");
            throw new RideException("You can get status CORNFIRMED only in status CREATED");
        }
        if (ride.getStatus() == Status.CONFIRMED) {
            logger.severe("Ride with id " + id + " is already confirmed");
            throw new RideException("Ride with id " + id + " is already confirmed");
        }
    }

    public void cancelledRide(String id) {
        Ride ride = rides.findById(id)
                .orElseThrow(() -> {
                    logger.severe("Ride with id " + id + " not found");
                    throw new RideException("Ride with id " + id + " not found");
                });
        if (ride.getStatus() != Status.CONFIRMED) {
            logger.severe("Ride can cancelled only in status CONFIRMED");
            throw new RideException("Ride can cancelled only in status CONFIRMED");
        }
        if (ride.getStatus() == Status.CANCELLED) {
            logger.info("Ride with id " + id + " is already cancelled");
            throw new RideException("Ride with id " + id + " is already cancelled");
        }
    }

    public List<Ride> findAllRides() {
        return rides.findAll();
    }

    public Optional<Ride> findRideById(String id) {
        return rides.findById(id);
    }

    public List<Ride> getAllConfimRides() {
        return rides.findAll().stream()
                .filter(ride -> ride.getStatus() == Status.CONFIRMED)
                .toList();
    }
}
