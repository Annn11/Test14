package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        DriverService driverService = new DriverService();
        RideService rideService = new RideService();
        Driver driver = new Driver("d1", "Dmitriy", "Toyota Corolla");
        Passenger passenger = new Passenger("p1", "John Smith", "123-456-789");
        Ride ride = rideService.createRide("r1", passenger, driver, Status.CREATED);
        rideService.confirmRide("r1");
        List<Ride> rides = rideService.getAllConfimRides();
        System.out.println(rides);
    }
}