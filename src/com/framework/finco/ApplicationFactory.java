package com.framework.finco;

import com.framework.finco.manager.AbstractController;

public class ApplicationFactory {

	private static ApplicationForm financialAppForm = null;
	private static AbstractController abstractController=null;
	
	public static void setFinancialAppForm(ApplicationForm accountFrm) {
		financialAppForm = accountFrm;
	}

	public static ApplicationForm getFinancialAppFormIntance() {
		if (financialAppForm == null) {
			financialAppForm = new ApplicationForm();
		}
		return financialAppForm;
	}
	
	public static void setFinancialAppForm(AbstractController accountCont) {
		abstractController = accountCont;
	}
	public static AbstractController getabstractControllerIntance() {
		if (abstractController == null) {
			abstractController = new AbstractController();
		}
		return abstractController;
	}
}
