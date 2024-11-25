package main;

/**
 * Hedgehog
 * Describes a hedgehog that has a name and age and is able to speak 
 */
public class Hedgehog {
    String name;
    int age;

    /**
     * Default constuctor
     */
    public Hedgehog() {
        name = "Pikseli";
        age = 5;
    }

    /**
     * Constructor for defined hedgehog
     * @param name String Name of the hog
     * @param age int age of the hog
     */
    public Hedgehog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for the hog name
     * @return hedgehog's name
     */
    public String getName() {
        return name;
    }

    /**
     * method to ask the hog to speak given statement
     * @param teksti String the statement the hog says
     */
    public void speak(String teksti) {
        if (teksti != "") {
            System.out.println(name + ": " + teksti);
        } else {
            System.out.println("Olen " + name + " ja ikäni on " + Integer.toString(age) + " vuotta, mutta antaisitko silti syötteen?");
        }
    }
}
