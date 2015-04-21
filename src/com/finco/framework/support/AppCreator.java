package com.finco.framework.support;

import com.finco.framework.view.FinancialAppForm;

public class AppCreator {

	private static FinancialAppForm financialAppForm = null;

	public static void setFinancialAppForm(FinancialAppForm accountFrm) {
		financialAppForm = accountFrm;
	}

	public static FinancialAppForm getFinancialAppFormIntance() {
		if (financialAppForm == null) {
			financialAppForm = new FinancialAppForm();
		}
		return financialAppForm;
	}
}
