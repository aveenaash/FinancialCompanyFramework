/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;


import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.Deposit;
import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.search.SearchAccount;
import java.awt.event.ActionEvent;

import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.DepositDialog;
import com.framework.finco.view.TransactionDialog;
import java.util.List;

/**
 *
 * @author abinash
 */
public class DepositController implements Controller {

//    private AccountManager accountManager = null;
//
//    public DepositController() {
//        accountManager = ClassicSingleton.getInstanceAccountManager();
//    }
//
    @Override
    public void actionPerformed(ActionEvent ae) {
        ApplicationForm accountFrm = ApplicationFactory.getFinancialAppFormIntance();
        String accnr = accountFrm.getAccountNo();
        TransactionDialog dep = new DepositDialog(this, accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }
    
    public void deposit(String accountNumber, double amount, String note){
    	//Account account = new Account();
    	List<Account> accounts = ApplicationFactory.getabstractControllerIntance().getAccountList();
    	SearchAccount searchAccount = new SearchAccount(accounts);        
		List<Account> searchedAccounts = searchAccount.search(accountNumber);
		if(searchedAccounts.size() == 1){
			searchedAccounts.get(0).addEntry(new TransactionEntry(new Deposit(), amount, note));
			//System.out.print("Desite amount : "+amount);
		}else{
			//System.out.print("Account found "+searchedAccounts.size());
		}
		ApplicationFactory.getFinancialAppFormIntance().loadTableWithData();
    }
    
//
//    public DepositController(String accrno, String amount) {
//        this();
//    }
//
//    public void deposit(String accrno, String amount, String name) {
//        try {
//            IAccount account = accountManager.getAccountById(accrno);
//            ITransaction iTransaction = FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
//            iTransaction.setAmount(Double.parseDouble(amount));
//            iTransaction.setName(name);
//            accountManager.Deposit(account, iTransaction);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
