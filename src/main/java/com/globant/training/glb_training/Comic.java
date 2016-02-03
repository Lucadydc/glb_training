package com.globant.training.glb_training;


public class Comic {
	private String name;
	private String genre;
	private int releaseYear;
	private boolean borrowed;

	public Comic(String name, String genre, int year) {
		this.borrowed = false;
		this.name = name;
		this.genre = genre;
		this.releaseYear = year;
	}
	
	public String toString(){
		return "["+ name + "] ["+releaseYear+"] ["+genre+"]";
	}
	public String getName() {
		return this.name;
	}

	public String getGenre() {
		return this.genre;
	}

	public int getReleaseDate() {
		return this.releaseYear;
	}

	public boolean getBorrowed() {
		return this.borrowed;
	}

}
