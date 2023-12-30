import java.sql.*;

public class QLSV {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "nguyenhuudung2003";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // JDBC ket noi
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            // them 3 sinh vien vao bang
            addStudents(connection);
            // them 3 khoa hoc vao bang
            addCourses(connection);
            // Hien thi mon hoc co so tin chi > 3
            displayCoursesWithCreditGreaterThan3(connection);
            // Nhap điem cho 1 sinh vien, 3 mon hoc, hay hien thi ds mon hoc, điem cua sv đo
            enterGradesAndDisplayResult(connection);
            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Khong ket noi thanh cong!");
        }
    }

    private static void addStudents(Connection connection) throws SQLException {
        // them 3 sinh vien vao bang SV
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO SV VALUES (1, 'Student1', '2000-01-01', 'Note1')");
            statement.execute("INSERT INTO SV VALUES (2, 'Student2', '2000-02-02', 'Note2')");
            statement.execute("INSERT INTO SV VALUES (3, 'Student3', '2000-03-03', 'Note3')");
        }
    }

    private static void addCourses(Connection connection) throws SQLException {
        // Them 3 mon hoc vao bang Monhoc
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO Monhoc VALUES (1, 'Course1', 4)");
            statement.execute("INSERT INTO Monhoc VALUES (2, 'Course2', 2)");
            statement.execute("INSERT INTO Monhoc VALUES (3, 'Course3', 5)");
        }
    }

    private static void displayCoursesWithCreditGreaterThan3(Connection connection) throws SQLException {
        // Hien thi mon hoc co so tin chi > 3
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Monhoc WHERE SoTC > 3")) {

            System.out.println("Cac mon co tin chi > 3:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("tenMH"));
            }
        }
    }

    private static void enterGradesAndDisplayResult(Connection connection) throws SQLException {
            // Nhap điem cho 1 sinh vien, 3 mon hoc, hay hien thi ds mon hoc, điem cua sv đo
        try (Statement statement = connection.createStatement()) {
            // Nhap dem cho sinh vien co Ma 1
            int studentId = 1;
            // Nhap diem 3 mon
            statement.execute("INSERT INTO Diem VALUES (1, 1, 85)");
            statement.execute("INSERT INTO Diem VALUES (1, 2, 75)");
            statement.execute("INSERT INTO Diem VALUES (1, 3, 90)");
            // Display the result
            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT Monhoc.tenMH, Diem.Diem FROM Monhoc " +
                            "JOIN Diem ON Monhoc.Mamh = Diem.MaMH " +
                            "WHERE Diem.Msv = " + studentId)) {

                System.out.println("Grades for student with ID " + studentId + ":");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("tenMH") + ": " + resultSet.getFloat("Diem"));
                }
            }
        }
    }
}
