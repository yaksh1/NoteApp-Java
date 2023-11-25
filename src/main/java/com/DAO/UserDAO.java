package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.query.Queries;
import com.user.UserDetails;

public class UserDAO {
	private Connection conn;

	/**
	 * @param conn
	 */
	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails userDetails) {
		boolean done = false;
		String query = Queries.insert;
		PreparedStatement st = null;
			
		
		try {
			st = conn.prepareStatement(query);
		
			st.setString(1, userDetails.getName());
			st.setString(2, userDetails.getEmail());
			st.setString(3, userDetails.getMobile());
			st.setString(4, userDetails.getPassword());
			
			int count = st.executeUpdate();
			
			if(count>0) {
				done = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return done;
	}
	
	public String validateUser(String email,String password) {
		String name =null;
		String query = Queries.loginSelect;
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet set =  st.executeQuery();
			
			if(set.next()) {
				name=set.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	
}
