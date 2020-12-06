import java.io.IOException;

/* The Student Class prompts the the student to either view previous grades, or insert new grades through a loop that
receives and stores grades and performs grade calculations and file operations. */
public class Student extends Courses {

    // Class field(s)
    public char studentPromptNewGrades;
    public char studentPromptOldGrades;
    public boolean studentPrompt = true;

    /* Method to prompt the student to insert new grades, receives and stores grades, calculates and displays weighted
    grade and letter grade, and creates a file with the information. */
    public void getStudentPrompt() throws IOException {

        // Loop prompting the student to insert new grades and perform grade calculations and file operations.
        while (studentPrompt) {

            // Print out course.
            System.out.println("Please enter grades for " + printCourseOne() + ":");
            // Receive, store, and display student grades.
            storeGrades(courseOneGrades); // Input and store grades from student.
            // Calculate and display weighted overall student grade.
            System.out.println("Your weighted average for " + courseOne + " is: "
                    + calculateGradeWeight(courseOneGrades) + " %");
            weight = calculateGradeWeight(courseOneGrades); // Determine letter grade.
            System.out.println(checkGrade(weight)); // Display letter grade.
            // Create file and store student name, weighted overall student grade, and letter grade.
            createFile(weight, checkGrade(weight));

            System.out.println("Would you like to continue inserting grades for " + courseOne + " (Yes or No)");
            studentPromptNewGrades = scan.next().toLowerCase().charAt(0);
            // if statement prompting the user to insert new grades.
            if (studentPromptNewGrades == 'y') {
                studentPrompt = true;
                System.out.println("Very well. Let's continue.");
            } else if (studentPromptNewGrades == 'n') {
                studentPrompt = false;
                System.out.println("You're done!");
            } else {
                System.out.println("This is not a valid entry. Let's continue.");
                studentPrompt = true;
            }
        }
    }

    //Method to display previous grades.
    public void viewPreviousGrades() {
        System.out.println("Would you like to view previous grades for " + courseOne + " (Yes or No)");
        studentPromptOldGrades = scan.next().toLowerCase().charAt(0);
        if (studentPromptOldGrades == 'y') {
            readFile();
            System.out.println(fileStorage);
            System.exit(0);
        } else if (studentPromptOldGrades == 'n') {
            System.out.println("Very well. Let's continue.");
        } else {
            System.out.println("This is not a valid entry.");
        }
    }
}