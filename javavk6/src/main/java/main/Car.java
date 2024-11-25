package main;

/**
 * properties Vehicle paret classilta sekä oma Engine engine -olio.
 */
public class Car extends Vehicle {

    public Car(String manufacturer, String model, int maxSpeed) {
        super("Auto", manufacturer, model, maxSpeed);
        engine = new Engine("V8", 300);
    }

    public void drive() {
        System.out.println(manufacturer + model + " paahtaa eteenpäin!");
    }
}