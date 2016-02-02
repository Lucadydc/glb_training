package com.globant.training.glb_training;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	final static String[] setOperacionesUno = { "Elegir Opcion: ", "1 Volver", "2 Log in", "3 Lista de Comics" };
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean flag = true;
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
		s.close();
	}

	private static int opciones(String[] op) throws InputMismatchException {
		for (String s : op)
			System.out.println(s);
		int i = s.nextInt();
		return i;
	}

}
