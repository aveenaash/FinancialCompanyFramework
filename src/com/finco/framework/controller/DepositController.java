package com.finco.framework.controller;

import java.awt.event.ActionEvent;

import com.finco.framework.controller.Controller;
import com.finco.framework.view.DepositViewDialog;
import com.finco.framework.view.FinancialAppForm;

public class DepositController implements Controller {

	@Override
    public void actionPerformed(ActionEvent ae) {
        FinancialAppForm financialAppForm =new FinancialAppForm();
        String accnr = financialAppForm.getAccountnr();
        DepositViewDialog dep = new DepositViewDialog(financialAppForm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

}
