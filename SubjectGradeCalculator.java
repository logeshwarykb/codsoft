import java.util.Scanner;

public class SubjectGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfSubjects;
        int totalMarks = 0;
        double averagePercentage;

        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = input.nextInt();

        // Input marks for each subject and calculate total marks
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = input.nextInt();
            totalMarks += marks;
        }

        // Calculate average percentage
        averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine grade based on average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        input.close();
    }
}
