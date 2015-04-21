package com.finco.framework.controller;

import java.util.Date;
import java.util.List;

import com.finco.framework.model.account.IAccount;
import com.finco.framework.model.report.MonthlyReport;
import com.finco.framework.model.report.YearlyReport;
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
		
		System.out.println("============= Monthly Report =============");
		for(IAccount account: result){
			MonthlyReport report = new MonthlyReport(account.getCustomer(), new Date());
			System.out.println(report.getReport());
			System.out.println();
		}
		
		
		System.out.println("============= Yearly Report =============");
		for(IAccount account: result){
			YearlyReport report = new YearlyReport(account.getCustomer(), new Date());
			System.out.println(report.getReport());
			System.out.println();
		}
	}

}
