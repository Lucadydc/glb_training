package com.globant.training.glb_training;

import java.util.Date;

public class Comic {
	private String name;
	private String genre;
	private Date releaseDate;
	private boolean borrowed;

	public String getName() {
		return this.name;
	}

	public String getGenre() {
		return this.genre;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public boolean getBorrowed() {
		return this.borrowed;
	}

}
