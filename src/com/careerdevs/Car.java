package com.careerdevs;

public class Car {
    String make;
    String model;
    boolean isRented;

    public Car(String make, String model, boolean isRented) {
        this.make = make;
        this.model = model;
        this.isRented = isRented;
    }

    @Override
    public String toString() {
        return "make: " + make +
                " model: " + model +
                " isRented: " + isRented;
    }
}
