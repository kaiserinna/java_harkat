
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * University-luokka vastaa students-tietorakenteen kirjoittamisesta tiedostoon.
 * Olio pitää sisällään kaiken datan, joten tämä data tulee kirjoitettua
 * tiedostoon automaattisesti. Student-luokan tulee olla siis serialisoituva –
 * kuten myös Grade-luokan, mikäli sellainen on käytössä.
 * lisää student
 * poista srudent
 * hae student tiedot(studentId)
 * pystyy listaamaan yliopiton kaikki opiskelijat
 */
public class University {
    final static String FILENAME = "java4t1.serialized";

    private ArrayList<Student> students;

    public University() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * @return
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * 
     */
    public void saveStudents() {
        try {
            ObjectOutputStream studentwriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentwriter.writeObject(students);
            studentwriter.close();
        } catch (IOException e) {
            System.out.println("Tiedoston " + FILENAME + " tallennuksessa virhe");
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream((new FileInputStream(FILENAME)));
            try {
                students = (ArrayList<Student>) studentReader.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Odottamaton virhe tiedoston " + FILENAME + " lukemisessa");
                e.printStackTrace();
            }
            studentReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa " + FILENAME + " ei ole");
        } catch (IOException e) {
            System.out.println("Tiedoston " + FILENAME + " lukemisessa virhe");
            e.printStackTrace();
        }
    }
}
