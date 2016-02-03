package com.globant.training.glb_training;


public class Comic implements Comparable<Comic>{
	private String name;
	private String genre;
	private int volume;
	private int copies;
	private boolean borrowed;

	public Comic(String name, String genre, int volume) {
		this.borrowed = false;
		this.name = name;
		this.genre = genre;
		this.volume = volume;
		this.copies = 1;
	}
	
	public String toString(){
		return "["+ name + "] ["+volume+"] ["+genre+"]";
	}
	public String getName() {
		return this.name;
	}

	public String getGenre() {
		return this.genre;
	}

	public int getVolume() {
		return this.volume;
	}

	public boolean getBorrowed() {
		return this.borrowed;
	}
	public void increaseCopies(){
		this.copies+=1;
	}
	public int getCopies(){
		return copies;
	}
	@Override
	public int compareTo(Comic arg0) {
		return (this.getName()+this.getVolume()).compareTo(arg0.getName()+arg0.getVolume());
	}

}
