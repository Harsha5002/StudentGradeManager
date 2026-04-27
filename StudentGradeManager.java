import java.util.*;

// A simple student grade manager
// Written by Harsha Paul
// This program lets you add students, assign marks, and check results

public class StudentGradeManager {

    // I'm using a LinkedHashMap so insertion order is preserved
    static Map<String, List<Integer>> studentData = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== Student Grade Manager ===");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. View Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> addMarks(sc);
                case 3 -> viewReport();
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option, try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (studentData.containsKey(name)) {
            System.out.println("Student already exists.");
            return;
        }

        studentData.put(name, new ArrayList<>());
        System.out.println(name + " added successfully.");
    }

    static void addMarks(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (!studentData.containsKey(name)) {
            System.out.println("Student not found. Please add them first.");
            return;
        }

        System.out.print("Enter marks (out of 100): ");
        int marks = sc.nextInt();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks. Must be between 0 and 100.");
            return;
        }

        studentData.get(name).add(marks);
        System.out.println("Marks added for " + name);
    }

    static void viewReport() {
        if (studentData.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Grade Report ---");
        for (Map.Entry<String, List<Integer>> entry : studentData.entrySet()) {
            String name = entry.getKey();
            List<Integer> marks = entry.getValue();

            if (marks.isEmpty()) {
                System.out.println(name + " → No marks entered yet.");
                continue;
            }

            double avg = marks.stream().mapToInt(Integer::intValue).average().orElse(0);
            String grade = getGrade(avg);

            System.out.printf("%s → Avg: %.2f | Grade: %s%n", name, avg, grade);
        }
    }

    // Simple grading logic — can be customized
    static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }
}
