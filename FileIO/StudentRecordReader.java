package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentRecordReader {
    public static void main(String[] args) {
        try {
            // Read student data from the file
            File file = new File("students.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int studentId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int[] grades = new int[data.length - 2];

                for (int i = 2; i < data.length; i++) {
                    grades[i - 2] = Integer.parseInt(data[i].trim());
                }

                // Process student data (You can perform additional operations here)
                System.out.println("Student ID: " + studentId);
                System.out.println("Name: " + name);
                System.out.println("Grades: " + java.util.Arrays.toString(grades));
                System.out.println();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}

