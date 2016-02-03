package com.globant.training.glb_training;

import java.util.InputMismatchException;

public class App {
	
	
	public static void main(String[] args) {
		Catalog.addComic(new Comic("Superman", "Superheroes", 1));
		Catalog.addComic(new Comic("Superman", "Superheroes", 2));
		Catalog.addComic(new Comic("Spiderman", "Superheroes", 1));
		Catalog.addUser(new User("pepe","mujica"));
		Catalog.addUser(new User("user","pass"));
		Catalog.addUser(new User("hola","123"));
		
		Person persona = new Person();
		do{
			try {
				System.out.println("\n--Menú Principal--\n");
				persona = persona.method(opciones(persona.getOperaciones()));
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Entrada errónea.\n");
			} catch(InputMismatchException e){
				System.out.println("Entrada errónea.\n");
				Reader.readString();
			}
		}while(persona != null);
		Reader.close();
	}

	private static int opciones(String[] op) {
		for (String s : op)
			System.out.println(s);
		int i = Reader.readInt();
		return i;
	}

}		
		
		
