/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank;


import com.bank.controller.BillController;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bank.controller.DepositController;
import com.bank.controller.CreditCardController;
import com.bank.controller.ChargeController;
import com.bank.model.MyMediator;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.IAccount;
import com.framework.finco.ApplicationFactory;
import com.framework.finco.ApplicationForm;
import com.framework.finco.manager.AccountManager;
import javax.swing.table.DefaultTableModel;


public class CreditCardApplication extends ApplicationForm {

    static {
        //FactoryProducer.addAbstractFactory(MyAccountType.MYAC, new MyAccountFactory());
    }
    
    public static CreditCardApplication bank;
    
    protected MyMediator mediator;
    
    public static CreditCardApplication getInstance() {
        if (bank == null) {
            bank = new CreditCardApplication();
            ApplicationFactory.setFinancialAppForm(bank);
            (ApplicationFactory.getFinancialAppFormIntance()).setVisible(true);
        }
        return bank;
    }

    public CreditCardApplication() {
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
        
        JButton_PerAC.setText("Add Credit-Card Account");
        JButton_Withdraw.setText("Charge");

        JButton_CompAC.setText("Generate Monthly Bill");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 192, 33);
        
        JButton_CompAC.addActionListener(new BillController());
        JButton_PerAC.addActionListener(new CreditCardController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new ChargeController());
        
        mediator.registerBtnAddinterest(JButton_CompAC);
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
    
    protected DefaultTableModel setTableModel() {
            model = new DefaultTableModel();
            model.addColumn("AccountNr");
            model.addColumn("Name");
            model.addColumn("City");
            model.addColumn("ExpDate");
            model.addColumn("Type");
            model.addColumn("Amount");
            return model;
    }
    
    public void loadTableWithData() {
            try {
                    model.setRowCount(0);
                    AccountManager accountManager = ApplicationFactory
                                    .getabstractControllerIntance();
                    for (Account ia : accountManager.getAccountList()) {
                            rowdata = new Object[8];
                            rowdata[0] = ia.getAccountNumber();
                            //Customer cust = (Customer) ia.getCustomer();
                            //System.out.println("Customer" +cust);
                            rowdata[1] = ia.getCustomer().getName();
                            rowdata[2] = ia.getCustomer().getAddress().getCity();
                            rowdata[3] = ia.getCustomer().getType();
                            rowdata[4] = ia.getType();///////////////////////////////////////need to set exp date here
                            rowdata[5] = ia.getBalance();
                            model.addRow(rowdata);
                            System.out.println("Data loaded");
                    }
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
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
            CreditCardApplication.getInstance().setVisible(true);

            ApplicationFactory.getabstractControllerIntance().loadDummyData();   
            MyMediator.getInstance().notifyView(false);
            
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
