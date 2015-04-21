package com.framework.finco;

import com.framework.finco.manager.AccountManager;

public class ApplicationFactory {

	private static ApplicationForm financialAppForm = null;
	private static AccountManager accountManager=null;
	
	public static void setFinancialAppForm(ApplicationForm accountFrm) {
		financialAppForm = accountFrm;
	}

	public static ApplicationForm getFinancialAppFormIntance() {
		if (financialAppForm == null) {
			financialAppForm = new ApplicationForm();
		}
		return financialAppForm;
	}
	
	public static void setFinancialAppForm(AccountManager accountCont) {
		accountManager = accountCont;
	}
	public static AccountManager getabstractControllerIntance() {
		if (accountManager == null) {
			accountManager = new AccountManager();
		}
		return accountManager;
	}
}
