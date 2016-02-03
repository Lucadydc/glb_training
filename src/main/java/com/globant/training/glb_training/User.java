package com.globant.training.glb_training;

import java.util.ArrayList;


public class User extends Person implements Comparable<User> {
	private String user;
	private String pass;
	private ArrayList<Loan> loans;
	
	final private String[] operaciones = {"0 Ver Listado de Comics",
			"1 Log Out",
			"2 Ver prástamos",
			"3 Realizar préstamo",
			"4 Finalizar préstamo",
			"5 Salir"};
	
	
	final private Action[] methods = new Action[]{
			new Action(){public Person method(){ return listOfComics();}},//0
			new Action(){public Person method(){ return logOut();}},//1
			new Action(){public Person method(){ return listOfLoans();}},//2
			new Action(){public Person method(){ return addLoan();}},//3
			new Action(){public Person method(){ return removeLoan();}},//4
			new Action(){public Person method(){ return exit();}},//5
			
			}; 

	public String[] getOperaciones() {
		return operaciones;
	}

	public Person method(int index) {
		return methods[index].method();
	}

	public User(String user, String pass) {
		this.user = user;
		this.pass = pass;
		loans = new ArrayList<Loan>();
	}

	public String toString() {
		return user + " " + pass;
	}

	public String getUser() {
		return this.user;
	}

	public String getPass() {
		return this.pass;
	}

	public ArrayList<Loan> getLoans() {
		return this.loans;
	}

	public boolean equals(User u) {
		if (this.compareTo(u) == 0)
			return true;
		return false;
	}

	@Override
	public int compareTo(User u) {
		return this.toString().compareTo(u.toString());
	}

	// 1
	public Person logOut() {
		return new Person();
	}

	// 2
	public Person listOfLoans() {
		this.getLoans().forEach(s -> System.out.println(s.toString()));
		return this;
	}

	// 3
	public Person addLoan() {
		return this;
	}

	// 4
	public Person removeLoan() {
		return this;
	}

}
