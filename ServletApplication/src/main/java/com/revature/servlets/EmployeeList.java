package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Dao_ReimbursementTicket;
import com.revature.model.ReimbursementTicket;
import com.revature.model.User;

public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper ();
		User user = om.readValue(request.getInputStream(), User.class);
		int roleId = user.getUser_RoleId();
		int userId = user.getUser_Id();
		Dao_ReimbursementTicket drt = new Dao_ReimbursementTicket ();
		List <ReimbursementTicket> list = new ArrayList <ReimbursementTicket>();
		if (roleId == 2) {
			list = drt.listTicketsByUserId (userId);
		}
		response.setContentType("text/html");
		om.writeValue(response.getWriter(), list);
	}
}
