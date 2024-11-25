package main;

import java.util.ArrayList;

/**
 * Zoo
 * describes a zoo with a name and an arraylist of animals in it.
 * Has the ability to add a new animal to the zoo,
 * list the animals, make animals run,
 */
class Zoo {
    private String name;
    private ArrayList<Animal> animals;

    /**
     * constructor Zoo with the name and the arraylist of animals
     */
    public Zoo(String name) {
        this.name = name;
        animals = new ArrayList<>();
    }

    /**
     * addAnimal method adds an animal to the arrayList.
     * 
     * @param animal the animal object.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * listAnimal method lists every animal in the arrayList to System.out
     * eli tää käy forilla listan läpi ja printtaa jokaisen objektin tiedot yksi
     * kerrallaan
     */
    public void listAnimals() {
        System.out.println(name + " pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            System.out.println(animal.getSpecies() + ": " + animal.getName() + ", " + Integer.toString(animal.getAge()) + " vuotta");
        }
    }
    /**runAnimals prints out text "*animal* juoksee kovaa vauhtia" as many times as the animals run. Animals run in the same order as they are on the list. */
    public void runAnimals(int lap) {
        for (Animal animal : animals) {
            for (int i = 0; i < lap; i++)
                System.out.println(animal.getName() + " juoksee kovaa vauhtia!");
        }
    }

}