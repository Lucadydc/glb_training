package com.globant.training.glb_training;

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
		comics.add(comic);
	}

	public static void addLoan(Loan loan) {
		loans.add(loan);
	}

	public static void addUser(User user) {
		users.add(user);
	}

	public static void addGenre(String genre) {
		genres.add(genre);
	}

	public static boolean removeComic(Comic comic) {
		return comics.remove(comic);
	}

	public static boolean removeUser(User user) {
		return users.remove(user);
	}

}
