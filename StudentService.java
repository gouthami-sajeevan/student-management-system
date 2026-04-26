import java.sql.*;

public class StudentService {

    
    public void addStudentToDB(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());

            ps.executeUpdate();

            System.out.println("Student saved to database!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n--- Students from Database ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("course")
                );
            }

            if (!found) {
                System.out.println("No students found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted from database!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}