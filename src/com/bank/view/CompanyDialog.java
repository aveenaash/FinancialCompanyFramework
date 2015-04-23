/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.view;

import com.bank.AccType;

import com.bank.controller.CompanyController;

import com.framework.finco.ApplicationForm;
import com.framework.finco.view.AccountDialog;

import java.awt.event.ActionEvent;

public class CompanyDialog extends AccountDialog {

    private CompanyController cc;
    public CompanyDialog(CompanyController cc, ApplicationForm parent) {
        super(parent);
        setTitle("Add Company Account");
        this.cc = cc;

        JLabel6.setText("No of employees");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);
        repaint();
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name, ct, st, str, zip, acnr, noe, em;
        name = JTextField_NAME.getText();
        ct = JTextField_CT.getText();
        st = JTextField_ST.getText();
        str = JTextField_STR.getText();
        zip = JTextField_ZIP.getText();
        acnr = JTextField_ACNR.getText();
        noe = JTextField_BD.getText();
        em = JTextField_EM.getText();
        if (JRadioButton_Chk.isSelected()) {
            //new CompanyController().createAccount(AccType.CHECKING, name, ct, st, str, zip, acnr, noe, em);
            this.cc.createAccount(AccType.CHECKING, name, ct, st, str, zip, acnr, noe, em);
        } else if (JRadioButton_Sav.isSelected()) {
           //new CompanyController().createAccount(AccType.SAVING, name, ct, st, str, zip, acnr, noe, em);
            this.cc.createAccount(AccType.SAVING, name, ct, st, str, zip, acnr, noe, em);
        }
        dispose();
        setVisible(false);

    }

}
