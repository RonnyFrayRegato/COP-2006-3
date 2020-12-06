import java.io.IOException;
import java.util.Scanner;

// The Main Class.
/* This Class receives and stores the student's name and calls two methods that prompt the user to either view old
grades or insert new grades */
public class Main {
    public static void main(String[] args) throws IOException {

        // Receive and store student name.
        Student student1= new Student(); // Object of Student Class to store student name.
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome Student 1! What is your name?:");
        student1.studentName = scan.nextLine(); // Input student name from user.
        System.out.println("Welcome " + student1.studentName + ".");
        student1.viewPreviousGrades(); // Prompts the user to view previous grades.
        student1.getStudentPrompt(); // Prompts the user to insert new grades.
    }
}