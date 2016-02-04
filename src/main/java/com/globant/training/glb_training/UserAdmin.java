package com.globant.training.glb_training;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
			new Action(){public Person method(){ return listOfUsers();}},//0 listo
			new Action(){public Person method(){ return addUser();}},//1 listo
			new Action(){public Person method(){ return editUser();}},//2 listo
			new Action(){public Person method(){ return removeUser();}},//3 listo
			new Action(){public Person method(){ return listOfComics();}},//4 listo
			new Action(){public Person method(){ return addComic();}},//5 listo
			new Action(){public Person method(){ return editComic();}},//6
			new Action(){public Person method(){ return removeComic();}},//7
			new Action(){public Person method(){ return listOfLoans();}},//8 listo
			new Action(){public Person method(){ return acceptLoan();}},//9 listo
			new Action(){public Person method(){ return rejectLoan();}},//10 listo
			new Action(){public Person method(){ return listOfGenres();}},//11 listo
			new Action(){public Person method(){ return addGenre();}},//12 listo
			new Action(){public Person method(){ return editGenre();}},//13 listo
			new Action(){public Person method(){ return removeGenre();}},//14 listo
			new Action(){public Person method(){ return logOut();}},//15  listo
			new Action(){public Person method(){ return exit();}},//16 listo
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
		Catalog.getUsers().forEach(s->System.out.println(s.toString()));
		return this;
	}

	// 1
	public Person addUser() {
		System.out.println("\n--Ingrese Usuario y Contraseña del nuevo Usuario--\n");
		Catalog.addUser(new User(Reader.readString(),Reader.readString()));
		return this;
	}

	// 2
	public Person editUser() {
		System.out.println("\n--El usuario deberá reingresar todos sus préstamos--\n¿Continuar?(y/n)");
		switch (Reader.readString().toLowerCase()) {
		case "y":
			this.removeUser();
			this.addUser();
			break;
		case "n":
			break;
		default:
			return this.editUser();
		}
		return this;
	}

	// 3
	public Person removeUser() {
		if(Catalog.getUsers().size()==0){
			System.out.println("No hay usuarios.\n");
			return this;
		}
		System.out.println("\n--Elija un usuario de la lista para borrar--\n");
		ArrayList<User> usuarios = new ArrayList<User>(Catalog.getUsers());
		for(int i =0;i<usuarios.size();i++)System.out.println(i+ " " + usuarios.get(i).toString());
		if(Catalog.removeUser(usuarios.get(Reader.readInt()))){
			System.out.println("\n--Usuario borrado--\n");
			return this;
		}
		System.out.println("\n--El Usuario no pudo ser borrado--\n");
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
		System.out.println("\n--Elija un género--\n");
		ArrayList<String> generos = new ArrayList<String>(Catalog.getGenres());
		for(int i = 0; i<generos.size();i++){
			System.out.println(i+ " " + generos.get(i));
		}
		int genero = Reader.readInt();
		generos.get(genero);
		System.out.println("\n--Ingrese Nombre(no se admiten espacios, usar '-') y Volumen--\n");
		Comic comic = new Comic(Reader.readString(),generos.get(genero), Reader.readInt());
		Catalog.addComic(comic);		
		return this;
	}

	// 6
	public Person editComic() {
		ArrayList<Comic> comics = new ArrayList<Comic>(Catalog.getComics());
		System.out.println("\n--Elija el Comic que desea editar--\n");
		for (int i = 0; i < comics.size(); i++)
			System.out.println(i + " " + comics.get(i));
		Comic originalComic = comics.get(Reader.readInt());
		if (Catalog.getComics().contains(originalComic)) {
			System.out.println("\n--Ingrese nuevo Nombre (no se admiten espacios, usar '-') y Volumen--\n");
			Catalog.editComic(originalComic, Reader.readString(),Reader.readInt());
			System.out.println("\n--Edición Exitosa--\n");
			return this;
		}
		System.out.println("\n--Edición Fallida--\n");
		return this;
	}

	// 7
	public Person removeComic() {
		System.out.println("\n--Se borrarán todos los ejemplares del Comic--\n¿Continuar?(y/n)");
		switch (Reader.readString().toLowerCase()) {
		case "y":
			ArrayList<Comic> comics = new ArrayList<Comic>(Catalog.getComics());
			System.out.println("\n--Elija el Comic que desea borrar--\n");
			for (int i = 0; i < comics.size(); i++)
				System.out.println(i + " " + comics.get(i));
			if(Catalog.removeComic(comics.get(Reader.readInt()))){
				System.out.println("\n--El comic se borró exitosamente--\n");
				return this;
			}
			System.out.println("\n--El comic no pudo ser borrado--\n");
			break;
		case "n":
			break;
		default:
			return this.removeComic();
		}
		return this;
	}

	// 8
	public Person listOfLoans() {
		Catalog.getLoans().stream().forEach(s->System.out.println(s.toString()));
		return this;
	}

	// 9
	public Person acceptLoan() {
		ArrayList<Loan>loans= new ArrayList<Loan>(Catalog.getLoans().stream().filter(s->s.getStatus().equals("Pending Approval")).collect(Collectors.toList()));
		if(loans.size()==0){
			System.out.println("\n--No hay préstamos pendientes de aprobación--\n");
			return this;
		}
		for(int i = 0; i<loans.size();i++){
			System.out.println(i+ " " + loans.get(i));
		}
		if(Catalog.addLoan(loans.get(Reader.readInt()))){
			System.out.println("\n--Préstamo aceptado--\n");
			return this;
		}
		System.out.println("\n--El préstamo no pudo aceptarse--\n");
		return this;
	}

	// 10
	public Person rejectLoan() {
		ArrayList<Loan>loans= new ArrayList<Loan>(Catalog.getLoans().stream().filter(s->s.getStatus().equals("Pending Approval")).collect(Collectors.toList()));
		if(loans.size()==0){
			System.out.println("\n--No hay préstamos pendientes de aprobación--\n");
			return this;
		}
		for(int i = 0; i<loans.size();i++){
			System.out.println(i+ " " + loans.get(i));
		}
		Catalog.removeLoan(loans.get(Reader.readInt()));
		return this;
	}

	// 11
	public Person listOfGenres() {
		Catalog.getGenres().forEach(s->System.out.println(s.toString()));
		return this;
	}

	// 12
	public Person addGenre() {
		System.out.println("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		Catalog.addGenre(Reader.readString());
		return this;
	}

	// 13
	public Person editGenre() {
		System.out.println("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		String originalGenre = Reader.readString();
		if (Catalog.getGenres().contains(originalGenre)) {
			System.out.println("\n--Ingrese el nuevo género (no se admiten espacios, usar '-')--\n");
			Catalog.editGenre(originalGenre, Reader.readString());
			System.out.println("\n--Edición Exitosa--\n");
			return this;
		}
		System.out.println("\n--Edición Fallida--\n");
		return this;
	}

	// 14
	public Person removeGenre() {
		System.out.println("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		if(Catalog.removeGenre(Reader.readString())){
			System.out.println("\n--Se borró el género de manera satisfactoria--\n");
			return this;
		}
		System.out.println("\n--No se pudo borrar el género--\n(No existe o hay comics ingresados con ese género)");
		return this;
	}
}
