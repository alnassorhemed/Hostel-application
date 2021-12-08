package hostel_reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hostel_reg.beans.Orders;

public class OrderDao {
	Connection conn = null;

	public OrderDao() {
		conn = Database.createConnection();
	}

	/* Get all Orders */
	public List<Orders> getAll() {
		ArrayList<Orders> order = new ArrayList<Orders>();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from book_purchase");
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				order.add(new Orders(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("date"), 
						rs.getString("blocks"), 
						rs.getInt("roomNo"),
						rs.getString("residence"),
						rs.getString("disability"),
						rs.getInt("period") 
					)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	public Orders get(String id) {
		Orders result = null;
		String sql = "SELECT * FROM book_purchase WHERE Id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = new Orders(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("date"), 
						rs.getString("blocks"), 
						rs.getInt("roomNo"), 
						rs.getString("residence"),
						rs.getString("disability"),
						rs.getInt("period")
						
						
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/* Add User */
	public int insert(Orders u) {
		
		int result = 0;
		String sql = "INSERT INTO book_purchase (Name,Date, Blocks, RoomNo, Residence, Disability, Period) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getNames());
			stmt.setString(2, u.getDate());
			stmt.setString(3, u.getBlock());
			stmt.setInt(4, u.getRoomNo());
			stmt.setString(5, u.getResidence());
			stmt.setString(6, u.getDisability());
			stmt.setInt(7, u.getPeriod());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Orders u) {
		int result = 0;
		String sql = "UPDATE book_purchase SET Name=?, Date=?, Blocks=?, RoomNo=?, Residence=?, Disability=?, Period=?, WHERE Id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getNames());
			stmt.setString(2, u.getDate());
			stmt.setString(3, u.getBlock());
			stmt.setInt(4, u.getRoomNo());
			stmt.setString(5, u.getResidence());
			stmt.setString(6, u.getDisability());
			stmt.setInt(7, u.getPeriod());
			stmt.setInt(8, u.getId());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		String sql = "DELETE FROM book_purchase WHERE Id = ?";
		
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
}
