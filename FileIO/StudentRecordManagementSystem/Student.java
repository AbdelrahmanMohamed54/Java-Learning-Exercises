package FileIO.StudentRecordManagementSystem;

import java.util.Arrays;

public class Student {
    private int studentId;
    private String name;
    private int[] grades;

    public Student(int studentId, String name, int[] grades) {
        this.studentId = studentId;
        this.name = name;
        this.grades = grades;
    }

    public double calculateAverageGrade() {
        return Arrays.stream(grades).average().orElse(0.0);
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.println("Average Grade: " + calculateAverageGrade());
    }

    public int getStudentId() {
        return studentId;
    }

    public int[] getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
}
