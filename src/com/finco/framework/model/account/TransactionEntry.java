package com.finco.framework.model.account;

import java.util.Date;

public class TransactionEntry implements IEntry {
	
	private double amount;
	private TransactionType transactionType;
	private Date date;
	private String note;
	
	
	
	public TransactionEntry(TransactionType transactionType, double amount, String note) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.date = new Date();
		this.note = note;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
}
