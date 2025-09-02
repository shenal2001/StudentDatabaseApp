import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        System.out.println("== Student Management Console App ==");
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addStudent(); break;
                case "2": updateStudent(); break;
                case "3": deleteStudent(); break;
                case "4": viewStudent(); break;
                case "5": listStudents(); break;
                case "6":
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add student");
        System.out.println("2. Update student");
        System.out.println("3. Delete student");
        System.out.println("4. View student by id");
        System.out.println("5. List all students");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() {
        System.out.println("\n-- Add student --");
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Phone: ");
        String phone = sc.nextLine().trim();
        System.out.print("DOB (YYYY-MM-DD) or leave blank: ");
        String dob = sc.nextLine().trim();
        if (dob.isEmpty()) dob = null;

        Student s = new Student(name, email, phone, dob);
        int id = dao.addStudent(s);
        if (id > 0) {
            System.out.println("Student added with id: " + id);
        } else {
            System.out.println("Failed to add student. See errors above.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n-- Update student --");
        System.out.print("Enter student id to update: ");
        int id = readInt();
        Student existing = dao.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found with id " + id);
            return;
        }
        System.out.println("Existing: " + existing);

        System.out.print("New name (leave blank to keep): ");
        String name = sc.nextLine().trim();
        if (!name.isEmpty()) existing.setName(name);

        System.out.print("New email (leave blank to keep): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) existing.setEmail(email);

        System.out.print("New phone (leave blank to keep): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) existing.setPhone(phone);

        System.out.print("New DOB (YYYY-MM-DD) (leave blank to keep/remove): ");
        String dob = sc.nextLine().trim();
        if (!dob.isEmpty()) existing.setDob(dob);

        boolean ok = dao.updateStudent(existing);
        System.out.println(ok ? "Student updated." : "Update failed.");
    }

    private static void deleteStudent() {
        System.out.println("\n-- Delete student --");
        System.out.print("Enter student id to delete: ");
        int id = readInt();
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.println("No student with id " + id);
            return;
        }
        System.out.println("About to delete: " + s);
        System.out.print("Are you sure? (y/N): ");
        String ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("y") || ans.equals("yes")) {
            boolean ok = dao.deleteStudent(id);
            System.out.println(ok ? "Deleted." : "Delete failed.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    private static void viewStudent() {
        System.out.println("\n-- View student --");
        System.out.print("Enter student id: ");
        int id = readInt();
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.println("Not found.");
        } else {
            System.out.println(s);
        }
    }

    private static void listStudents() {
        System.out.println("\n-- All students --");
        List<Student> list = dao.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private static int readInt() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }
}
