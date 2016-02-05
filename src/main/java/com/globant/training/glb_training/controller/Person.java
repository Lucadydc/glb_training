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
		Writer.write("\n--Listado de Comics--\n");
		Writer.write(String.format("%-16s %-16s %-16s %-16s", "Nombre","Volumen","Género","Copias Disponibles"));
		Catalog.getComics().forEach(s -> Writer.write(s.toString()));
		return this;
	}
	
	//1
	public Person logIn() {
		Writer.write("\n--Login--\n");
		Writer.write("\n--Ingrese usuario y contraseña--\n");
		User usuario =	LogIn.login(Reader.readString(),Reader.readString());
		if(usuario == null){
			Writer.write("\n--Log In fallido--\n");
			return this;
		}
		Writer.write("\n--Log In Exitoso--\n");
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
