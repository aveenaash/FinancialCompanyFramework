/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.view;


import java.awt.event.ActionEvent;

import com.bank.AccType;
import com.bank.controller.CreditCardController;
import com.framework.finco.ApplicationForm;
import com.framework.finco.view.AccountDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CreditCardDialog extends AccountDialog {

    private CreditCardController pc;
    
    private JRadioButton JRadioButton_Gold = new JRadioButton();
    private JRadioButton JRadioButton_Silver = new JRadioButton();
    private JRadioButton JRadioButton_Bronze = new JRadioButton();
    
    public CreditCardDialog(CreditCardController pc, ApplicationForm parent) {
        super(parent);
        setTitle("Add Person Account");
        this.pc = pc;
        JLabel6.setText("Birthdate");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);
                
        JRadioButton_Sav.setVisible(false);
        JRadioButton_Chk.setVisible(false);
        
        buttonGroup.remove(JRadioButton_Sav);
        buttonGroup.remove(JRadioButton_Chk);
                
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Gold");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36, 0, 84, 24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Silver");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36, 20, 84, 24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Bronze");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36, 40, 84, 24);
        
        buttonGroup.add(JRadioButton_Gold);
        buttonGroup.add(JRadioButton_Silver);
        buttonGroup.add(JRadioButton_Bronze);
        
        JLabel8.setText("CC Number");

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
        if (JRadioButton_Gold.isSelected()) {
            this.pc.createAccount(AccType.GOLD,name, ct, st, str, zip, acnr, bd, em);
        } else if (JRadioButton_Silver.isSelected()) {
            this.pc.createAccount(AccType.SILVER, name, ct, st, str, zip, acnr, bd, em);
        } else if (JRadioButton_Bronze.isSelected()) {
            this.pc.createAccount(AccType.BRONZE, name, ct, st, str, zip, acnr, bd, em);
        }
        dispose();
        setVisible(false);
    }

}
