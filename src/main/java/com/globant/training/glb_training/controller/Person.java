package com.globant.training.glb_training.controller;

import java.util.TreeSet;

import com.globant.training.glb_training.model.Catalog;
import com.globant.training.glb_training.view.Reader;
import com.globant.training.glb_training.view.Writer;


public class Person {
	final private String[] operaciones = {"( 0 ) Ver Listado de Comics.",
											"( 1 ) Loguearse.",
											"( 2 ) Salir."};

	interface Action {
		Person method();
	}

	final private Action[] methods = new Action[]{
			new Action(){public Person method(){ return listOfComics();}},//0
			new Action(){public Person method(){ return logIn();}},//1
			new Action(){public Person method(){ return exit();}},//2
			}; 
	
	
	//0
	public Person listOfComics(){
		Catalog.getComics().forEach(s -> Writer.write(s.toString()));
		return this;
	}
	
	//1
	public Person logIn() {
		Writer.write("\n--Ingrese usuario y contraseña--\n");
		User usuario =	LogIn.login(Reader.readString(),Reader.readString());
		if(usuario == null){
			Writer.write("Log In fallido");
			return this;
		}
		Writer.write("Log In Exitoso");
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
	public TreeSet<Comic> getComics() {
		return Catalog.getComics();
	}
}
