package main;

public class Plane extends Vehicle {

    public Plane(String manufacturer, String model, int maxSpeed) {
        super("Lentokone", manufacturer, model, maxSpeed);
        engine = new Engine("Suihkumoottori", 500);
    }

    public void fly() {
        System.out.println(manufacturer + model + " lentää kohteeseen!");
    }
}