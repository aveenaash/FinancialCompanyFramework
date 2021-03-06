/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank;


import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bank.controller.CompanyController;
import com.bank.controller.DepositController;
import com.bank.controller.PersonController;
import com.bank.controller.WithdrawController;
import com.bank.model.MyMediator;
import com.finco.framework.controller.AbstractController;
import com.finco.framework.model.Mediator;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;


public class BankApplication extends ApplicationForm {

    static {
        //FactoryProducer.addAbstractFactory(MyAccountType.MYAC, new MyAccountFactory());
    }
    
    public static BankApplication bank;
    
    protected MyMediator mediator;
    
    public static BankApplication getInstance() {
        if (bank == null) {
            bank = new BankApplication();
            ApplicationFactory.setFinancialAppForm(bank);
            (ApplicationFactory.getFinancialAppFormIntance()).setVisible(true);
        }
        return bank;
    }

    public BankApplication() {
        super();
        setTitle("Bank Application");
        
        mediator = MyMediator.getInstance();

        //remove all listener that we have first
        for (ActionListener al : JButton_PerAC.getActionListeners()) {
            JButton_PerAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_CompAC.getActionListeners()) {
            JButton_CompAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_Deposit.getActionListeners()) {
            JButton_Deposit.removeActionListener(al);
        }
        for (ActionListener al : JButton_Withdraw.getActionListeners()) {
            JButton_Withdraw.removeActionListener(al);
        }

        JButton_CompAC.addActionListener(new CompanyController());
        JButton_PerAC.addActionListener(new PersonController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
        
        mediator.registerBtnAddinterest(JButton_Addinterest);
        mediator.registerBtnDeposit(JButton_Deposit);
        mediator.registerBtnWithdraw(JButton_Withdraw);
        
        table.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                            MyMediator.getInstance().notifyView(true);
                    }
            });
        
        
    }

    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            //(new Bank()).setVisible(true);         
            BankApplication.getInstance().setVisible(true);

            ApplicationFactory.getabstractControllerIntance().loadDummyData();   
            MyMediator.getInstance().notifyView(false);
            
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
