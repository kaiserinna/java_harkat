package main;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * student luokkaan tulee student olio jossa on opiskelija student, jolla on opiskelijanumero, nimi ja tämän opiskelijan kurssisuoritusLISTA
 */
public class Student implements Serializable {
    private String name;
    private String studentId;
    private ArrayList<Grade> grades; // contains info from courses and grades

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

}
