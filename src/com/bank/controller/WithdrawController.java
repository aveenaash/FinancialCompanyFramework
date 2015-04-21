/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;


import java.awt.event.ActionEvent;
import java.util.List;

import com.bank.view.WithdrawDialog;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.Deposit;
import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.model.account.Withdraw;
import com.finco.framework.search.SearchAccount;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;

/**
 *
 * @author james
 */
public class WithdrawController extends com.framework.finco.controller.WithdrawController{

    public WithdrawController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    	ApplicationForm accountFrm=ApplicationFactory.getFinancialAppFormIntance();
        String accnr = accountFrm.getAccountNo();
        WithdrawDialog dep = new WithdrawDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }
    
    public void withdraw(String accountNumber, double amount, String note){
    	//Account account = new Account();
    	List<Account> accounts = ApplicationFactory.getabstractControllerIntance().getAccountList();
    	SearchAccount searchAccount = new SearchAccount(accounts);
		List<Account> searchedAccounts = searchAccount.search(accountNumber);
		if(searchedAccounts.size() == 1){
			searchedAccounts.get(0).addEntry(new TransactionEntry(new Withdraw(), amount, note));
			System.out.print("Withdraw amount : "+amount);
		}else{
			System.out.print("Account found "+searchedAccounts.size());
		}
		ApplicationFactory.getFinancialAppFormIntance().loadTableWithData();
    }

}
