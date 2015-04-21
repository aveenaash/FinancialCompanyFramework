/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;


import java.awt.event.ActionEvent;
import java.util.Date;

import com.bank.AccType;
import com.bank.view.PersonDialog;
import com.finco.framework.model.Address;
import com.finco.framework.model.Customer;
import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.ICustomer;
import com.finco.framework.model.Personal;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.AccountFactory;
import com.finco.framework.model.account.IAccount;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.controller.AccountController;

/**
 *
 * @author
 */
public class PersonController extends AccountController {

    public PersonController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    	ApplicationForm accountFrm=ApplicationFactory.getFinancialAppFormIntance();
        PersonDialog pac = new PersonDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void createAccount(AccType acctype,String name, String ct, String st, String str, String zip, String acnr, String bd, String em) {
    	
    	Account account = AccountFactory.getInstance(acctype);
    	account.setAccountNumber(acnr);			
		Customer personal = CustomerFactory.getInstance("Personal", name, str, ct, st, zip, new Date(bd), em);
		personal.setAccount(account);
    	
		Account aAccount = (Account) account;
        
        aAccount.setAccountNumber(acnr);
        account = aAccount;

        Personal c = (Personal) personal;
        c.setName(name);
        Address a=new Address(st, ct, st, zip, em);
        try{
            c.setBirthDate(new Date(bd));
        }catch(IllegalArgumentException e){
            System.err.println("IllegalArgumentException in setDateOfBirth");
        }
        personal = c;
        personal.setAddress(a);
        personal.setAccount((Account)account);
        ApplicationFactory.getabstractControllerIntance().createAccount((Account)account);
        
    }
}
