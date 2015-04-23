/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;


import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.model.account.Withdraw;
import com.finco.framework.search.SearchAccount;
import java.awt.event.ActionEvent;

import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.TransactionDialog;
import java.util.List;

/**
 *
 * @author abinash
 */
public class WithdrawController implements Controller {

    //private AccountManager accountManager = null;

    public WithdrawController() {
     //   accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ApplicationForm accountFrm = ApplicationFactory.getFinancialAppFormIntance();
        String accnr = accountFrm.getAccountNo();
        TransactionDialog dep = new TransactionDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

    public WithdrawController(String accrno, String amount) {
        this();
    }
    
//    public void withdraw(String accountNumber, double amount, String note){
//    	//Account account = new Account();
//    	List<Account> accounts = ApplicationFactory.getabstractControllerIntance().getAccountList();
//    	SearchAccount searchAccount = new SearchAccount(accounts);
//		List<Account> searchedAccounts = searchAccount.search(accountNumber);
//		if(searchedAccounts.size() == 1){
//			if(searchedAccounts.get(0).getBalance() > amount){
//				searchedAccounts.get(0).addEntry(new TransactionEntry(new Withdraw(), amount, note));
//				//System.out.print("Withdraw amount : "+amount);
//			}else{
//				//System.out.print("You do not have enough amount.");
//				ApplicationForm.showMessage("You do not have that amount to withdraw.");
//			}
//			
//		}else{
//			//System.out.print("Account found "+searchedAccounts.size());
//		}
//		ApplicationFactory.getFinancialAppFormIntance().loadTableWithData();
//    }

//    public void withdraw(String accrno, String amount, String name) {
//        try {
//            IAccount account = accountManager.getAccountById(accrno);
//            ITransaction iTransaction = FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.WITHDRAW);
//            iTransaction.setAmount(Double.parseDouble(amount));
//            iTransaction.setName(name);
//            accountManager.Withdraw(account, iTransaction);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
