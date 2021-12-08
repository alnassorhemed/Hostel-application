package hostel_reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hostel_reg.beans.User;

public class UserDao {
	Connection conn = null;

	public UserDao() {
		conn = Database.createConnection();
	}

	/* Get all Users */
	public List<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from users");
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name"),rs.getString("email"), rs.getString("username"), rs.getString("password")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public User get(String id) {
		User result = null;
		String sql = "SELECT * FROM users WHERE Id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/* Add User */
	public int insert(User u) {
		int result = 0;
		String sql = "INSERT INTO users (Name,Email, Username, Password) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getPassword());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(User u) {
		int result = 0;
		String sql = "UPDATE users SET Name=?, Email=?, Username=? WHERE Id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getUsername());
			stmt.setInt(4, u.getId());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		String sql = "DELETE FROM users WHERE Id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean validate(User u) {
		boolean result = true;
		String sql = "SELECT * FROM users WHERE Username=? AND Password=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
