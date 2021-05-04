package com.pragmatists;

import com.pragmatists.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

	private static final LocalDate SYSTEM_DATE = LocalDate.now();
	private static final List<Transaction> TRANSACTION_LIST = new ArrayList<>();

	@Mock
	Transactions transactions;
	@Mock
	Clock clock;
	@Mock StatementPrinter statementPrinter;

	private Account account;

	@Before
	public void initialise() {
		given(clock.date()).willReturn(SYSTEM_DATE);
	    account = new Account(clock, transactions, statementPrinter);
	}

	@Test public void
	store_a_deposit_transaction() {
		Transaction deposit = new Transaction(SYSTEM_DATE, Amount.amountOf(100));

		account.deposit(Amount.amountOf(100));

		verify(transactions).add(eq(deposit));
	}

	@Test public void
	store_a_withdrawal_transaction() {
		given(clock.date()).willReturn(SYSTEM_DATE);
		Transaction withdrawal = new Transaction(SYSTEM_DATE, Amount.amountOf(-100));

		account.withdraw(Amount.amountOf(100));

		verify(transactions).add(eq(withdrawal));
	}

	@Test public void
	print_a_statement_containing_all_transactions() {
		given(transactions.all()).willReturn(TRANSACTION_LIST);

		account.printStatement();

		verify(statementPrinter).print(TRANSACTION_LIST);
	}
}
