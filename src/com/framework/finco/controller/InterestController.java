/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.finco.controller;

import com.framework.finco.ApplicationFactory;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abinash
 */
public class InterestController implements Controller {

    //private AccountManager accountManager = null;

    public InterestController() {
        //accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            //accountManager.addInterest();
            ApplicationFactory.getabstractControllerIntance().addInterestToAllAccount();
       } catch (Exception ex) {
            Logger.getLogger(InterestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
