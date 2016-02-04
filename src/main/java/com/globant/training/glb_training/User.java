package com.globant.training.glb_training;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class User extends Person implements Comparable<User> {
	private String user;
	private String pass;
	
	final private String[] operaciones = {"0 Ver Listado de Comics",
			"1 Log Out",
			"2 Ver préstamos",
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
		return (ArrayList<Loan>) Catalog.getLoans().stream().filter(s->s.getUser().equals(this)).collect(Collectors.toList());
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
		if(Catalog.getLoans().stream().filter(s->s.getUser().equals(this)).collect(Collectors.toList()).size()==0){
			System.out.println("\n--No tiene préstamos--\n");
			return this;
		}
		System.out.println("\n--Sus préstamos son--\n");
		this.getLoans().forEach(s -> System.out.println(s.toStringBasic()));
		return this;
	}

	// 3
	public Person addLoan() {
		System.out.println("\n--Elija un comic de la lista--\n");
		ArrayList<Comic> comics = new ArrayList<Comic>(Catalog.getComics());
		for (int i = 0; i < comics.size(); i++)
			System.out.println(i + " " + comics.get(i).toString());
		Comic comic = comics.get(Reader.readInt());
		Loan loan = new Loan(comic, this);
		if (Catalog.askLoan(loan)) {
			System.out.println("\n--Préstamo pedido con éxito--\n");
			return this;
		}
		System.out.println("\n--El préstamo no pudo ser pedido--\n");
		return this;
	}

	// 4
	public Person removeLoan() {
		if(this.getLoans().size()==0){
			System.out.println("\n--No tiene préstamos--\n");
			return this;
		}
		System.out.println("Elija un préstamo de la lista:\n");
		ArrayList<Loan> loans = this.getLoans();
		for(int i =0;i<loans.size();i++)System.out.println(i+ " " + loans.get(i).toStringBasic());
		int loan = Reader.readInt();
		Catalog.removeLoan(loans.get(loan));
		loans.remove(loans.get(loan));
		return this;
	}

}
