package com.globant.training.glb_training.controller;

public class Loan implements Comparable<Loan> {
	private Comic comic;
	private User user;
	private String status;

	public Loan(Comic comic, User user) {
		this.comic = comic;
		this.user = user;
		status = "Pending Approval";
	}

	public void setStatus(String status) {
		if(status.equals("Accepted")||status.equals("Pending Approval"))this.status = status;
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

	public String toString() {
		return String.format("%-16s %s %-16s", user.getUser(),comic,status);
	}
	
	public String toStringBasic(){
		return String.format("%s %-16s", comic.toStringBasic(),status);
	}
	
	public boolean equals(Loan l){
		if (this.compareTo(l)==0) return true;
		return false;
	}

	@Override
	public int compareTo(Loan l) {
		return (this.getComic().toString()+this.getUser().toString()).compareTo(l.getComic().toString()+l.getUser().toString());
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

}
