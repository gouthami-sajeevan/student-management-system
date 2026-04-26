import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");

                int id = sc.nextInt();

                System.out.print("Enter Name: ");
                sc.nextLine(); // clear buffer
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Course: ");
                String course = sc.next();

                Student s = new Student(id, name, age, course);
                service.addStudentToDB(s);

            } else if (choice == 2) {
                service.viewStudents();

            } else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                service.deleteStudent(id);

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}