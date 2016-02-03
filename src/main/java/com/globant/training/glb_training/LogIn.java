package com.globant.training.glb_training;

public class LogIn {
	public static User login(String user, String pass) {
		if(user.equals("Sheldon") && pass.equals("Bazinga")){
			return new UserAdmin();
		}
		User usuario = new User(user,pass);
		if(Catalog.getUsers().contains(usuario)){
			return usuario;
		}
		return null;
		
	}
}
