package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ReimbursementTicket;
import com.revature.util.ConnectionUtil;

public class Dao_ReimbursementTicket {
	
	public ReimbursementTicket getTickets(ResultSet rs) throws SQLException {
		int reimbId = rs.getInt("reimb_id");
		double reimbAmount = rs.getDouble ("reimb_amount");
		String reimbSubmitted = rs.getString(("reimb_submitted").toString());
		String reimbResolved = rs.getString(("reimb_resolved").toString());
		String reimbDescription = rs.getString("reimb_description");
		String reimbReceipt = rs.getString("reimb_receipt");
		int reimbAuthor = rs.getInt("reimb_author");
		int reimbResolver = rs.getInt("reimb_resolver");
		int reimbStatusId = rs.getInt("reimb_status_id");
		int reimbTypeId = rs.getInt("reimb_type_id");
		
		return new ReimbursementTicket (reimbId, reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbReceipt, reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId );
	}
	
	public ReimbursementTicket createTicket (ReimbursementTicket ticket) throws SQLException {
		
		//ReimbursementTicket newTicket = new ReimbursementTicket ();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String insert = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_TYPE_ID) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setDouble(1, ticket.getReimb_Amount());
			ps.setString(2, ticket.getReimb_Description());
			ps.setString(3, ticket.getReimb_Receipt());
			ps.setInt(4, ticket.getReimb_Author());
			ps.setInt(5, ticket.getReimb_Type_Id());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}
	
	public ReimbursementTicket setTicketStatus (int reimbId, int resolver, int reimbStatusId) throws SQLException {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String insert = "UPDATE ERS_REIMBURSEMENT SET ERS_REIMBURSEMENT.REIMB_RESOLVER = ?, ERS_REIMBURSEMENT.REIMB_STATUS_ID = ? WHERE ERS_REIMNBURSEMENT.REIMB_ID = ?" ;
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.executeUpdate();
			ps.setInt(1, resolver);
			ps.setInt(2, reimbStatusId);
			ps.setInt(3, reimbId);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ReimbursementTicket> listTickets () {
			
		List<ReimbursementTicket> ticketList = new ArrayList<ReimbursementTicket>();
			
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT;" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ticketList.add(getTickets(rs));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
	public List<ReimbursementTicket> listTicketsByUserId (int auId) {
		
		List<ReimbursementTicket> ticketList = new ArrayList<ReimbursementTicket>();
			
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?;" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, auId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ticketList.add(getTickets(rs));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
}
