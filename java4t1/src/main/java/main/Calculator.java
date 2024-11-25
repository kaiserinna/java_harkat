package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    /*
     * palauttaa keskiarvon kurssisuorituksista double-liukulukuna. Mikäli
     * suorituksia ei ole, palauttaa nollan.
     */
    public static double getAverageGrade(Student currentStudent) {
        ArrayList<Grade> gradeList = currentStudent.getGrades();
        double sum = 0;
        int n = gradeList.size();
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            sum += gradeList.get(i).getGrade();
        }
        return sum / n;
    }

    /*
     * palauttaa mediaaniarvosanan double-liukulukuna. Tämä onnistuu helpoiten
     * järjestämällä tietorakenne suuruusjärjestykseen ja palauttamalla keskimmäinen
     * alkio (tee sorttaus kuitenkin tietorakenteen kopiolle, jotta alkuperäinen
     * rakenne ei muutu – tavallinen Array on toimiva tässä). Mikäli alkioita on
     * parillinen määrä tulee palauttaa kahden keskimmäisen alkion arvojen
     * keskiarvo. Mikäli suorituksia ei ole, palauttaa nollan.
     */
    public static double getMedianGrade(Student currentStudent) {
        ArrayList<Grade> gradeList = currentStudent.getGrades();
        int n = gradeList.size();
        if (n == 0) {
            return 0;
        }
        int[] gradeArray = new int[n];
        for (int i = 0; i < n; i++) {
            gradeArray[i] = gradeList.get(i).getGrade();
        }
        // nyt mulla on vektori jossa on integer muotoiset gradet
        // nyt laitetaan ne kokojärjestuykseen
        Arrays.sort(gradeArray);
        if (n % 2 == 1) {
            return gradeArray[n / 2];
        } else {
            return (gradeArray[n / 2] + gradeArray[(n / 2) - 1]) / 2.0;
        }

        // arraylistin objekteista tehdään integerien arrayList
        // sitten intArrayLististä tehdään array (eli tehdään loopissa otetaan jokainen
        // ja laitetaan ne integerinä listaan ja sitten mulla on lista integerejä)
        // sitten tavallinen intarray sortataan
        // sitten otetaan keskimmäinen
        // gradeList.toArray
        // int[] gradeArray;

    }
}
