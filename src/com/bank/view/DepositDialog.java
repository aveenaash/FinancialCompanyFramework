/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.view;
import java.awt.event.ActionEvent;

import com.bank.controller.DepositController;
import com.bank.model.MyMediator;
import com.finco.framework.model.Mediator;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.TransactionDialog;

/**
 *
 * @author 
 */
public class DepositDialog extends TransactionDialog {

    public DepositDialog(ApplicationForm parent, String aaccnr) {
        super(parent, aaccnr);
        setTitle("Deposit Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name = JTextField_NAME.getText();
        double amount = Double.parseDouble(JTextField_Deposit.getText());
        new DepositController().deposit(this.getAccnr(), amount, name);
        dispose();
        setVisible(false);
        MyMediator.getInstance().notifyView(false);
    }

}
