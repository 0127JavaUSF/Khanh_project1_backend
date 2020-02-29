package com.revature.model;

public class ReimbursementTicket {
	private int reimb_Id;
	private double reimb_Amount;
	private String reimb_Submitted;
	private String reimb_Resolved;
	private String reimb_Description;
	private String reimb_Receipt;
	private int reimb_Author;
	private int reimb_Resolver;
	private int reimb_Status_Id;
	private int reimb_Type_Id;
	
	public ReimbursementTicket () {
		super ();
	}
	
	public ReimbursementTicket (int reimb_id, double reimb_Amount, String reimb_sub, String reimb_resolved, String reimb_Desc, String reimb_Recipt, int reimb_Au, int reimb_Resv, int reimb_Stid, int reimb_Tid ) {
		super ();
		this.reimb_Id = reimb_id;
		this.reimb_Amount = reimb_Amount;
		this.reimb_Submitted = reimb_sub;
		this.reimb_Resolved = reimb_resolved;
		this.reimb_Description = reimb_Desc;
		this.reimb_Receipt = reimb_Recipt;
		this.reimb_Author = reimb_Au;
		this.reimb_Resolver = reimb_Resv;
		this.reimb_Status_Id = reimb_Stid;
		this.reimb_Type_Id = reimb_Tid;
	}	
	
	public ReimbursementTicket (double reimb_Amount, String reimb_Desc, String reimb_Recipt, int reimb_Au, int reimb_Tid ) {
		super ();
		
		this.reimb_Amount = reimb_Amount;
		this.reimb_Description = reimb_Desc;
		this.reimb_Receipt = reimb_Recipt;
		this.reimb_Author = reimb_Au;
		this.reimb_Type_Id = reimb_Tid;
	}
	
	public int getReimb_Id() {
		return reimb_Id;
	}
	public void setReimb_Id(int reimb_Id) {
		this.reimb_Id = reimb_Id;
	}
	public double getReimb_Amount() {
		return reimb_Amount;
	}
	public void setReimb_Amount(double reimb_Amount) {
		this.reimb_Amount = reimb_Amount;
	}
	public String getReimb_Submitted() {
		return reimb_Submitted;
	}
	public void setReimb_Submitted(String reimb_Submitted) {
		this.reimb_Submitted = reimb_Submitted;
	}
	public String getReimb_Resolved() {
		return reimb_Resolved;
	}
	public void setReimb_Resolved(String reimb_Resolved) {
		this.reimb_Resolved = reimb_Resolved;
	}
	public String getReimb_Description() {
		return reimb_Description;
	}
	public void setReimb_Description(String reimb_Description) {
		this.reimb_Description = reimb_Description;
	}
	public String getReimb_Receipt() {
		return reimb_Receipt;
	}
	public void setReimb_Receipt(String reimb_Receipt) {
		this.reimb_Receipt = reimb_Receipt;
	}
	public int getReimb_Author() {
		return reimb_Author;
	}
	public void setReimb_Author(int reimb_Author) {
		this.reimb_Author = reimb_Author;
	}
	public int getReimb_Resolver() {
		return reimb_Resolver;
	}
	public void setReimb_Resolver(int reimb_Resolver) {
		this.reimb_Resolver = reimb_Resolver;
	}
	public int getReimb_Status_Id() {
		return reimb_Status_Id;
	}
	public void setReimb_Status_Id(int reimb_Status_Id) {
		this.reimb_Status_Id = reimb_Status_Id;
	}
	public int getReimb_Type_Id() {
		return reimb_Type_Id;
	}
	public void setReimb_Type_Id(int reimb_Type_Id) {
		this.reimb_Type_Id = reimb_Type_Id;
	}
	@Override
	public String toString() {
		return "ReimbursementTicket [reimb_Id=" + reimb_Id + ", reimb_Amount=" + reimb_Amount + ", reimb_Submitted="
				+ reimb_Submitted + ", reimb_Resolved=" + reimb_Resolved + ", reimb_Description=" + reimb_Description
				+ ", reimb_Receipt=" + reimb_Receipt + ", reimb_Author=" + reimb_Author + ", reimb_Resolver="
				+ reimb_Resolver + ", reimb_Status_Id=" + reimb_Status_Id + ", reimb_Type_Id=" + reimb_Type_Id + "]";
	}
}
