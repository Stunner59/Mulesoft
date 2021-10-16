package net.codejava;

import java.sql.*;

public class SQLiteDemo {

	public static void main(String[] args) throws Exception {
		
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\sarwe\\OneDrive\\Documents\\SQLite\\sqlite-tools-win32-x86-3360000\\movies.db";
		
			Connection connection = DriverManager.getConnection(jdbcUrl);
			Statement statement = connection.createStatement();
			
			String query = "insert into movie (MovieName, actor, actress, realeseyear, directorname)" + "values(?, ?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, "RaOne");
			ps.setString(2, "SRK");
			ps.setString(3, "Kareena");
			ps.setInt(4, 2012);
			ps.setString(5, "RK");
			
			
			
			String sql = "SELECT * FROM movie";
			
			ResultSet result = statement.executeQuery(sql);
			
			
			
			while(result.next()) {
//				int id = 0;
//				Integer id = result.getInt("rid");

				String movie = result.getString("MovieName");
				String actor = result.getString("actor");
				String actress = result.getString("actress");
				int year = result.getInt("realeseyear");
				String Director = result.getString("directorname");
				System.out.println(movie + " | "+ actor +" | "+ actress +" | "+ year +" | " + Director);
			}
			


	}

}
