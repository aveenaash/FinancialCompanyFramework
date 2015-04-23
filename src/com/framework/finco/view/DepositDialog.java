/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.view;


import com.framework.finco.controller.DepositController;
import com.framework.finco.controller.WithdrawController;
import com.finco.framework.model.Mediator;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.TransactionDialog;
import java.awt.event.ActionEvent;


/**
 *
 * @author 
 */
public class DepositDialog extends TransactionDialog {

    DepositController dc;
    public DepositDialog(DepositController dc, ApplicationForm parent, String aaccnr) {
        super(parent, aaccnr);
        setTitle("Deposit Money");
        this.dc = dc;
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name = JTextField_NAME.getText();
        double amount = Double.parseDouble(JTextField_Deposit.getText());
        //new DepositController().deposit(this.getAccnr(), amount, name);
        dc.deposit(this.getAccnr(), amount, name);
        dispose();
        setVisible(false);
        Mediator.getInstance().notifyView(false);
    }

}
