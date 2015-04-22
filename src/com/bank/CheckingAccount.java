package com.bank;

import com.finco.framework.model.account.Account;

public class CheckingAccount extends Account {

	private double interestRate = 0.04;

        public CheckingAccount() {
		super();
	}

	public CheckingAccount(String accountNumber) {
		super(accountNumber);
	}

	@Override
	public String getType() {
		return "Ch";
	}
        
        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
        
        
        @Override
        public double getInterestAmount() {
                System.out.println("Balance  "+getBalance());
                System.out.println("Interest  "+interestRate*getBalance());
                return interestRate*getBalance();
        }

}
