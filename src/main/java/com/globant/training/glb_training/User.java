package com.globant.training.glb_training;

import java.util.ArrayList;


public class User extends Person {
	private String user;
	private String pass;
	private ArrayList<Loan> loans;
	
	
	


	public String getUser() {
		return this.user;
	}

	public String getPass() {
		return this.pass;
	}

	public ArrayList<Loan> getLoans() {
		return this.loans;
	}

}
