package com.globant.training.glb_training;

import java.util.ArrayList;


public class Person {
	
	final private String[] operaciones = {"0 Ver Listado de Comics",
			"1 Loguearse",
			"10 Salir"};

	interface Action {
		void method();
	}

	final private Action[] methods = new Action[]{
			new Action(){public void method(){ listOfComics();}},//0
			new Action(){public void method(){ logIn();}},//1
			new Action(){public void method(){ exit();}},//2
			}; 
	public void listOfComics(){
		
	}
	public void logIn(){
		
	}
	public void exit(){
		
	}
	public String[] getOperaciones() {
		return operaciones;
	}

	public void method(int index) {
		methods[index].method();
	}
	public ArrayList<Comic> getComics() {
		return Catalog.getComics();
	}
}
