package org.example;

import java.util.Objects;

public class Passenger {
    private String id;
    private String name;
    private String number;
    public Passenger(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getId().equals(passenger.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
