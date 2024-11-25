/**
 * Hedgehog assignment (LUT:Olio-ohjelmointi viikko 2)
 * 19.1.2024
 * Kaisa Punakorpi
 * 0010803602
 */

package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Hedgehog siili = new Hedgehog();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Pistä siili puhumaan, 2) Luo uusi siili, 3) Juoksuta siiliä, 0) Lopeta ohjelma");
            if (sc.hasNext()) { // kysytään että onko scannerissa jotain sisällä
                String selection = sc.nextLine();
                switch (selection) {
                    case "1":
                        System.out.println("Mitä siili sanoo:");
                        String teksti = sc.nextLine();
                        siili.speak(teksti);
                        break;
                    case "2":
                        System.out.println("Anna siilin nimi:");
                        String name = sc.nextLine();
                        System.out.println("Anna siilin ikä:");
                        int age = Integer.parseInt(sc.nextLine());
                        siili = new Hedgehog(name, age);
                        break;
                    case "3":
                        System.out.println("Kuinka monta kierrosta?");
                        int counter = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < counter; i++) {
                            System.out.println(siili.getName() + " juoksee kovaa vauhtia!");
                        }
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
