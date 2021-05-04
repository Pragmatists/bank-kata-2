package com.pragmatists;

import com.pragmatists.domain.Amount;
import com.pragmatists.domain.Transaction;
import com.pragmatists.domain.Transactions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TransactionsShould {

	private Transactions transactions;

	@Before
	public void initialise() {
	    transactions = new Transactions();
	}

	@Test public void
	return_transactions_on_the_same_order_they_were_added() {
		Transaction deposit = new Transaction(LocalDate.of(2014,4,10), Amount.amountOf(100));
		Transaction withdrawal = new Transaction(LocalDate.of(2014,4,10), Amount.amountOf(50));

		transactions.add(deposit);
		transactions.add(withdrawal);

		List<Transaction> transactionList = transactions.all();

		assertThat(transactionList.size(), is(2));
		assertThat(transactionList.get(0), is(deposit));
		assertThat(transactionList.get(1), is(withdrawal));
	}

}
