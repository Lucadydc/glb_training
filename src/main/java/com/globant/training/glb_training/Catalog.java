package com.globant.training.glb_training;

import java.util.ArrayList;

public class Catalog {
	private static ArrayList<Comic> comics = new ArrayList<Comic>();
	private static ArrayList<Loan> loans = new ArrayList<Loan>();;
	private static ArrayList<User> users= new ArrayList<User>();
	private static ArrayList<String> genres= new ArrayList<String>();
	
	public ArrayList<Comic> getComics(){
		return comics;
	}
	public ArrayList<Loan> getLoans(){
		return loans;
	}
	public ArrayList<User> getUsers(){
		return users;
	}
	public ArrayList<String> getGenres(){
		return genres;
	}
	public void addComic(Comic comic){
		comics.add(comic);
	}
	public void addLoan(Loan loan){
		loans.add(loan);
	}
	public void addUser(User user){
		users.add(user);
	}
	public void addGenre(String genre){
		genres.add(genre);
	}
	public boolean removeComic(Comic comic){
		return comics.remove(comic);
	}
	public boolean removeUser(User user){
		return users.remove(user);
	}
	
}
