package com.globant.training.glb_training;

public class Loan {
	private Comic comic;
	private User user;
	private String status;
	
	public Loan(Comic comic, User user){
		this.comic = comic;
		this.user = user;
		status = "Pending";
	}
	public void setStatus(String status){
		this.status = status;
	}
	public Comic getComic() {
		return this.comic;
	}

	public User getUser() {
		return this.user;
	}

	public String getStatus() {
		return this.status;
	}
	
	public String toString(){
		return user + " " +  comic + " " + status;
	}

}
