package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        Vehicle newVehicle;
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (boolean exit = false; !exit;) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");
            if (sc.hasNext()) {
                switch (sc.nextLine()) {
                    case "1":
                        System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                        if (sc.hasNext()) {
                            String answer = sc.nextLine();
                            System.out.println("Anna kulkuneuvon valmistaja:");
                            String manufacturer = sc.nextLine();
                            System.out.println("Anna kulkuneuvon malli:");
                            String model = sc.nextLine();
                            System.out.println("Anna kulkuneuvon huippunopeus:");
                            int maxSpeed = Integer.parseInt(sc.nextLine());
                            switch (answer) {
                                case "1":
                                    newVehicle = new Car(manufacturer, model, maxSpeed);
                                    break;
                                case "2":
                                    newVehicle = new Plane(manufacturer, model, maxSpeed);                                    
                                    break;                            
                                case "3":
                                    newVehicle = new Ship(manufacturer, model, maxSpeed);                                    
                                    break;
                                default:
                                    System.out.println("Valitse uudelleen");
                                    continue;
                            }
                            vehicles.add(newVehicle);
                        }   
                        break;
                    case "2":
                        for (Vehicle v : vehicles) {
                            System.out.println(v.type + ": " + v.manufacturer + " " + v.model);
                            System.out.println("Moottori : " + v.engine.name + v.engine.power + "kW");
                            System.out.println("Huippunopeus: " + v.maxSpeed + "km/h");
                            System.out.println("");
                        }
                        break;
                    case "3":
                        for (Vehicle v : vehicles) {
                            if (v instanceof Car) {
                                System.out.println(v.manufacturer + " " + v.model + " paahtaa tietä eteenpäin!");
                            }
                        }
                        break;
                    case "4":
                        for (Vehicle v : vehicles) {
                            if (v instanceof Plane) {
                                System.out.println(v.manufacturer + " " + v.model + " lentää kohteeseen!");
                            }
                        }
                            break;
                    case "5":
                        for (Vehicle v : vehicles) {
                            if (v instanceof Ship) {
                                System.out.println(v.manufacturer + " " + v.model + " seilaa merten ääriin!");
                            }
                        }
                        break;
                    case "0":
                        System.out.println("Kiitos ohjelman käytöstä.");
                        return;
                    default:
                        System.out.println("Väärä vastaus");
                        break;
                }
            }
            } 
        sc.close();
    }
}
