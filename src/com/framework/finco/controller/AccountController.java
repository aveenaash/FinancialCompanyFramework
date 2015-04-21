/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;

import com.framework.finco.view.AccountDialog;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;

import java.awt.event.ActionEvent;

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

}
