package com.finco.framework.model;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.framework.finco.ApplicationFactory;


public class Mediator {
    
    protected JButton JButton_Deposit;
    protected JButton JButton_Withdraw;
    protected JButton JButton_Addinterest;
    
    private static Mediator instance;

    public Mediator() {
    	JButton_Deposit = new JButton();
    	JButton_Withdraw = new JButton();
    	JButton_Addinterest = new JButton();
    }
    
    public static Mediator getInstance() {
        if (instance == null) {
            instance = new Mediator();
        }
        return instance;
    }
    
    public void registerBtnDeposit(JButton jBtnDeposit){
        this.JButton_Deposit = jBtnDeposit;
    }
    
    public void registerBtnWithdraw(JButton jBtnWithdraw){
        this.JButton_Withdraw = jBtnWithdraw;
    }
    
    public void registerBtnAddinterest(JButton jBtnAddinterest){
        this.JButton_Addinterest = jBtnAddinterest;
    }
    
    public void notifyView(double balance, int totalAcccount){
    	JButton_Deposit.setEnabled(true);
    	if(totalAcccount > 0){
    		JButton_Addinterest.setEnabled(true);
    	}else{
    		JButton_Addinterest.setEnabled(false);
    	}
    	if (balance > 0) {
        	JButton_Withdraw.setEnabled(true);
        } else {
        	JButton_Withdraw.setEnabled(false);
        }
    }
    
    public void notifyView(boolean visible){
    	int totalNumberOfAcccount = ApplicationFactory.getabstractControllerIntance().getAccountList().size();
    	//System.out.println("notify======"+JButton_Deposit.getText()+" ==== "+JButton_Withdraw.getText());
    	JButton_Deposit.setEnabled(visible);
    	JButton_Withdraw.setEnabled(visible);
    	if(totalNumberOfAcccount > 0){
    		JButton_Addinterest.setEnabled(true);
    	}else{
    		JButton_Addinterest.setEnabled(false);
    	}
    }
    
}
