/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;


import java.awt.event.ActionEvent;

import com.bank.view.WithdrawDialog;
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

}
