package com.pragmatists.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Transactions {
	private final List<Transaction> transactionList = new ArrayList<>();

	public void add(Transaction transaction) {
		transactionList.add(transaction);
	}

	public List<Transaction> all() {
		return unmodifiableList(transactionList);
	}
}
