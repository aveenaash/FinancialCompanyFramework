/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import com.finco.framework.model.Mediator;
import com.framework.finco.ApplicationFactory;
import javax.swing.JButton;

/**
 *
 * @author MdRuzdi
 */
public class MyMediator extends Mediator{
    
    private static MyMediator instance;
    
    protected JButton JButton_GenerateBill;
    
    public static MyMediator getInstance() {
        if (instance == null) {
            instance = new MyMediator();
        }
        return instance;
    }
    
    
    public MyMediator(){
        super();        
        JButton_GenerateBill = new JButton();
    }
    
        
    public void registerBtnGenerateBill(JButton jBtnGenerateBill){
        this.JButton_GenerateBill = jBtnGenerateBill;
    }
    
    
    public void notifyView(boolean visible){
    	int totalNumberOfAcccount = ApplicationFactory.getabstractControllerIntance().getAccountList().size();
    	//System.out.println("notify======"+JButton_Deposit.getText()+" ==== "+JButton_Withdraw.getText());
    	JButton_Deposit.setEnabled(visible);
    	JButton_Withdraw.setEnabled(visible);
        JButton_GenerateBill.setEnabled(visible);
    	if(totalNumberOfAcccount > 0){
    		JButton_Addinterest.setEnabled(true);
    	}else{
    		JButton_Addinterest.setEnabled(false);
    	}
    }
}
