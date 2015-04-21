package com.finco.framework.view;

import java.awt.event.ActionEvent;

import com.finco.framework.controller.Controller;
import com.finco.framework.support.AppCreator;
import com.finco.framework.view.FinancialAppForm;

public class PersonalAccountController implements Controller {

	@Override
	public void actionPerformed(ActionEvent ae) {
		FinancialAppForm form=AppCreator.getFinancialAppFormIntance();
		PersonalAccountDialog pac = new PersonalAccountDialog(form);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}
	
	

}
