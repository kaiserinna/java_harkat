
package main;

/**
 * Animal
 * defines an animal with species, name and age.
 */
class Animal {
    String species;
    String name;
    int age;

    /**
     * Constructor Animal, with species, name and age
     */
    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    /**
     * getSpecies
     * method for getting the species of the animal
     * @return String species
     */
    public String getSpecies() {
        return species;
    }


    /**
     * getName
     * method for getting the name of the animal
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * getAge
     * method for getting the age of the animal
     * @return int age
     */
    public int getAge() {
        return age;
    }
}
