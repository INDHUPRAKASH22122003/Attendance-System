package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewStudent extends AbViewStudent {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public ViewStudent(String studentName) {
		super();
		this.studentName = studentName;
	}
	
	public ViewStudent() {
		
	}
	public void vStudent() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost/school";
		String username = "root";
		String password = "indhu123";
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		String sql = "SELECT sid,studentId,studentName,className,section,date,attendanceStatus FROM studentAttendance where studentName=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, getStudentName());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next() == false) { 
					System.out.println("No records found for "+getStudentName()); 
					return;
			}
			do{
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7));
			}while(resultSet.next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewStudentAttendance() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/school";
		String username = "root";
		String password = "indhu123";
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		String sql = "SELECT * FROM studentAttendance";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}