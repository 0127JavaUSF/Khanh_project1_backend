package com.revature.model;

public class User {
	
	private int user_Id;
	private String user_Name;
	private String user_Password;
	private String user_FirstName;
	private String user_LastName;
	private String user_Email;
	private int user_RoleId;

	public User () {
		super ();
	}
	
	/*public User (int u_id, String u_name, String u_pass, String u_fname, String u_lname, String u_email, int u_rid) {
		super ();
		this.user_Id = u_id;
		this.user_Name = u_name;
		this.user_Password = u_pass;
		this.user_FirstName = u_fname;
		this.user_LastName = u_lname;
		this.user_Email = u_email;
		this.user_RoleId = u_rid;	
	}*/
	
	public User (int u_id, String u_fname, String u_lname, int u_rid) {
		super ();
		this.user_Id = u_id;
		this.user_FirstName = u_fname;
		this.user_LastName = u_lname;
		this.user_RoleId = u_rid;	
	}
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	public String getUser_FirstName() {
		return user_FirstName;
	}
	public void setUser_FirstName(String user_FirstName) {
		this.user_FirstName = user_FirstName;
	}
	public String getUser_LastName() {
		return user_LastName;
	}
	public void setUser_LastName(String user_LastName) {
		this.user_LastName = user_LastName;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public int getUser_RoleId() {
		return user_RoleId;
	}
	public void setUser_RoleId(int user_RoleId) {
		this.user_RoleId = user_RoleId;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Name=" + user_Name + ", user_Password=" + user_Password
				+ ", user_FirstName=" + user_FirstName + ", user_LastName=" + user_LastName + ", user_Email="
				+ user_Email + ", user_RoleId=" + user_RoleId + "]";
	}
}

