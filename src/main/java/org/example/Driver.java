package org.example;

import java.util.Objects;

public class Driver {
    private String id;
    private String name;
    private String car;
    public Driver(String id, String name, String car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCar() {
        return car;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return getId().equals(driver.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
