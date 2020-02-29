package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Dao_ReimbursementTicket;
import com.revature.model.ReimbursementTicket;

public class NewReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper ();
		ReimbursementTicket ticket = om.readValue(request.getReader(), ReimbursementTicket.class);
		
		/*double amount = ticket.getReimb_Amount();
		String description = ticket.getReimb_Description();
		String receipt = ticket.getReimb_Receipt();
		int user_Id = ticket.getReimb_Author();
		int type_Id = ticket.getReimb_Type_Id();*/
		
		Dao_ReimbursementTicket drt = new Dao_ReimbursementTicket ();
		
		try {
			drt.createTicket(ticket);
			response.setStatus(200);
		} catch (SQLException e) {
			response.setStatus(500);
			e.printStackTrace();
		}
		
	}

}
