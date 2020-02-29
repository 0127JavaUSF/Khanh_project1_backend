package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class Dao_User {
	public boolean flag = false;
	protected int uid;
	protected int rid;
	protected String fname;
	protected String lname;
	
	public User getUser (String u_name) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT ERS_USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME = ?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				uid = rs.getInt("ERS_USER_ID");
				fname = rs.getString("USER_FIRST_NAME");
				lname = rs.getString("USER_LAST_NAME");
				rid = rs.getInt("USER_ROLE_ID");
				return new User (uid, fname, lname, rid);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getUserRoleId (User user) {
		
		int roleId;
		roleId = user.getUser_RoleId();
		
		return roleId;
	}
	
	public int getUserId (User user) {
		
		int userId;
		userId = user.getUser_Id();
		
		return userId;
	}

	public void logIn (String uname, String password) {

		String sql = "SELECT * FROM ERS_USERS;" ;
		PreparedStatement ps;  
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (uname.equals(rs.getString("ERS_USERNAME")) && password.equals(rs.getString("ERS_PASSWORD"))) {
				 flag = true;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
