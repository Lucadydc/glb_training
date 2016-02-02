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
										"14 Borrar Género"};
	
	final private Action[] methods = new Action[]{
			new Action(){public void method(){ listOfUsers();}},//0
			new Action(){public void method(){ addUser();}},//1
			new Action(){public void method(){ editUser();}},//2
			new Action(){public void method(){ removeUser();}},//3
			new Action(){public void method(){ listOfComics();}},//4
			new Action(){public void method(){ addComic();}},//5
			new Action(){public void method(){ editComic();}},//6
			new Action(){public void method(){ removeComic();}},//7
			new Action(){public void method(){ listOfLoans();}},//8
			new Action(){public void method(){ acceptLoan();}},//9
			new Action(){public void method(){ rejectLoan();}},//10
			new Action(){public void method(){ listOfGenres();}},//11
			new Action(){public void method(){ addGenre();}},//12
			new Action(){public void method(){ editGenre();}},//13
			new Action(){public void method(){ removeGenre();}},//14
	}; 
	public String[] getOperaciones(){
		return operaciones;
	}
	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
	
	public void method(int index){
		methods[index].method();
	}
	
	//0
	public void listOfUsers(){
		System.out.println("Esa");
	}
	
	//1
	public void addUser(){
		
	}
	
	//2
	public void editUser(){
		
	}
	
	//3
	public void removeUser(){
		
	}
	
	//4
	/*
	public void listOfComics(){
		
	}Ya está en person*/
	
	//5
	public void addComic(){
		
	}
	
	//6
	public void editComic(){
		
	}
	
	//7
	public void removeComic(){
		
	}
	
	//8
	public void listOfLoans(){
		
	}
	
	//9
	public void acceptLoan(){
		
	}
	
	//10 
	public void rejectLoan(){
		
	}
	
	//11
	public void listOfGenres(){
		
	}
	
	//12 
	public void addGenre(){
		
	}
	
	//13
	public void editGenre(){
		
	}
	
	//14
	public void removeGenre(){
		
	}
}
