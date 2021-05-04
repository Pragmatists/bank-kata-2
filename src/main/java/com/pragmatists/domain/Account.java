package com.pragmatists.domain;

import com.pragmatists.StatementPrinter;

public class Account {

	private final Clock clock;
	private final Transactions transactions;
	private final StatementPrinter statementPrinter;

	public Account(Clock clock, Transactions transactions, StatementPrinter statementPrinter) {
		this.clock = clock;
		this.transactions = transactions;
		this.statementPrinter = statementPrinter;
	}

	public static Account newAccount(Clock clock, StatementPrinter statementPrinter){
		return new Account(clock, new Transactions(), statementPrinter);
	}

	public void deposit(Amount amount) {
		Transaction deposit = new Transaction(clock.date(), amount);
		transactions.add(deposit);
	}

	public void withdraw(Amount amount) {
		Transaction deposit = new Transaction(clock.date(), amount.negative());
		transactions.add(deposit);
	}

	public void printStatement() {
		statementPrinter.print(transactions.all());
	}

}
