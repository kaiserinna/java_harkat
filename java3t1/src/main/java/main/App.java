package main;

import java.util.Scanner;

/**
 * Zoo assignment (LUT:Olio-ohjelmointi viikko 3)
 * 23.1.2024
 * Kaisa Punakorpi
 * 0010803602
 */

/**
 * voi luoda uusia eläimiä
 * kysyy eiläimen lajia ja nimeä ja ikää
 * lähettää animalille ja plim eläinolio on luotu
 * eläinolio annetaan Zoolle, joka säilöö eiläimen sisäänsä listana
 */
public class App {

    public static void main(String[] args) {
        Zoo zoo; // still null initialized later with zoo name
        Scanner sc = new Scanner(System.in);
        System.out.println("Anna eläintarhalle nimi:");
        zoo = new Zoo(sc.nextLine());
        for (boolean exit = false; !exit;) {
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            if (sc.hasNext()) {
                switch (sc.nextLine()) {
                    case "1":
                        // luodaan uusi eläin
                        System.out.println("Mikä laji?");
                        String species = sc.nextLine();
                        System.out.println("Anna eläimen nimi:");
                        String name = sc.nextLine();
                        System.out.println("Anna eläimen ikä:");
                        int age = Integer.parseInt(sc.nextLine());
                        zoo.addAnimal(new Animal(species, name, age));
                        break;
                    case "2":
                        // listataan kaikki eläimet
                        zoo.listAnimals();
                        break;
                    case "3":
                        // juoksutetaan eläimiä
                        System.out.println("Kuinka monta kierrosta?");
                        zoo.runAnimals(Integer.parseInt(sc.nextLine()));
                        break;
                    case "0":
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }
}
