package com.globant.training.glb_training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;


public class Person {
	final private String[] operaciones = {"0 Ver Listado de Comics",
											"1 Loguearse",
											"2 Salir"};

	interface Action {
		Person method();
	}

	final private Action[] methods = new Action[]{
			new Action(){public Person method(){ return listOfComics();}},//0
			new Action(){public Person method(){ return logIn();}},//1
			new Action(){public Person method(){ return exit();}},//2
			}; 
	
	public Person(){
	}
	
	//0
	public Person listOfComics(){
		new HashSet<Comic>(Catalog.getComics()).forEach(s -> System.out.println(s));
		return this;
	}
	
	//1
	public Person logIn() throws InputMismatchException{
		System.out.println("Ingrese usuario y contraseña: ");
		User usuario =	LogIn.login(Reader.readString(),Reader.readString());
		if(usuario == null){
			System.out.println("Log In fallido");
			return this;
		}
		System.out.println("Log In Exitoso");
		return usuario;
	}
	
	//2
	public Person exit(){
		return null;
	}
	public String[] getOperaciones() {
		return operaciones;
	}

	public Person method(int index) {
		return methods[index].method();
	}
	public ArrayList<Comic> getComics() {
		return Catalog.getComics();
	}
}
