package com.finco.framework.controller;

import java.util.List;

import com.finco.framework.model.account.IAccount;
import com.finco.framework.search.SearchAccount;

public class MainController extends AbstractController{
	
	public static void main(String[] args){
		MainController mainController = new MainController();
		mainController.createAccount();
		
		mainController.displayAllAccountInformation();
		
		SearchAccount searchAccount = new SearchAccount(mainController.accountList);
		List<IAccount> result = searchAccount.search("John");
		
		System.out.println("Search Result: ");
		for(IAccount account: result){
			System.out.println(account.getAccountNumber() + " : " + account.getCustomer().getName());
		}
	}

}
