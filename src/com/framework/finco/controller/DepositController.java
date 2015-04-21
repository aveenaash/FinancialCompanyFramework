/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;


import java.awt.event.ActionEvent;

import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.TransactionDialog;

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
        TransactionDialog dep = new TransactionDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
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
