package org.example;
import java.util.Objects;

public class Ride implements Identifiable {
    String id;
    Passenger passenger;
    Driver driver;
    Status status;
    public Ride(String id, Passenger passenger, Driver driver, Status status) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        status.CREATED;
    }
    public String getId() {
        return id;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public Driver getDriver() {
        return driver;
    }
    public Status getStatus() {
        return status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride)) return false;
        Ride ride = (Ride) o;
        return getId().equals(ride.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
