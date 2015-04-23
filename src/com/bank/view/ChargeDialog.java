/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.view;


import com.bank.controller.DepositController;
import com.bank.controller.ChargeController;
import com.bank.model.MyMediator;
import com.finco.framework.model.Mediator;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.TransactionDialog;

import java.awt.event.ActionEvent;

public class ChargeDialog extends TransactionDialog {

    ChargeController wc;
    public ChargeDialog(ChargeController wc, ApplicationForm parent, String aaccnr) {
        super(parent, aaccnr);
        setTitle("Withdraw Money");
        this.wc = wc;
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name = JTextField_NAME.getText();
        double amount = Double.parseDouble(JTextField_Deposit.getText());
        //new ChargeController().withdraw(this.getAccnr(), amount, name);
        wc.withdraw(this.getAccnr(), amount, name);
        dispose();
        setVisible(false);
        MyMediator.getInstance().notifyView(false);
    }
}
