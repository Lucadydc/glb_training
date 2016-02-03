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
				persona = persona.method(opciones(persona.getOperaciones()));
			} catch (InputMismatchException e) {
				System.out.println("Entrada errónea.");
			}
		}while(persona != null);
		Reader.close();
	}

	private static int opciones(String[] op) throws InputMismatchException {
		for (String s : op)
			System.out.println(s);
		int i = Reader.readInt();
		return i;
	}

}		
		
		
		
		
		
/*		boolean flag = true;
		do {
			// log in o lista de comics
			switch (opciones(setOperacionesUno)) {
			case 1:
				break;
			case 2:
				// log in
				UserAdmin admin = new UserAdmin();
				admin.method(opciones(admin.getOperaciones()));
				
				
				flag = false;
				break;
			case 3:
				// lista de comics
				flag = false;
				break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		} while (flag);
		s.close();*/

