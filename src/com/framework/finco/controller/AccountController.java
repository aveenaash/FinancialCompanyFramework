/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;

import com.finco.framework.model.Customer;
import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.Personal;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.AccountFactory;
import com.framework.finco.view.AccountDialog;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;

import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author abinash
 */
public class AccountController implements Controller {

    //private AccountManager accountManager = null;

    public AccountController() {
        //accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //get Singlton variable and pass to dailog
        ApplicationForm accountFrm = ApplicationFactory.getFinancialAppFormIntance();
        AccountDialog pac = new AccountDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    public void createAccount(String name, String ct, String st, String str, String zip, String acnr, String bd, String em) {
    	
    	Account account = AccountFactory.getInstance();
    	account.setAccountNumber(acnr);			
		Customer personal = CustomerFactory.getInstance("Personal");
		personal.setName(name);
		
		personal.getAddress().setState(st);
		personal.getAddress().setStreet(str);
		personal.getAddress().setZip(zip);
		personal.getAddress().setCity(ct);
		((Personal)personal).setBirthDate(new Date(bd));
		personal.setAccount(account);
    	
        Personal c = (Personal) personal;        
        System.out.println("Name ::: "+c.getName());
        try{
            c.setBirthDate(new Date(bd));
        }catch(IllegalArgumentException e){
            System.err.println("IllegalArgumentException in setDateOfBirth");
        }
        personal = c;
        personal.setAccount((Account)account);
        account.setCustomer(personal);
        ApplicationFactory.getabstractControllerIntance().createAccount((Account)account);
        
    }

}
