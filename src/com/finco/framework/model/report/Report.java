package com.finco.framework.model.report;

public abstract class Report implements IReport{

	@Override
	public final String getReport() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder();
		output.append(printCustomerInfo());
		output.append(printAccountInfo());
		output.append(printTransactionSummary());
		
		return output.toString();
	}

	@Override
	public abstract String printCustomerInfo();

	@Override
	public abstract String printAccountInfo();

	@Override
	public abstract String printTransactionSummary();

}
