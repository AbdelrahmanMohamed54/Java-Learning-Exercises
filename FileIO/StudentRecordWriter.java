package FileIO;

import java.io.FileWriter;
import java.io.IOException;

public class StudentRecordWriter {
    public static void main(String[] args) {
        try {
            // Write student data to the file
            FileWriter writer = new FileWriter("students.txt", true);

            // Sample student data
            int studentId = 101;
            String name = "John Doe";
            int[] grades = {90, 85, 92};

            // Write data to the file
            writer.write(studentId + ", " + name + ", " + grades[0] + ", " + grades[1] + ", " + grades[2] + "\n");

            // Close the writer
            writer.close();

            System.out.println("Student data written to the file.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file.");
        }
    }
}

