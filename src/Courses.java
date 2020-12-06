import java.io.*;
import java.util.*;

// The Courses Class stores the student's name, course, and creates and reads the gradebook file.
public class Courses extends Assignments {

    // Class field(s)
    protected String studentName; // Stores student name.
    protected String courseOne = "COP 2006"; // Course 1 storage;
    protected List<String> fileStorage = new ArrayList<>(); // Stores file contents.

    // Constructor
    Courses() {
        super();
    }

    // Method for displaying course(s)
    public String printCourseOne() {
        return courseOne;
    }

    // Method for creating gradebook file.
    protected void createFile(double weight, char letter) throws IOException {
        File gradebookFile = new File("src/gradebook.txt");
        if (!gradebookFile.exists()) {
            gradebookFile.createNewFile();
        }
        try {
            // Wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(gradebookFile, true));
            bufferedWriter.write("Student 1: " + studentName + "\n" + "Course: " + printCourseOne() + "\n" +
                    "Percentage: " + weight + " %" + "\n" + "Grade: " + letter + "\n");
            bufferedWriter.close(); // Close the file.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for reading the gradebook file.
    public void readFile() {
        try {
            FileReader reader = new FileReader("src/gradebook.txt");
            BufferedReader bReader = new BufferedReader(reader);

            String line;
            while ((line = bReader.readLine()) != null) {
                fileStorage.add(line.toLowerCase());
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + Arrays.toString(ex.getStackTrace()));
        } catch (IOException e) {
            System.out.println("Problem reading file: " + Arrays.toString(e.getStackTrace()));
        }
    }
}