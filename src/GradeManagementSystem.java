import java.util.Scanner;

public class GradeManagementSystem {

    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECT_COUNT = 5;

    private static StudentGrade[] students = new StudentGrade[MAX_STUDENTS];
    private static int studentCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages & Grades");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt(1, 5);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    calculateGrades();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using Grade Management System!");
                    break;
            }
        }

        scanner.close();
    }

    // ================= ADD STUDENT =================
    private static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        StudentGrade student = new StudentGrade(name, SUBJECT_COUNT);

        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            student.marks[i] = getValidMark();
        }

        students[studentCount++] = student;
        System.out.println("✅ Student added successfully!");
    }

    // ================= VIEW ALL STUDENTS =================
    private static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- STUDENT DETAILS ---");
        for (int i = 0; i < studentCount; i++) {
            double avg = GradeCalculator.calculateAverage(students[i].marks);
            String grade = GradeCalculator.getGrade(avg);
            ReportGenerator.printStudentReport(students[i].name, avg, grade);
        }
    }

    // ================= CALCULATE GRADES =================
    private static void calculateGrades() {
        if (studentCount == 0) {
            System.out.println("No data available.");
            return;
        }

        System.out.println("\n--- AVERAGES & GRADES ---");
        for (int i = 0; i < studentCount; i++) {
            double avg = GradeCalculator.calculateAverage(students[i].marks);
            String grade = GradeCalculator.getGrade(avg);
            System.out.println(students[i].name + " -> Average: " + avg + ", Grade: " + grade);
        }
    }

    // ================= SEARCH STUDENT =================
    private static void searchStudent() {
        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].name.equalsIgnoreCase(searchName)) {
                double avg = GradeCalculator.calculateAverage(students[i].marks);
                String grade = GradeCalculator.getGrade(avg);
                System.out.println("Student Found!");
                ReportGenerator.printStudentReport(students[i].name, avg, grade);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // ================= INPUT VALIDATION =================
    private static int getValidInt(int min, int max) {
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max)
                    return value;
                System.out.print("Enter value between " + min + " and " + max + ": ");
            } catch (Exception e) {
                System.out.print("Invalid input. Enter number: ");
                scanner.nextLine();
            }
        }
    }

    private static double getValidMark() {
        double mark;
        while (true) {
            try {
                mark = scanner.nextDouble();
                scanner.nextLine();
                if (mark >= 0 && mark <= 100)
                    return mark;
                System.out.print("Marks must be 0–100. Re-enter: ");
            } catch (Exception e) {
                System.out.print("Invalid input. Enter number: ");
                scanner.nextLine();
            }
        }
    }
}

