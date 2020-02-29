package com.revature.servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.revature.dao.Dao_User;
import com.revature.model.User;


public class UserLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init()  {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashFunction sha256hex = Hashing.sha256();			  
		String username = request.getParameter("username");
		String password = sha256hex.hashString(request.getParameter("password"), StandardCharsets.UTF_8).toString();
		Dao_User du = new Dao_User ();
		User user = new User ();	
		du.logIn(username, password);
		if (du.flag == true) {
			user = du.getUser(username);
		}	
		response.setContentType("text/html");
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), user);
	}

}


