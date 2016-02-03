package com.globant.training.glb_training;

import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog {
	private static ArrayList<Comic> comics = new ArrayList<Comic>();
	private static ArrayList<Loan> loans = new ArrayList<Loan>();
	private static TreeSet<User> users = new TreeSet<User>();
	private static ArrayList<String> genres = new ArrayList<String>();

	public static ArrayList<Comic> getComics() {
		return comics;
	}

	public static ArrayList<Loan> getLoans() {
		return loans;
	}

	public static TreeSet<User> getUsers() {
		return users;
	}

	public static ArrayList<String> getGenres() {
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
