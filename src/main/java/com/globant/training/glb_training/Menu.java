package com.globant.training.glb_training;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static int opciones(String[] args) throws InputMismatchException {
		for (String s : args) {
			System.out.println(s);
		}
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		s.close();
		return i;
	}
}
