package com.careerdevs;

public class Car {
    private String make;
    private String model;
    private boolean isRented;
    private String renterName;

    public Car(String make, String model, boolean isRented, String renterName) {
        this.make = make;
        this.model = model;
        this.isRented = isRented;
    }
    public String getName(){
        return make + " " + model;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "make: " + make +
                " model: " + model +
                " isRented: " + isRented;
    }
}
