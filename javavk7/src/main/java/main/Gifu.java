package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrollments;

    public Gifu(String university) {
        this.university = university;
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        enrollments = new ArrayList<Enrollment>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(int id) { // parametrina ArrayListin indeksi
        return courses.get(id);
        // todo throwsexception
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void listCourses() {
        for (int i = 0; i < getCourses().size(); i++) {
            System.out.println(i + ") " + getCourses().get(i).getInformation());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ") " + students.get(i).getInformation());
        }
    }

    public void enrollStudent(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));
    }

    // returns ArrayList of objects jossa on halutun kurssin kaikki opiskelijat ja
    // niiden arvosanat
    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> courseEnrollments = new ArrayList<Enrollment>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse() == course) {
                courseEnrollments.add(enrollment);
            }
        }
        return courseEnrollments;
    }

    // tällä saadaan lista objekteja, joissa on halutun opiskelijan kurssit ja
    // niiden arvosanat
    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<Enrollment>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent() == student) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }
}
