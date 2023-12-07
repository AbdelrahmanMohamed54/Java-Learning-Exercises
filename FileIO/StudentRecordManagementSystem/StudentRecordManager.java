package FileIO.StudentRecordManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;


public class StudentRecordManager {
    private static final String FILE_NAME = "students.txt";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudentDataFromFile();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        displayAllStudents();
                        break;
                    case 2:
                        displayStudentDetails(scanner);
                        break;
                    case 3:
                        addNewStudent(scanner);
                        break;
                    case 4:
                        updateStudentGrades(scanner);
                        break;
                    case 5:
                        deleteStudent(scanner);
                        break;
                    case 6:
                        saveStudentDataToFile();
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 6);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Exiting the program.");
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Record Management System Menu:");
        System.out.println("1. Display all students");
        System.out.println("2. Display student details");
        System.out.println("3. Add a new student");
        System.out.println("4. Update student grades");
        System.out.println("5. Delete a student");
        System.out.println("6. Exit");
    }

    private static void displayAllStudents() {
        System.out.println("\nAll Students:");
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getName());
        }
    }

    private static void displayStudentDetails(Scanner scanner) {
        System.out.print("Enter the student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        if (student != null) {
            student.displayStudentDetails();
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter the student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if student with the same ID already exists
        if (findStudentById(studentId) != null) {
            System.out.println("Error: Student with ID " + studentId + " already exists.");
            return;
        }

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int[] grades = new int[numGrades];
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        Student newStudent = new Student(studentId, name, grades);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void updateStudentGrades(Scanner scanner) {
        System.out.print("Enter the student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.print("Enter the number of grades to update: ");
            int numGrades = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int[] newGrades = new int[numGrades];
            for (int i = 0; i < numGrades; i++) {
                System.out.print("Enter new grade " + (i + 1) + ": ");
                newGrades[i] = scanner.nextInt();
            }

            student.setGrades(newGrades);
            System.out.println("Grades updated successfully.");
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter the student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }

    private static void loadStudentDataFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                int studentId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int[] grades = new int[data.length - 2];

                for (int i = 2; i < data.length; i++) {
                    grades[i - 2] = Integer.parseInt(data[i].trim());
                }

                students.add(new Student(studentId, name, grades));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data file found. Creating a new file on save.");
        }
    }

    private static void saveStudentDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.println(student.getStudentId() + ", " + student.getName() + ", " + Arrays.toString(student.getGrades()));
            }
            System.out.println("Student data saved to the file.");
        } catch (IOException e) {
            System.out.println("Error: Unable to save data to the file.");
        }
    }

    private static Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}

