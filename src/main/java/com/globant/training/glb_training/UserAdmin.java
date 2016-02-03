package com.globant.training.glb_training;

public class UserAdmin extends User {
	final private static String user = "Sheldon";
	final private static String pass = "Bazinga";
	final private String[] operaciones = {"0 Ver Listado de Usuarios",
										"1 Agregar Usuario",
										"2 Modificar Usuario",
										"3 Borrar Usuario",
										"4 Ver Listado de Comics",
										"5 Agregar Comic",
										"6 Modificar Comic",
										"7 Borrar Comic",
										"8 Ver Listado de Préstamos",
										"9 Aceptar Préstamo",
										"10 Rechazar Préstamo",
										"11 Ver Listado de Géneros",
										"12 Agregar Género",
										"13 Modificar Género",
										"14 Borrar Género",
										"15 Log Out",
										"16 Salir"};
	
	final private Action[] methods = new Action[]{
			new Action(){public Person method(){ return listOfUsers();}},//0
			new Action(){public Person method(){ return addUser();}},//1
			new Action(){public Person method(){ return editUser();}},//2
			new Action(){public Person method(){ return removeUser();}},//3
			new Action(){public Person method(){ return listOfComics();}},//4
			new Action(){public Person method(){ return addComic();}},//5
			new Action(){public Person method(){ return editComic();}},//6
			new Action(){public Person method(){ return removeComic();}},//7
			new Action(){public Person method(){ return listOfLoans();}},//8
			new Action(){public Person method(){ return acceptLoan();}},//9
			new Action(){public Person method(){ return rejectLoan();}},//10
			new Action(){public Person method(){ return listOfGenres();}},//11
			new Action(){public Person method(){ return addGenre();}},//12
			new Action(){public Person method(){ return editGenre();}},//13
			new Action(){public Person method(){ return removeGenre();}},//14
			new Action(){public Person method(){ return exit();}},//15 log out
			new Action(){public Person method(){ return exit();}},//16
	}; 
	
	public UserAdmin() {
		super("Sheldon", "Bazinga");
	}

	public String[] getOperaciones() {
		return operaciones;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public Person method(int index) {
		return methods[index].method();
	}

	// 0
	public Person listOfUsers() {
		return this;
	}

	// 1
	public Person addUser() {
		return this;
	}

	// 2
	public Person editUser() {
		return this;
	}

	// 3
	public Person removeUser() {
		return this;
	}

	// 4
	/*
	 * public void listOfComics(){
	 * 
	 * }Ya está en person
	 */

	// 5
	public Person addComic() {
		return this;
	}

	// 6
	public Person editComic() {
		return this;
	}

	// 7
	public Person removeComic() {
		return this;
	}

	// 8
	public Person listOfLoans() {
		return this;
	}

	// 9
	public Person acceptLoan() {
		return this;
	}

	// 10
	public Person rejectLoan() {
		return this;
	}

	// 11
	public Person listOfGenres() {
		return this;
	}

	// 12
	public Person addGenre() {
		return this;
	}

	// 13
	public Person editGenre() {
		return this;
	}

	// 14
	public Person removeGenre() {
		return this;
	}
}
