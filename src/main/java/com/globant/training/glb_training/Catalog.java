package com.globant.training.glb_training;

import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog {
	private static TreeSet<Comic> comics = new TreeSet<Comic>();
	private static TreeSet<Loan> loans = new TreeSet<Loan>();
	private static TreeSet<User> users = new TreeSet<User>();
	private static TreeSet<String> genres = new TreeSet<String>();

	public static TreeSet<Comic> getComics() {
		return comics;
	}

	public static TreeSet<Loan> getLoans() {
		return loans;
	}

	public static TreeSet<User> getUsers() {
		return users;
	}

	public static TreeSet<String> getGenres() {
		return genres;
	}

	public static void addComic(Comic comic) {
		if(!comics.add(comic))	comics.stream().filter(s-> s.equals(comic)).forEach(s->s.increaseCopies());
		
	}

	public static boolean addLoan(Loan loan) {
		if(!loan.getComic().decreaseCopies()) return false;
		loan.setStatus("Accepted");
		return true;
	}
	public static boolean askLoan(Loan loan){
		return loans.add(loan);
	}
	public static void addUser(User user) {
		users.add(user);
	}

	public static void addGenre(String genre) {
		genres.add(genre);
	}

	public static boolean removeComic(Comic comic) {
		if(loans.stream().filter(s->s.getComic().equals(comic)).count() >0)return false;
		return comics.remove(comic);
	}

	public static boolean removeUser(User user) {
		ArrayList<Loan> list = new ArrayList<Loan>();
		loans.stream().filter(s->s.getUser().equals(user)).forEach(s->list.add(s));
		list.stream().forEach(s->Catalog.removeLoan(s));
		return users.remove(user);
	}
	public static boolean removeLoan(Loan loan){
		if(loan.getStatus().equals("Accepted"))loan.getComic().increaseCopies();
		return loans.remove(loan);
	}
	public static boolean removeGenre(String genre){
		if(comics.stream().filter(s->s.getGenre().equals(genre)).count()>0)return false;
		return genres.remove(genre);
	}
	public static void editGenre(String originalGenre, String genre){
		comics.stream().filter(s->s.getGenre().equals(originalGenre)).forEach(s->s.setGenre(genre));
		genres.stream().filter(s->s.equals(originalGenre)).forEach(s->s=genre);
	}
}
