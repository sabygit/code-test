package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bank {

	private static final Logger logger = LogManager.getLogger(Bank.class);
	private Map<String, Account> accountMap;

	public Bank() {
		accountMap = new HashMap<>();
	}

	public Account getAccount(String accountNumber) {
		return accountMap.get(accountNumber);
	}

	public void addAccount(Account account) {
		accountMap.put(account.getAccountNumber(), account);
	}

	public void depositToAccount(String accountNumber, float amount) {
		getAccount(accountNumber).deposit(amount);
	}

	public void withdrawFromAccount(String accountNumber, float amount) {
		getAccount(accountNumber).withdraw(amount);
	}

	public int numAccounts() {
		return accountMap.size();
	}

	public double currentHoldingsTotal() {
		Set<Map.Entry<String, Account>> entrySet = accountMap.entrySet();
		double sumCurrentHoldings = 0.0;
		for (Entry entry : entrySet) {
			String accountNumber = (String) entry.getKey();
			sumCurrentHoldings += getAccount(accountNumber).getBalance();
		}
		return sumCurrentHoldings;

	}
	
	public String profitOrLossCalculate() {
		Set<Map.Entry<String, Account>> entrySet = accountMap.entrySet();
		double valueNextMonthTotal = 0.0;
		for (Entry entry : entrySet) {
			String accountNumber = (String) entry.getKey();
			valueNextMonthTotal += getAccount(accountNumber).valueNextMonth();
		}
		if(valueNextMonthTotal > currentHoldingsTotal() )
			return "Profit" ;
			else
				return "Loss";
		
	}
}
