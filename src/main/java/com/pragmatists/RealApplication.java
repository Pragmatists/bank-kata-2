package com.pragmatists;

import com.pragmatists.domain.Account;
import com.pragmatists.domain.Amount;
import com.pragmatists.domain.Clock;
import com.pragmatists.domain.Transactions;

import static com.pragmatists.domain.Account.newAccount;

public class RealApplication {

	public static void main(String[] args) {
		Account account = newAccount(new Clock(), new StatementPrinter(new Console()));

		account.deposit(Amount.amountOf(1000));
		account.withdraw(Amount.amountOf(300));
		account.withdraw(Amount.amountOf(50));
		account.deposit(Amount.amountOf(500));

		account.printStatement();
	}

}
