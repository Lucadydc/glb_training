package com.globant.training.glb_training;

import java.util.Scanner;

public class Reader {
	private static Scanner s=new Scanner(System.in);
	
	public static void close(){
		s.close();
	}
	public static int readInt(){
		return s.nextInt();
	}
	public static String readString(){
		return s.next();
	}
}
