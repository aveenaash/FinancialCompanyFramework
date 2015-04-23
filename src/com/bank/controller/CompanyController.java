/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.controller;


import java.awt.event.ActionEvent;

import java.util.Date;

import com.bank.AccType;
import com.bank.view.CompanyDialog;
import com.finco.framework.model.Company;
import com.finco.framework.model.Customer;
import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.Personal;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.AccountFactory;

import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.controller.AccountController;

/**
 *
 * @author abinash
 */

public class CompanyController extends AccountController {

	public CompanyController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		ApplicationForm accountFrm = ApplicationFactory
				.getFinancialAppFormIntance();
		CompanyDialog pac = new CompanyDialog(this, accountFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	public void createAccount(AccType acctype, String name, String ct,
			String st, String str, String zip, String acnr, String noe,
			String em) {

		Account account = AccountFactory.getInstance(acctype);
		account.setAccountNumber(acnr);
		Customer company = CustomerFactory.getInstance("Company");
		company.setName(name);
		company.getAddress().setState(st);
		company.getAddress().setStreet(str);
		company.getAddress().setZip(zip);
		company.getAddress().setCity(ct);
		company.setAccount(account);
		Company c = (Company) company;
		try {
			c.setNoOfEmployees(Integer.parseInt(noe));
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException in setDateOfBirth");
		}
		company.setAccount((Account) account);
		ApplicationFactory.getabstractControllerIntance().createAccount(
				(Account) account);
	}

}
