package com.bank;

import com.finco.framework.model.account.Account;
import java.util.Date;

public class GoldAccount extends Account {

	private double interestRate = 0.06;
        
        private Date expDate;

        public GoldAccount() {
		super();
                this.expDate = new Date();
	}

	public GoldAccount(String accountNumber) {
		super(accountNumber);
	}

        public Date getExpDate() {
            return expDate;
        }

        public void setExpDate(Date expDate) {
            this.expDate = expDate;
        }
        
	@Override
	public String getType() {
		return "Gold";
	}
        
        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
        
        
        @Override
        public double getInterestAmount() {
                //System.out.println("Balance  "+getBalance());
                //System.out.println("Interest  "+interestRate*getBalance());
                return interestRate*getBalance();
        }

}
