package com.finco.framework.model.report;

import java.util.Date;
import java.util.Iterator;

import com.finco.framework.model.ICustomer;
import com.finco.framework.model.account.TransactionEntry;

public class YearlyReport extends Report{

	protected ICustomer customer;
	protected Date date;
	
	public YearlyReport(ICustomer customer, Date date){
		this.customer = customer;
		this.date = date;
	}	
	
	@Override
	public String printCustomerInfo(){
		StringBuilder output = new StringBuilder();
		output.append("Name= " + customer.getName() + "\n");
		output.append("Address= " + customer.getAddress().toString() + "\n");
		return output.toString();
	}
	
	@Override
	public String printAccountInfo(){
		StringBuilder output = new StringBuilder();
		output.append(customer.getAccount().getAccountNumber() + "\n");		
		return output.toString();
	}
	
	@Override
	public String printTransactionSummary(){
		StringBuilder output = new StringBuilder();
		YearlyPredicate currentYearPredicate = new YearlyPredicate(date);		
		
		Iterator<TransactionEntry> entryIterator = customer.getAccount().getTransactionList().iterator();
		
		double previousBalance = 0;
		double totalDeposit = 0;
		double totalWithdraw = 0;
		double balance = 0;
		
		while(entryIterator.hasNext()){
			TransactionEntry entry = entryIterator.next();
			if(currentYearPredicate.check(entry)){				
				if(entry.getTransactionType().getAmount(entry.getAmount()) < 0){
					totalWithdraw += entry.getTransactionType().getAmount(entry.getAmount());
				}
				else{
					totalDeposit += entry.getTransactionType().getAmount(entry.getAmount());
				}
			}
			else{
				previousBalance += entry.getTransactionType().getAmount(entry.getAmount());
			}	
			
			balance += entry.getTransactionType().getAmount(entry.getAmount());
		}			
		
		output.append("Previous Balance= " + previousBalance + "\n");
		output.append("Total Deposit= " + totalDeposit + "\n");
		output.append("Total Withdraw= " + totalWithdraw + "\n");
		output.append("Current Balance= " + balance + "\n");
		
		return output.toString();
	}

}
