import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private double averagePercentage;
    private String grade;

    public Student(String name, int numSubjects) {
        this.name = name;
        this.marks = new int[numSubjects];
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        int totalMarks = 0;
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                i--;
                continue;
            }

            totalMarks += marks[i];
        }

        this.averagePercentage = (double) totalMarks / marks.length;
        this.grade = calculateGrade(averagePercentage);
    }

    private String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayResults() {
        System.out.println("\n--- Results for " + name + " ---");
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public int getTotalMarks() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    public String getName() {
        return name;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public String getGrade() {
        return grade;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Grade Calculator!");

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        Student[] students = new Student[numStudents];

        // Input for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name for student " + (i + 1) + ": ");
            String studentName = scanner.next();
            students[i] = new Student(studentName, numSubjects);
            students[i].inputMarks();
        }

        // Display results for each student
        System.out.println("\n--- Student Results ---");
        for (Student student : students) {
            student.displayResults();
        }

        // Display statistics for all students
        displayClassStatistics(students);

        scanner.close();
    }

    private static void displayClassStatistics(Student[] students) {
        int totalStudents = students.length;
        double totalPercentage = 0;
        int numA = 0, numB = 0, numC = 0, numD = 0, numF = 0;

        for (Student student : students) {
            totalPercentage += student.getAveragePercentage();

            switch (student.getGrade()) {
                case "A":
                    numA++;
                    break;
                case "B":
                    numB++;
                    break;
                case "C":
                    numC++;
                    break;
                case "D":
                    numD++;
                    break;
                case "F":
                    numF++;
                    break;
            }
        }

        double averageClassPercentage = totalPercentage / totalStudents;
        System.out.println("\n--- Class Statistics ---");
        System.out.println("Average Class Percentage: " + averageClassPercentage + "%");
        System.out.println("Number of Students with Grade A: " + numA);
        System.out.println("Number of Students with Grade B: " + numB);
        System.out.println("Number of Students with Grade C: " + numC);
        System.out.println("Number of Students with Grade D: " + numD);
        System.out.println("Number of Students with Grade F: " + numF);
    }
}
