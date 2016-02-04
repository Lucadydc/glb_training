package com.globant.training.glb_training.main;

import java.util.InputMismatchException;

import com.globant.training.glb_training.controller.Comic;
import com.globant.training.glb_training.controller.Person;
import com.globant.training.glb_training.controller.User;
import com.globant.training.glb_training.model.Catalog;
import com.globant.training.glb_training.view.Reader;
import com.globant.training.glb_training.view.Writer;

public class App {
	
	
	public static void main(String[] args) {
		Catalog.addGenre("Superheroes");
		Catalog.addComic(new Comic("Superman", "Superheroes", 1));
		Catalog.addComic(new Comic("Superman", "Superheroes", 2));
		Catalog.addComic(new Comic("Spiderman", "Superheroes", 1));
		Catalog.addUser(new User("pepe","mujica"));
		Catalog.addUser(new User("user","pass"));
		Catalog.addUser(new User("hola","123"));
		
		Person persona = new Person();
		do{
			try {
				Writer.write("\n--Menú Principal--\n");
				persona = persona.method(opciones(persona.getOperaciones()));
			} catch (IndexOutOfBoundsException e) {
				Writer.write("\n--Entrada errónea--\n");
			} catch(InputMismatchException e){
				Writer.write("\n--Entrada errónea--\n");
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
		
		
