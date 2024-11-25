package main;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        Gifu gifu = new Gifu(sc.nextLine());
        Course course;
        int currentCourseIndex;
        int currentStudentIndex;
        Course currentCourse;
        Student currentStudent;
        ArrayList<Enrollment> courseEnrollments;
        for (boolean exit = false; !exit;) {
            System.out.println(
                    "1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            if (sc.hasNext()) {
                switch (sc.nextLine()) {
                    case "1": // Luo uusi kurssi
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String courseID = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        int maxStudents = Integer.parseInt(sc.nextLine());
                        course = new Course(maxStudents, courseName, courseID);
                        gifu.addCourse(course);
                        break;
                    case "2": // Luo uusi opiskelija
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentID = sc.nextLine();
                        Student student = new Student(studentName, studentID);
                        gifu.addStudent(student);
                        break;
                    case "3": // Listaa kurssit
                        gifu.listCourses();
                        break;
                    case "4": // Listaa opiskelijat
                        gifu.listStudents();
                        break;
                    case "5": // Lisää opiskelija kurssille
                        gifu.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        currentCourseIndex = Integer.parseInt(sc.nextLine());
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        currentStudentIndex = Integer.parseInt(sc.nextLine());
                        gifu.enrollStudent(gifu.getStudent(currentStudentIndex), gifu.getCourse(currentCourseIndex));
                        ;
                        break;
                    case "6": // Anna kurssiarvosanat
                        gifu.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        currentCourseIndex = Integer.parseInt(sc.nextLine());
                        currentCourse = gifu.getCourse(currentCourseIndex);
                        courseEnrollments = gifu.getEnrollments(currentCourse);
                        for (Enrollment enrollment : courseEnrollments) {
                            currentStudent = enrollment.getStudent();
                            System.out.println("Anna arvosana opiskelijalle " + currentStudent.getInformation());
                            enrollment.gradeCourse(Integer.parseInt(sc.nextLine()));
                        }
                        break;
                    case "7": // Listaa kurssilla olevat opiskelijat
                        gifu.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        currentCourseIndex = Integer.parseInt(sc.nextLine());
                        currentCourse = gifu.getCourse(currentCourseIndex);
                        courseEnrollments = gifu.getEnrollments(currentCourse);
                        for (Enrollment enrollment : courseEnrollments) {
                            System.out.println(enrollment.getStudent().getInformation() + ", arvosana: "
                                    + Integer.toString(enrollment.getGrade()));
                        }
                        break;
                    case "8": // Listaa opiskelijan arvosanat
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        currentStudentIndex = Integer.parseInt(sc.nextLine());
                        currentStudent = gifu.getStudent(currentStudentIndex);
                        System.out.println("Opiskelijan " + currentStudent.getInformation() + " arvosanat:");
                        ArrayList<Enrollment> currentEnrollments = gifu.getEnrollments(currentStudent);
                        for (Enrollment enrollment : currentEnrollments) {
                            System.out.println(enrollment.getCourse().getInformation() + ", arvosana: "
                                    + Integer.toString(enrollment.getGrade()));
                        }
                        break;
                    case "9": // Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat
                        for (Course loopCourse : gifu.getCourses()) {
                            System.out.println(loopCourse.getInformation());
                            currentEnrollments = gifu.getEnrollments(loopCourse);
                            for (Enrollment loopEnrollment : currentEnrollments) {
                                System.out.println(loopEnrollment.getStudent().getInformation()
                                        + ", arvosana: " + Integer.toString(loopEnrollment.getGrade()));
                            }
                        }
                        break;
                    case "0": // Lopeta
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
