import java.sql.*;

public class StudentDatabase {

    // Database URL, user, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database"; // Update with your DB URL
    private static final String JDBC_USER = "your_username"; // Update with your DB username
    private static final String JDBC_PASSWORD = "your_password"; // Update with your DB password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Create table
            createTable(connection);
            
            // Insert rows
            insertStudent(connection, "John Doe", 1001, 45);
            insertStudent(connection, "Jane Smith", 1002, 55);
            insertStudent(connection, "Alice Johnson", 1003, 60);
            
            // Retrieve and display all rows
            System.out.println("All Students:");
            displayAllStudents(connection);
            
            // Retrieve students with more than 50 marks
            System.out.println("Students with more than 50 marks:");
            displayHighScorers(connection);
            
            // Increase marks of students who scored less than 50 by 4
            updateMarks(connection);
            
            // Retrieve and display all rows after update
            System.out.println("All Students After Update:");
            displayAllStudents(connection);
            
            // Delete student with roll number 1008
            deleteStudent(connection, 1008);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Student ("
                + "sname VARCHAR(50), "
                + "srollno INT PRIMARY KEY, "
                + "smarks INT)";
        
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'Student' created or already exists.");
        }
    }

    private static void insertStudent(Connection connection, String name, int rollNo, int marks) throws SQLException {
        String insertSQL = "INSERT INTO Student (sname, srollno, smarks) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, rollNo);
            pstmt.setInt(3, marks);
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + name);
        }
    }

    private static void displayAllStudents(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM Student";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            while (rs.next()) {
                String name = rs.getString("sname");
                int rollNo = rs.getInt("srollno");
                int marks = rs.getInt("smarks");
                System.out.printf("Name: %s, Roll No: %d, Marks: %d%n", name, rollNo, marks);
            }
        }
    }

    private static void displayHighScorers(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM Student WHERE smarks > 50";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            while (rs.next()) {
                String name = rs.getString("sname");
                int rollNo = rs.getInt("srollno");
                int marks = rs.getInt("smarks");
                System.out.printf("Name: %s, Roll No: %d, Marks: %d%n", name, rollNo, marks);
            }
        }
    }

    private static void updateMarks(Connection connection) throws SQLException {
        String updateSQL = "UPDATE Student SET smarks = smarks + 4 WHERE smarks < 50";
        
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Updated marks for " + rowsAffected + " student(s) who scored less than 50.");
        }
    }

    private static void deleteStudent(Connection connection, int rollNo) throws SQLException {
        String deleteSQL = "DELETE FROM Student WHERE srollno = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, rollNo);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Deleted student with roll number " + rollNo + ". Rows affected: " + rowsAffected);
        }
    }
}
