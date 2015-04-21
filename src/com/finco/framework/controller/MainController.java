package com.finco.framework.controller;

public class MainController extends AbstractController{
	
	public static void main(String[] args){
		MainController mainController = new MainController();
		mainController.createAccount();
		
		mainController.displayAllAccountInformation();
	}

}
