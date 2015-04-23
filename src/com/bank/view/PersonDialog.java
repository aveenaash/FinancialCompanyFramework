/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.view;


import java.awt.event.ActionEvent;

import com.bank.AccType;
import com.bank.controller.PersonController;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.AccountDialog;

public class PersonDialog extends AccountDialog {

    private PersonController pc;
    public PersonDialog(PersonController pc, ApplicationForm parent) {
        super(parent);
        setTitle("Add Person Account");
        this.pc = pc;
        JLabel6.setText("Birthdate");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);

    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name, ct, st, str, zip, acnr, bd, em;
        name = JTextField_NAME.getText();
        ct = JTextField_CT.getText();
        st = JTextField_ST.getText();
        str = JTextField_STR.getText();
        zip = JTextField_ZIP.getText();
        acnr = JTextField_ACNR.getText();
        bd = JTextField_BD.getText();
        em = JTextField_EM.getText();
        if (JRadioButton_Chk.isSelected()) {
            //new PersonController().createAccount(AccType.CHECKING,name, ct, st, str, zip, acnr, bd, em);
            this.pc.createAccount(AccType.CHECKING,name, ct, st, str, zip, acnr, bd, em);
        } else if (JRadioButton_Sav.isSelected()) {
            //new PersonController().createAccount(AccType.SAVING, name, ct, st, str, zip, acnr, bd, em);
            this.pc.createAccount(AccType.SAVING, name, ct, st, str, zip, acnr, bd, em);
        }
        dispose();
        setVisible(false);
    }

}
