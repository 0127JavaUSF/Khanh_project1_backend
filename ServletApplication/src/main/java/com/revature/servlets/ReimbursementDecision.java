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

public class ReimbursementDecision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		ReimbursementTicket decision = om.readValue(request.getInputStream(), ReimbursementTicket.class);
		
		int user_Id = decision.getReimb_Resolver();
		int reimb_Id = decision.getReimb_Id();
		int status_Id = decision.getReimb_Status_Id();
		
		Dao_ReimbursementTicket drt = new Dao_ReimbursementTicket ();
		try {
			drt.setTicketStatus(reimb_Id, user_Id, status_Id );
			response.setStatus(200);
		} catch (SQLException e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}
}
