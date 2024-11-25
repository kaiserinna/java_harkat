package main;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        University university = new University();
        String nimi; // Kysytty opiskelijan nimi
        String id; // Kysytty opiskelijaID
        ArrayList<Student> currentStudentList;
        int selectedStudentIndex;
        Student currentStudent; //sisältää valitun Student-tyyppisen olion
        String currentCourse; //käyttäjältä kysytty kurssin nimi
        int currentGrade; //käyttäjältä kysytty kurssin arvosana
        Grade grade; //uusi grade-olio
        ArrayList<Grade> currentGradeList;
        double averageOfStudentsCourseGrades; // calculatorilla laskettu yhden opiskelijan kaikkien kurssien arvosanojen keskiarvo
        for (boolean exit = false; !exit;) {
            System.out.println(
                    "1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            if (sc.hasNext()) {
                switch (sc.nextLine()) {
                    case "1":
                        System.out.println("Anna opiskelijan nimi?");
                        nimi = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        id = sc.nextLine();
                        university.addStudent(new Student(nimi, id)); // uusi student universitylistaan talteen
                        break;
                    case "2":
                        System.out.println("Opiskelijat:");
                        currentStudentList = university.getStudents();
                        for (int i = 0; i < currentStudentList.size(); i++) {
                            Student kasiteltava = currentStudentList.get(i);
                            System.out.println(kasiteltava.getStudentId() + ": " + kasiteltava.getName());
                        }
                        break;
                    case "3":
                        // kysytään kenestä opiskelijasta kyse
                        // kysytään kurssi ja grade
                        // tehdään Grade objekti
                        // i. opiskelija listalta ja hänelle addGrade-objekti
                        // ensin listataan opiskelijat
                        currentStudentList = university.getStudents();
                        for (int i = 0; i < currentStudentList.size(); i++) {
                            System.out.println(Integer.toString(i) + ": " + currentStudentList.get(i).getName());
                        }
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        selectedStudentIndex = Integer.parseInt(sc.nextLine());
                        currentStudent = currentStudentList.get(selectedStudentIndex);
                        System.out.println("Mille kurssille suorite lisätään?");
                        currentCourse = sc.nextLine(); 
                        //tämä annettu kurssin nimi tarvitaan kun luodaan kyseisen opiskelijan Grade-tyyppinen olio, mutta ensin kysytään myös arvosana
                        System.out.println("Mikä arvosana kurssille lisätään?");
                        currentGrade = Integer.parseInt(sc.nextLine());
                        // eli nyt mulla on currentCourse ja currentGrade (String + int), joista luodaan (Student-luokan omistama) Grade-olio. Oliot luodaan new:llä.
                        grade = new Grade(currentCourse, currentGrade);
                        currentStudent.addGrade(grade);
                        break;
                    case "4":
                        currentStudentList = university.getStudents();
                        for (int i = 0; i < currentStudentList.size(); i++) {
                            System.out.println(Integer.toString(i) + ": " + currentStudentList.get(i).getName());
                        }
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        selectedStudentIndex = Integer.parseInt(sc.nextLine());
                        currentStudent = currentStudentList.get(selectedStudentIndex);
                        currentGradeList = currentStudent.getGrades();
                        for (int i = 0; i < currentGradeList.size(); i++) {
                            System.out.println(currentGradeList.get(i).getCourse() + ": " + currentGradeList.get(i).getGrade());
                        }
                        break;
                    case "5":
                        currentStudentList = university.getStudents();
                        for (int i = 0; i < currentStudentList.size(); i++) {
                            System.out.println(Integer.toString(i) + ": " + currentStudentList.get(i).getName());
                        }
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        selectedStudentIndex = Integer.parseInt(sc.nextLine());
                        currentStudent = currentStudentList.get(selectedStudentIndex);
                        averageOfStudentsCourseGrades = Calculator.getAverageGrade(currentStudent);
                        System.out.println("Keskiarvo on " + Double.toString(averageOfStudentsCourseGrades));
                        break;
                    case "6":
                        currentStudentList = university.getStudents();
                        for (int i = 0; i < currentStudentList.size(); i++) {
                            System.out.println(Integer.toString(i) + ": " + currentStudentList.get(i).getName());
                        }
                        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                        selectedStudentIndex = Integer.parseInt(sc.nextLine());
                        currentStudent = currentStudentList.get(selectedStudentIndex);
                        averageOfStudentsCourseGrades = Calculator.getMedianGrade(currentStudent);
                        System.out.println("Mediaani on " + Double.toString(averageOfStudentsCourseGrades));
                        break;
                    case "7":
                        university.saveStudents();
                        break;
                    case "8":
                        university.loadStudents();
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
