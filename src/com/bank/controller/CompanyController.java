/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.controller;


import java.awt.event.ActionEvent;

import com.bank.view.CompanyDialog;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.controller.AccountController;

/**
 *
 * @author abinash
 */
public class CompanyController extends AccountController{

    public CompanyController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ApplicationForm accountFrm=ApplicationFactory.getFinancialAppFormIntance();
        CompanyDialog pac = new CompanyDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
//    public void createAccount(MyAccountType accountType,String name,String ct,String st,String str,String zip
//            ,String acnr,String noe,String em){
//        IAccount account=FactoryProducer.getFactory(MyAccountType.MYAC).getAccount(accountType);
//        AAccount aAccount = (AAccount)account;
//        aAccount.setAcctNumber(acnr);
//        
//        account = aAccount;
//        IParty party=FactoryProducer.getFactory(Types.PARTY).getParty(PartyType.COMPANY);
//        Company c=(Company)party;
//        c.setName(name);
//        c.setCity(ct);
//        c.setState(st);
//        c.setStreet(str);
//        c.setZip(zip);
//        try{
//            c.setNoOfEmployee(Integer.parseInt(noe));
//        }catch(NumberFormatException e){
//            System.err.println("Number formate in noofemplyee");
//            c.setNoOfEmployee(1);
//        }
//        c.setEmail(em);
//        party=c;
//        party.addAccount(account);
//        ClassicSingleton.getInstanceAccountManager().addAccountToList(account);
//    }
    
    
}
